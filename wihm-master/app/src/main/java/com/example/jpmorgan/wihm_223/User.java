package com.example.jpmorgan.wihm_223;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jpmorgan on 3/27/17.
 */


//Prim key UUID --> Firebase

public class User implements Serializable {

        private String uid, name, age, weight, length;
        private Context context;
        private String ip;
        private Date date;



    public User(){
        }

        public User(String uid, String name, String age, String weight, String length, Date date) {
            this.uid = uid; //Primaire key
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.length = length;
            this.date = date;


            // this.heartrates = heartrates;

        }
        //Connect
        public void Connect(Context context, String ip){
            this.context = context;
            this.ip = ip;
        }
        public String getUid() {return uid;}

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public void setDate(Date date) { this.date = date; }
        public Date getDate() { return date; }


}
