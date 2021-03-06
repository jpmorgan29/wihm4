package com.example.jpmorgan.wihm_223;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FindUserActivity extends AppCompatActivity {
    TextView test;

    static final int ADD_DEVICE = 123;
    //Date
    Calendar c = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());
    //Firebase
    private String selectedUser;
    private FirebaseDatabase mFirebaseDatabase;
    DatabaseReference ref;
    private DatabaseReference mFirebaseReference;
    private int selectedPosition = 0;

    private List<User> allUsers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference("users");

        addEventFireBaseListener(allUsers);
        test = (TextView) findViewById(R.id.tv_selectedUsers);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == ADD_DEVICE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                String newSenName = data.getStringExtra("name");
                String newSenAddress = data.getStringExtra("address");
                BluetoothDevice btDev = data.getParcelableExtra("btDev");

                Toast.makeText(getApplicationContext(), newSenName + newSenAddress, Toast.LENGTH_SHORT).show();

                //send data to resultActivity
                final Intent intent = new Intent(FindUserActivity.this, ResultActivity.class);
                intent.putExtra("name", newSenName);
                intent.putExtra("address", newSenAddress);
                intent.putExtra("btDev", btDev);
                intent.putExtra("user", allUsers.get(selectedPosition));

                startActivity(intent);
            }
        }
    }

    public void addEventFireBaseListener(final List<User> list_users) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(list_users.size() > 0){
                        list_users.clear();
                    }

                for (DataSnapshot amkSnapshot:dataSnapshot.getChildren()){
                    User user = amkSnapshot.getValue(User.class);
                    // Manually add children to user
                    list_users.add(user);

                }
                ListView listView = (ListView)findViewById(R.id.listview);
                UserArrayAdapter adapter = new UserArrayAdapter(FindUserActivity.this, list_users);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //selectedUser = list_users.get(position));

                        selectedPosition = position;
                        Intent j = new Intent(FindUserActivity.this,AddSensorActivity.class);


                        startActivityForResult(j, ADD_DEVICE);



                        //Intent i = new Intent(FindUserActivity.this,ResultActivity.class);
                        //TODO Start timer
                        //TODO Add the date + to DB

                        //ref.child(list_users.get(position).getUid()).child("date").setValue(formattedDate);
                        ref.child(list_users.get(position).getUid()).child(formattedDate);//.child("heartbeatdata").setValue(1);
                        //Field: DATE --> HEARTBEATS
                        //            --> TIME
                        //            -->
                       // mFirebaseReference.child(list_users.get(position).getUid()).child("sessions").child(formattedDate).child("heartbeats").setValue(null);

                        //i.putExtra("user", list_users.get(position));
                        //startActivity(i);
                    }
                });




            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        }
        );
    }
}
