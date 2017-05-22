package com.example.jpmorgan.wihm_223;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Jp on 8-5-2017.
 */
public class UserArrayAdapter extends BaseAdapter {

    Activity activity;
    List<User> listUsers;
    LayoutInflater inflater;

    public UserArrayAdapter(Activity activity, List<User> listUsers) {
        this.activity = activity;
        this.listUsers = listUsers;
    }

    @Override
    public int getCount() {
        return listUsers.size();
    }

    @Override
    public Object getItem(int i) {
        return listUsers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, final View view, final ViewGroup viewGroup) {

        inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View itemView = inflater.inflate(R.layout.userlist, null);
        TextView txtUser = (TextView) itemView.findViewById(R.id.txtName);
        TextView txtAge = (TextView) itemView.findViewById(R.id.txtAge);
        TextView txtWeight = (TextView) itemView.findViewById(R.id.txtWeight);
        TextView txtLength = (TextView) itemView.findViewById(R.id.txtLength);
        TextView txtUID = (TextView) itemView.findViewById(R.id.txtUID);
        Button btnPair = (Button) itemView.findViewById(R.id.btnPair);
        txtUser.setText(listUsers.get(i).getName());
        txtAge.setText(listUsers.get(i).getAge());
        txtWeight.setText(listUsers.get(i).getWeight());
        txtLength.setText(listUsers.get(i).getLength());
        txtUID.setText(listUsers.get(i).getUid());

        //pair to device
        //btnPair --> new Intent --> Select BT device

        return itemView;
    }
}
