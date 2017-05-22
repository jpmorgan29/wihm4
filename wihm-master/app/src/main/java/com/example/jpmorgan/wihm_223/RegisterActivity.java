package com.example.jpmorgan.wihm_223;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputName, inputAge, inputWeight, inputLength;
    //Firebase
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mFirebaseReference;



    private User selectedUser;
    private List<User> allUsers = new ArrayList<>();
    UserFirebase fb = new UserFirebase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Show toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Registering ");
        setSupportActionBar(toolbar);

        //inputs
        inputName = (EditText) findViewById(R.id.name);
        inputAge = (EditText) findViewById(R.id.age);
        inputLength =  (EditText) findViewById(R.id.length);
        inputWeight = (EditText) findViewById(R.id.weight);

        //Firebase
        initFirebase(this);
        //initFirebase();

    }
    public void initFirebase(Activity activity) {
        FirebaseApp.initializeApp(activity);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseReference = mFirebaseDatabase.getReference();

    }

    private void deleteUser(User selectedUser) {
        mFirebaseReference.child("users").child(selectedUser.getUid()).removeValue();
    }
    private void updateUser(User user) {
        mFirebaseReference.child("users").child(user.getUid()).child("name").setValue(user.getName());
        mFirebaseReference.child("users").child(user.getUid()).child("age").setValue(user.getAge());
        mFirebaseReference.child("users").child(user.getUid()).child("weight").setValue(user.getWeight());
        mFirebaseReference.child("users").child(user.getUid()).child("length").setValue(user.getLength());


    }

    public void clearUser() {
        inputName.setText("");
        inputAge.setText("");
        inputLength.setText("");
        inputWeight.setText("");
    }

    public void saveUser() {
        User user = new User(selectedUser.getUid(),inputName.getText().toString(), inputAge.getText().toString(), inputWeight.getText().toString(), inputLength.getText().toString(), null);
        updateUser(user);
    }
    public void createUser() {
        User user = new User(UUID.randomUUID().toString(),inputName.getText().toString(),inputAge.getText().toString(),inputWeight.getText().toString(),inputLength.getText().toString(), null);
        mFirebaseReference.child("users").child(user.getUid()).setValue(user);

    }
    //Toolbar options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add){
            createUser();
        }
        else if(item.getItemId() == R.id.menu_save){
            saveUser();
        }
        else if(item.getItemId() == R.id.menu_delete){
           // deleteUser(selectedUser);
            clearUser();
        }
        return true;
    }








}
