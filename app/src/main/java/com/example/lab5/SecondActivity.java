package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.lab5.MainActivity.extra.REPLY";

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();


    /**
     * OnCreate method is called when the activity starts.
     *
     * @param savedInstanceState is used to save the most recently supplied data to the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    /**
     * A method that utilises a switch statement.
     * The return string changes depending on which button was pressed.
     * @param view handles drawing and events.
     */
    public void selectItem(View view) {
        Intent return_items_intent = new Intent();
        // Switch statements to say if it is this id, then return this string
        switch (view.getId()) {
            case R.id.rice_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Rice");
                setResult(RESULT_OK, return_items_intent);
                finish();
                break;
            case R.id.bread_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Bread");
                setResult(RESULT_OK, return_items_intent);
                finish();
                break;
            case R.id.water_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Water");
                setResult(RESULT_OK, return_items_intent);
                finish();
                break;
            case R.id.egg_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Eggs");
                setResult(RESULT_OK, return_items_intent);
                finish();
                break;
            case R.id.cheese_button:
                return_items_intent.putExtra(EXTRA_REPLY, "Cheese");
                setResult(RESULT_OK, return_items_intent);
                finish();
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