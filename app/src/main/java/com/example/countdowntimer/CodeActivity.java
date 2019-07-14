package com.example.countdowntimer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CodeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        final EditText code = findViewById(R.id.editText);

        setTitle("Meute Seeonee Feluy - Mission TOP SECRET");

        ToneGenerator toneGen = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        toneGen.startTone(ToneGenerator.TONE_CDMA_ABBR_ALERT,5000);

        final EditText edittext = findViewById(R.id.editText);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    if ("londres".equalsIgnoreCase(code.getText().toString())) {
                        Intent intent = new Intent(CodeActivity.this, SuccessActivity.class);
                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(CodeActivity.this, FailedActivity.class);
                        startActivity(intent);

                    }

                    return true;
                }
                return false;
            }
        });


    /*    Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("londres".equalsIgnoreCase(code.getText().toString())) {
                    Intent intent = new Intent(CodeActivity.this, SuccessActivity.class);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(CodeActivity.this, FailedActivity.class);
                    startActivity(intent);

                }
            }
        });
        */
    }
}
