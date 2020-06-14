package com.example.beerman;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Processes extends AppCompatActivity {
    VideoView videoView;
    String videoPath;
    Uri uri;
//    ArrayList<String> viedoList;
//    ArrayAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processes);
        videoView = (VideoView) findViewById(R.id.video_view);
        videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediacontroller = new MediaController(this);
        videoView.setMediaController(mediacontroller);
        mediacontroller.setAnchorView(videoView);

        /*viedoList = new ArrayList<>();
        videoView = (VideoView) findViewById(R.id.videoView);
        viedoList.add(" ");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, viedoList);*/
    }
}