package com.cluster.service;

/**
 * Created by shane on 2/27/17.
 */
public class Rating {

    private int upVotes;
    private int downVotes;
    private double ratio;

    public Rating(int upVotes, int downVotes, double ratio) {
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.ratio = ratio;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
