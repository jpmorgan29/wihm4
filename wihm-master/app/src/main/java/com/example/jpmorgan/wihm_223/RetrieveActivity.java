package com.example.jpmorgan.wihm_223;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetrieveActivity extends AppCompatActivity {
    //Firebase
    private FirebaseDatabase mFirebaseDatabase;
    DatabaseReference ref;
    private DatabaseReference mFirebaseReference;
    private User selectedUser;
    private List<User> allUsers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference("users");

        addEventFireBaseListener(allUsers);
    }

    private void addEventFireBaseListener(final List<User> list_users) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(list_users.size() > 0){
                    list_users.clear();
                }
                for (DataSnapshot amkSnapshot:dataSnapshot.getChildren()){
                    User user = amkSnapshot.getValue(User.class);
                    list_users.add(user);
                }
                ListView listView = (ListView)findViewById(R.id.listview);
                UserAdapter adapter = new UserAdapter(RetrieveActivity.this, list_users);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        Intent i = new Intent(RetrieveActivity.this,DetailUserActivity.class);
                        i.putExtra("user", list_users.get(position));
                        startActivity(i);
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
