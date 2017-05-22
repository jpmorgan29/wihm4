package com.example.jpmorgan.wihm_223;

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
        private Date date;

        private List<HeartBeatSessions> sessions;
        class HeartBeatSessions {
            Date date;
            List<Double> heartrates;
         }

    public User(){
        }

        public User(String uid, String name, String age, String weight, String length, List<HeartBeatSessions> sessions) {
            this.uid = uid; //Primaire key
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.length = length;
            this.sessions = sessions;
            // this.heartrates = heartrates;

        }

       // public Object getHeartrates(){ return heartrates; }
       // public Object setHeartrates(Object heartrates){ this.heartrates = heartrates})
        public String getUid() {
            return uid;
        }

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
        public void setSessions(List<HeartBeatSessions> sessions) {this.sessions = sessions;}
        public List<HeartBeatSessions> getSessions() {return sessions; }
}
