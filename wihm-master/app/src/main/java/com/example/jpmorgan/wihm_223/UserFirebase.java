package com.example.jpmorgan.wihm_223;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.UUID;

/**
 * Created by Jp on 8-5-2017.
 */

public class UserFirebase {

    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mFirebaseReference;


    public void initFirebase(Activity activity) {
        FirebaseApp.initializeApp(activity);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseReference = mFirebaseDatabase.getReference();

    }

    private void deleteUser(User selectedUser) {
        mFirebaseReference.child("users").child(selectedUser.getUid()).removeValue();
    }



}
