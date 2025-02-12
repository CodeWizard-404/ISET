package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_main);
        Intent intent = getIntent();
        //String reply = mReply.getText().toString();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_header);
        textView.setText(message);


        Log.d(LOG_TAG, "________2");
        Log.d(LOG_TAG, "onCreate2");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart2");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause2");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume2");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop2");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy2");
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }


}