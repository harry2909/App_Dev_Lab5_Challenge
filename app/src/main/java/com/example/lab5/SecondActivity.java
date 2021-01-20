package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.lab5.MainActivity.EXTRA_MESSAGE;
import static com.example.lab5.MainActivity.TEXT_REQUEST;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.lab5.MainActivity.extra.REPLY";

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void selectItem(View view) {
        Intent return_items_intent = new Intent();
        // Switch statements to say if it is this id, then return this string
        switch (view.getId()){
            case R.id.rice_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Rice"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.bread_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Bread"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.water_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Water"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.egg_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Eggs"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.cheese_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Cheese"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            default:
                Toast.makeText(SecondActivity.this, "There was an error", Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}