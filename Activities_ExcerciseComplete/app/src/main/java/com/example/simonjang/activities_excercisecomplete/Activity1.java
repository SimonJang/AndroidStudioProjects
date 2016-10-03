package com.example.simonjang.activities_excercisecomplete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    private final static String TAG = "Activity_1";

    /**
     * TODO: Create counter variables for onCreate(), onRestart(), onStart() and onResume() etc which you increment with every method call
     */

    private final String ONCREATE_COUNTER = "onCreate(): ";
    private final String ONRESTART_COUNTER = "onRestart(): ";
    private final String ONSTART_COUNTER = "onStart(): ";
    private final String ONRESUME_COUNTER = "onResume(): ";
    private final String ONPAUSE_COUNTER = "onPause(): ";
    private final String ONDESTROY_COUNTER = "onDestroy(): ";
    private final String ONSTOP_COUNTER = "onStop(): ";

    private int onCreateCounter = 0;
    private int onRestartCounter = 0;
    private int onStartCounter = 0;
    private int onResumeCounter = 0;
    private int onPauseCounter = 0;
    private int onDestroyCounter = 0;
    private int onStopCounter = 0;

    /**
     * TODO: Creëer variabelen voor de verschillende textviews
     */

    private TextView onCreateCounterTextView;
    private TextView onRestartCounterTextView;
    private TextView onStartCounterTextView;
    private TextView onResumeCounterTextView;
    private TextView onPauseCounterTextView;
    private TextView onDestroyCounterTextView;
    private TextView onStopCounterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        // TODO: Initialize textviews
        // TODO Hint: findViewById()

        onCreateCounterTextView = (TextView) findViewById(R.id.create);
        onRestartCounterTextView = (TextView) findViewById(R.id.restart);
        onStartCounterTextView = (TextView) findViewById(R.id.start);
        onResumeCounterTextView = (TextView) findViewById(R.id.resume);
        onPauseCounterTextView = (TextView) findViewById(R.id.pause);
        onDestroyCounterTextView = (TextView) findViewById(R.id.destroy);
        onStopCounterTextView = (TextView) findViewById(R.id.stop);

        //TODO: Add a Onclicklistener to the button to start a new activity
        // TODO: maakt deel uit van Excercise 2
        final Intent switchIntent = new Intent(getBaseContext(), Activity2.class);
        Button button = (Button) findViewById(R.id.bLaunchActivityTwo);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(switchIntent);
            }
        });

        // TODO: Check saved state
        if (savedInstanceState != null) {
            onCreateCounter = savedInstanceState.getInt(ONCREATE_COUNTER);
            onStartCounter = savedInstanceState.getInt(ONSTART_COUNTER);
            onRestartCounter = savedInstanceState.getInt(ONRESTART_COUNTER);
            onResumeCounter = savedInstanceState.getInt(ONRESUME_COUNTER);
            onPauseCounter = savedInstanceState.getInt(ONPAUSE_COUNTER);
            onDestroyCounter = savedInstanceState.getInt(ONDESTROY_COUNTER);
            onStopCounter = savedInstanceState.getInt(ONSTOP_COUNTER);
        }
        // TODO: LogCat message
        Log.i(ONCREATE_COUNTER, "Activity created");
        onCreateCounter++;
        // TODO: Update user interface using the displayCounts() method
        displayCounts();
    }

    @Override
    public void onStart() {
        super.onStart();
        // TODO: LogCat message
        Log.i(ONSTART_COUNTER, "Activity started");
        // TODO: Update count variable
        onStartCounter++;
        // TODO: Update the user interface
        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();
        // TODO: LogCat message
        Log.i(ONRESUME_COUNTER, "Activity resumed");
        // TODO: Update the  count variable
        onResumeCounter++;
        // TODO: Update the user interface
        displayCounts();
    }

    @Override
    public void onPause() {
        super.onPause();
        // TODO: LogCat message
        Log.i(ONPAUSE_COUNTER, "Activity paused");
        // TODO: Update the  count variable
        onPauseCounter++;
        // TODO: Update the user interface
        displayCounts();
    }

    @Override
    public void onStop() {
        super.onStop();
        // TODO: LogCat message
        Log.i(ONSTOP_COUNTER, "Activity stopped");
        // TODO: Update the  count variable
        onStopCounter++;
        // TODO: Update the user interface
        displayCounts();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        // TODO: LogCat message
        Log.i(ONRESTART_COUNTER, "Activity restarted");
        // TODO: Update the  count variable
        onRestartCounter++;
        // TODO: Update the user interface
        displayCounts();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // TODO: LogCat message
        Log.i(ONDESTROY_COUNTER, "Activity destroyed");
        // TODO: Update the  count variable
        onDestroyCounter++;
        // TODO: Update the user interface
        displayCounts();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // TODO:  Save the state  using key-value pairs in the Bundle
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(ONCREATE_COUNTER, onCreateCounter);
        savedInstanceState.putInt(ONRESTART_COUNTER, onRestartCounter);
        savedInstanceState.putInt(ONSTART_COUNTER, onStartCounter);
        savedInstanceState.putInt(ONRESUME_COUNTER, onResumeCounter);
        savedInstanceState.putInt(ONPAUSE_COUNTER, onPauseCounter);
        savedInstanceState.putInt(ONSTOP_COUNTER, onStopCounter);
        savedInstanceState.putInt(ONDESTROY_COUNTER, onDestroyCounter);
    }

    // Updates de  counters
    private void displayCounts() {
        onCreateCounterTextView.setText(String.format(ONCREATE_COUNTER + "%d", onCreateCounter));
        onRestartCounterTextView.setText(String.format(ONRESTART_COUNTER + "%d", onRestartCounter));
        onStartCounterTextView.setText(String.format(ONSTART_COUNTER + "%d", onStartCounter));
        onResumeCounterTextView.setText(String.format(ONRESUME_COUNTER + "%d", onResumeCounter));
        onPauseCounterTextView.setText(String.format(ONPAUSE_COUNTER + "%d", onPauseCounter));
        onStopCounterTextView.setText(String.format(ONSTOP_COUNTER + "%d", onStopCounter));
        onDestroyCounterTextView.setText(String.format(ONDESTROY_COUNTER + "%d", onDestroyCounter));
    }

    public TextView getOnStartCounterTextView() {
        return onStartCounterTextView;
    }
}
