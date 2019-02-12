package com.example.ayan.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ProgressBar;

import com.example.ayan.mediaplayer.MainActivity;

public class Media {

    private String mName;
    private String mDescription;
    private int mImg_id;
    private int mMediaId;
    private MediaPlayer mediaPlayer;
    private int mProgress;
    private int mDuration;
    private ProgressBar mProgressBar;

    public Media(Context context, String a, String b, int c, int d){
        mName = a;
        mDescription = b;
        mImg_id = c;
        mMediaId = d;

        mediaPlayer = MediaPlayer.create(context, d);
        mDuration = mediaPlayer.getDuration();
        mProgress = mediaPlayer.getCurrentPosition();
    }

    public int getmImg_id() {
        return mImg_id;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmName() {
        return mName;
    }

    public int getmMediaId() {
        return mMediaId;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setProgressBar(ProgressBar progressBar) {
        mProgressBar = progressBar;
        mProgressBar.setMax(mDuration);
        mProgressBar.setProgress(mProgress,true);
    }

    public int getmProgress() {
        return mProgress;
    }

    public int getmDuration() {
        return mDuration;
    }

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public void setmProgress() {
        mProgress = mediaPlayer.getCurrentPosition();
    }
}
