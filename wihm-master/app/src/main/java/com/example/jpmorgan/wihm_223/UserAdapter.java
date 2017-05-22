package com.example.jpmorgan.wihm_223;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jpmorgan on 3/27/17.
 */

public class UserAdapter extends BaseAdapter {

    Activity activity;
    List<User> listUsers;
    LayoutInflater inflater;

    public UserAdapter(Activity activity, List<User> listUsers) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.retrievelist, null);
        TextView txtUuid = (TextView) itemView.findViewById(R.id.tv_uuid);
        TextView txtUser = (TextView) itemView.findViewById(R.id.tv_name);
        TextView txtAge = (TextView) itemView.findViewById(R.id.txtAge);
        TextView txtWeight = (TextView) itemView.findViewById(R.id.txtWeight);
        TextView txtLength = (TextView) itemView.findViewById(R.id.txtLength);
        Button btnPair = (Button) itemView.findViewById(R.id.btnPair);
        txtUuid.setText(listUsers.get(i).getUid());
        txtUser.setText(listUsers.get(i).getName());
//        txtAge.setText(listUsers.get(i).getAge());
//        txtWeight.setText(listUsers.get(i).getWeight());
//        txtLength.setText(listUsers.get(i).getLength());
        //pair to device
        //btnPair --> new Intent --> Select BT device

        return itemView;
    }
}
