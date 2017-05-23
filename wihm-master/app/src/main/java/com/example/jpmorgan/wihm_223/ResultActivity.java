package com.example.jpmorgan.wihm_223;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {
    TextView txtDisp1;
    TextView txtAverage;
    private FirebaseDatabase mFirebaseDatabase;
    DatabaseReference ref;
    private DatabaseReference mFirebaseReference;
    private TextView allUsers;
    private TextView selectedUser;
    private Button btnstop;
    Sensor heartSen;
    String newSenName;
    String newSenAddress;
    BluetoothDevice btDev;

    //Date
    Calendar c = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());


    private boolean isRunning = true;

    private static final Random RANDOM = new Random();

    private LineGraphSeries<DataPoint> series;
    private BarGraphSeries<DataPoint> series2;
    private int lastX = 0;
    private double lastY = 0;


    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference("users");
        //mFirebaseReference.child(user.getUid()).child("sessions").child(formattedDate);
        //ref.child(list_users.get(position).getUid()).child("sessions").child("time").setValue(null);
        //ref.child(user.getUid()).child("sessions").child(formattedDate).child("heartbeats").setValue(lastX);

        btnstop = (Button) findViewById(R.id.btnstop);
        // we get graph view instance
        GraphView graph = (GraphView) findViewById(R.id.graph);
        // data
        series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);
        // customize a little bit viewport
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(220);
        //viewport.setMaxX(200);
        viewport.setScalable(true);
        viewport.setScrollable(true);
        series.setThickness(10);
        series.setColor(Color.BLACK);
        series.setDataPointsRadius(10);
        txtDisp1 = (TextView)findViewById(R.id.txtDisp1);

        txtAverage = (TextView) findViewById(R.id.txtAvg);
        user = (User) getIntent().getSerializableExtra("user");
        newSenName = getIntent().getStringExtra("name");
        newSenAddress = getIntent().getStringExtra("address");
        btDev = getIntent().getParcelableExtra("btDev");
        heartSen = new Sensor(btDev, this);
        System.out.println(user.getName());
        // TODO Vul de UI in met gegevens gebruiker
        selectedUser = (TextView) findViewById(R.id.tv_selecteduser);
        selectedUser.setText(user.getName());

btnstop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        isRunning = false;
    }
});

    }

    @Override
    protected void onPause() {
        super.onPause();
        isRunning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph
        new Thread(new Runnable() {

            @Override
            public void run() {
                // we add 100 new entries
                if (isRunning ){
                    for (int i = 0; i < 100; i--) {
                        runOnUiThread(new Runnable() {
                        

                        @Override
                        public void run() {
                            addEntry();
                        }
                    });

                        // sleep to slow down the add of entries
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // manage error ...
                        }
                    }
                }
            }
        }).start();
    }

    // random data grafiek
    private void addEntry() {
        //lastY = RANDOM.nextDouble() * 100d;
        String heartB = heartSen.heartB;
        lastY = 0;
        int heartRate = 0;
        try {
            heartRate = Integer.parseInt(heartB);
            lastY = heartRate;
            Log.d("parsed int", String.valueOf(heartRate));
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }
        //int hearRate = Integer.parseInt(heartB);
        //Log.d("parsed int", String.valueOf(hearRate));
        series.appendData(new DataPoint(lastX++, lastY), true, 100);
        txtDisp1.setText(heartB);
        //txtDisp1.setText(Double.toString(Math.round(lastY)));
        if (lastY>0){
            ref.child(user.getUid()).child(formattedDate).child("hartslag : " + lastX).setValue(lastY);
        }
        txtAverage.setText(Double.toString((lastY/lastX)/2));
    //TODO stuur data naar een veld bij de gebruiker
        //TODO Voeg een save button toe

        //TODO opslaan adhv datum --> velden: data & periode

    }


    private void addEventFireBaseListener(TextView allUsers) {

    }

}
