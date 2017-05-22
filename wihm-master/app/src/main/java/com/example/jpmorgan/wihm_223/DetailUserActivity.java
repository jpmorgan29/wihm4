package com.example.jpmorgan.wihm_223;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DetailUserActivity extends AppCompatActivity {
    private List<User> history = new ArrayList<>();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;
    private TextView txtName;
    private User user;

    //Date
    Calendar c = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        txtName = (TextView) findViewById(R.id.txtDetailName);
        txtName.setText(user.getName());
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference("users");
        addEventFireBaseListener(history);

    }

    private void addEventFireBaseListener(final List<User> history) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (history.size() > 0){
                    history.clear();
                }
                for (DataSnapshot xxxSnapshot:dataSnapshot.getChildren()){
                    User user = xxxSnapshot.getValue(User.class);
                    history.add(user);
                }
                ListView lv_history = (ListView) findViewById(R.id.lv_history);
                UserHistoryAdapter adapter = new UserHistoryAdapter(DetailUserActivity.this, history);
                lv_history.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
