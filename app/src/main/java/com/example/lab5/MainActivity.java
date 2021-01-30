package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Defining variables
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE = "com.example.lab5.MainActivity.extra.MESSAGE";

    private final TextView[] item = new TextView[10];

    private ArrayList<String> itemsList = new ArrayList<>(10);

    public static final int TEXT_REQUEST = 1;

    /**
     * OnCreate method is called when the activity starts.
     * Setting the textview array's index to equal each different item
     *
     * @param savedInstanceState is used to save the most recently supplied data to the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item[0] = findViewById(R.id.item_1);
        item[1] = findViewById(R.id.item_2);
        item[2] = findViewById(R.id.item_3);
        item[3] = findViewById(R.id.item_4);
        item[4] = findViewById(R.id.item_5);
        item[5] = findViewById(R.id.item_6);
        item[6] = findViewById(R.id.item_7);
        item[7] = findViewById(R.id.item_8);
        item[8] = findViewById(R.id.item_9);
        item[9] = findViewById(R.id.item_10);

        /*
        If the saved instance state is not null, loop through the arraylist.
        If the user is trying to add more than 10, output an error message.
        Else, add to the textview array.
         */
        if (savedInstanceState != null) {
            itemsList = savedInstanceState.getStringArrayList("ItemsListStringArray");
            int i;
            if (itemsList != null && itemsList.size() > 0) {
                for (i = 0; i < itemsList.size(); i++) {
                    if (itemsList.size() > 10) {
                        Toast.makeText(MainActivity.this, "Cannot add more items to the list", Toast.LENGTH_LONG).show();
                        break;
                    }
                    item[i].setVisibility(View.VISIBLE);
                    item[i].setText(itemsList.get(i));
                }
            }

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

    /**
     * Method to launch second activity on button press. Logcat message is set.
     * Using intent to bundle the message from main activity "TEXT_REQUEST".
     * Start activityforresult is used because we expect a result back.
     *
     * @param view used for drawing and handling events.
     */
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * Saved instance method saves the current data when the app is recreated.
     * If it is not empty, output the arraylist.
     *
     * @param outState keyvaluepairs from the app's current state.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (itemsList.size() != 0) {
            outState.putStringArrayList("ItemsListStringArray", itemsList);
        }
    }

    /**
     * Get the string depending on which button was pressed.
     * Add to the arraylist.
     * Loop through arraylist, if they try to add more than 10 break and output error.
     * Else, add to textview array.
     * Check that the request
     * code is equal to the one defined.
     * Check that the result code also equals the same.
     * Then, using the intent from the result, get the message sent and set it into the
     * main activity's textview.
     *
     * @param requestCode used to check it aligns with the variable defined in mainactivity.
     * @param resultCode  used to check it aligns with the variable defined in mainactivity.
     * @param data        the intent data sent from secondactivity.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String itemString = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                itemsList.add(itemString); // add to arraylist
                int i;
                for (i = 0; i < itemsList.size(); i++) {
                    if (itemsList.size() > 10) {
                        Toast.makeText(MainActivity.this, "Cannot add more items to the list", Toast.LENGTH_LONG).show();
                        break;
                    }
                    // loop through array list and add to each index of array
                    item[i].setVisibility(View.VISIBLE);
                    item[i].setText(itemsList.get(i));
                }

            }
        }
    }

}