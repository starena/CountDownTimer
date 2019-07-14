package com.example.countdowntimer;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        setTitle("Meute Seeonee Feluy - Mission TOP SECRET");

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.GREEN);


        final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.hymne);
        mPlayer.start();


        ImageView image = findViewById(R.id.imageView);
        //Button button = findViewById(R.id.button3);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.stop();
                Intent intent = new Intent(SuccessActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
