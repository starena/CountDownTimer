package com.example.countdowntimer;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);

        setTitle("Meute Seeonee Feluy - Mission TOP SECRET");

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.RED);

        final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.perdu);
        mPlayer.start();

        ImageView image = findViewById(R.id.imageView2);
        //Button button = findViewById(R.id.button2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FailedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
