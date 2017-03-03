package com.cluster.service;

import com.cluster.data.Users;

import java.util.List;

/**
 * Created by shane on 2/27/17.
 */
public class Cluster {

    private int id;
    private int maxUsers;
    private int minUsers;
    private int numUsers;
    private List<Users> users;
    private int leaderID;
    private int startTime;
    private int endTime;
    private boolean isComplete;
    private Location location;

    public Cluster(int id, int maxUsers, int minUsers, int numUsers, List<Users> users, int leaderID, int startTime, int endTime, boolean isComplete, Location location) {
        this.id = id;
        this.maxUsers = maxUsers;
        this.minUsers = minUsers;
        this.numUsers = numUsers;
        this.users = users;
        this.leaderID = leaderID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isComplete = isComplete;
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && ((Cluster) obj).id == this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public int getMinUsers() {
        return minUsers;
    }

    public void setMinUsers(int minUsers) {
        this.minUsers = minUsers;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public int getLeaderID() {
        return leaderID;
    }

    public void setLeaderID(int leaderID) {
        this.leaderID = leaderID;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
