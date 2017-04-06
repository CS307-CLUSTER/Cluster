package com.cluster.service;

/**
 * Created by shane on 2/27/17.
 */
public class Rating {

    private int upVotes;
    private int downVotes;
    private double ratio;

    public Rating(int upVotes, int downVotes) {
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        if (downVotes == 0) {
            this.ratio = 1;
        } else {
            this.ratio = upVotes / downVotes;
        }
    }

    public void upVote() {
        upVotes++;
    }

    public void downVote() {
        downVotes++;
    }

    public void reset() {
        upVotes = 0;
        downVotes = 0;
        ratio = 1;
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
