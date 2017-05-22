package com.example.jpmorgan.wihm_223;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jpmorgan on 5/21/17.
 */

public class UserHistoryAdapter extends BaseAdapter{
    Activity activity;
    List<User> historylist;
    LayoutInflater inflater;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseReference;
    private User user;




    public UserHistoryAdapter(Activity activity, List<User> historylist){
        this.activity = activity;
        this.historylist = historylist;

    }
    @Override
    public int getCount(){return historylist.size();}
    @Override
    public Object getItem(int i){return historylist.get(i);}
    @Override
    public long getItemId(int i){return i;}
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        //Date
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());


        inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.historylist, null);
        TextView txtHistDate = (TextView) itemView.findViewById(R.id.txtHistoryDate);
        Button btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
        //txtHistDate.setText(historylist.get(i).child(user.getUid()).child(formattedDate));
        txtHistDate.setText("21 MAY 2017");

        return itemView;

    }
}
