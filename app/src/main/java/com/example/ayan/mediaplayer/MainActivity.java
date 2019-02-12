package com.example.ayan.mediaplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private Handler mHandler;
    final ArrayList<Media> mediaArrayList = new ArrayList<>();
    Media media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaArrayList.add(new Media(getApplicationContext(),"My Heart Will Go On","Titanic: Theme Song",R.drawable.titanic, R.raw.myheartwillgo));
        mediaArrayList.add(new Media(getApplicationContext(),"A Million Dreams", "The Greatest Showman",R.drawable.showman, R.raw.amilliondreams));
        mediaArrayList.add(new Media(getApplicationContext(),"Ever Dream","Epic Soul factory",R.drawable.everdream, R.raw.epicsoulfactory));

        MediaAdapter adapter = new MediaAdapter(this,mediaArrayList);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                media = mediaArrayList.get(position);

                if (media.getMediaPlayer().isPlaying() != true) {
                    mHandler = new Handler();
                    media.getMediaPlayer().start();
                }
                else {
                    media.getMediaPlayer().pause();
                }
            }
    });

        /* ViewPager viewPager = findViewById(R.id.viewpager);
        SimpleFragmentPagerAdapter simpleFragmentPagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(simpleFragmentPagerAdapter);
        viewPager.setCurrentItem(1);*/
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (media.getMediaPlayer().isPlaying() != true)
            Toast.makeText(getApplicationContext(),"Nothing to Play!",Toast.LENGTH_LONG).show();
        media.getMediaPlayer().pause();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            media.setmProgress();
            media.getProgressBar().setProgress(media.getmProgress(),true);
            mHandler.removeCallbacks(this,15);
        }
    };
}
