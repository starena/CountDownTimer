package com.example.countdowntimer;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int counter = 2;
    ToneGenerator toneGen = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);

    SimpleDateFormat formatter = new SimpleDateFormat("mm:ss", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Meute Seeonee Feluy - Mission TOP SECRET");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        final EditText textView = findViewById(R.id.timer);
        Button button = findViewById(R.id.startTimer);
        textView.setText("10");
        textView.setEnabled(true);
        button.requestFocus();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = Integer.valueOf(textView.getText().toString());
                Button btn = findViewById(R.id.startTimer);
                btn.setVisibility(View.INVISIBLE);

                new CountDownTimer(counter * 1000 * 60, 1_000) {
                    int currentCounter = counter * 1000* 60;

                    @Override
                    public void onTick(long l) {

                        textView.setText(formatter.format(new Date(currentCounter)));
                        textView.setEnabled(false);
                        currentCounter-=1000;

                        if (currentCounter < 60*1000) {
                            View view = MainActivity.this.getWindow().getDecorView();
                            if ( (currentCounter/1000) % 2 == 0) {
                                view = MainActivity.this.getWindow().getDecorView();
                                view.setBackgroundColor(Color.WHITE);
                            } else {
                                view.setBackgroundColor(Color.RED);
                                toneGen.startTone(ToneGenerator.TONE_CDMA_PIP,150);
                            }
                        }
                    }

                    @Override
                    public void onFinish() {

                        Button btn = findViewById(R.id.startTimer);
                        btn.setVisibility(View.VISIBLE);
                        textView.setText("Finish!!");

                    /*    try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    */
                        Intent intent = new Intent(MainActivity.this, CodeActivity.class);
                        startActivity(intent);

                    }
                }.start();

            }
        });
    }
}
