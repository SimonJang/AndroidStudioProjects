package com.example.simonjang.activities_excercise1;

import android.app.ActionBar;
import android.hardware.Camera;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView; // Declareert een private TextView voor in de layout
    private Camera mCamera;
    private int mCurrentScore;
    private int mCurrentLevel;

    private final String STATE_SCORE = "playerScore";
    private final String STATE_LEVEL = "playerLevel";


    // Eerste methode wanneer een activity wordt gestart
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Laadt de savedinstance
        setContentView(R.layout.activity_main); // Laadt de layout van de res
        mTextView = (TextView) findViewById(R.id.text_message); // Initialiseert de mTextView zodat
                                                                // die later kan worden gemanipuleerd

        /*
        Controleert of de correcte versie wordt gebruikt voor de ActionBar APIs
         */
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // For the main activity, make sure the app icon in the action bar doesn't behave
            // as a button
            ActionBar actionbar = getActionBar();
            actionbar.setHomeButtonEnabled(false);
        }
    }
    // Wanneer de activity wordt vernietigd
    @Override
    public void onDestroy() {
        super.onDestroy(); // Altijd de superklasse aanroepen
    }

    // Waneer de huidige activity de focus verliest. De huidige activity is nog steeds half zichtbaar
    // Belangrijk om tijdens onPause()
    // - Controleren of de app nog steeds zichtbaar is
    // - Alle unsaved changes committen, maar enkel permanent opslaan wanneer de gebruiker de activity definitief stopt
    // - Alle system resources releasen om battery liffe te sparen
    @Override
    public void onPause() {
        super.onPause(); // Altijd de superklasse methode eerst aanroepen
        if(mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

    // Wordt aangeroepen wanneer een gebruiker een activiteit herneemt die in Paused state was
    // Deze methode wordt telkens opnieuw aangeroepen wanneer aan activiteit terug op de voorgrond komt
    // Componenten die released werden tijdens onPause() moeten dus opnieuw worden herinitialiseerd
    @Override
    public void onResume() {
        super.onResume(); // Altijd de superklasse methode eerst aanroepen
        if(mCamera == null) {
            initializeCamera();
        }
    }
    // Lokale methode die initialiseren van de camera tot zich neemt
    private void initializeCamera() {
        mCamera = Camera.open();
        }

    // Wordt aangeroepen wanneer de gebruiker een andere activity start
    // of
    // een nieuwe applicatie opent
    @Override
    public void onStop() {
        super.onStop(); // altijd de superklasse methode eerst aanroepen

        }

    // Deze methode wordt aangeroepen wanneer de applicatie van Paused state naar Resumed State gaat
    @Override
    public void onRestart() {
        super.onRestart();
        }

    // Wanneer een activiteit stopt wordt de onSaveInstanceState() methode aangeroepen
    // Hierbij heb je dan de mogelijk om informatie in de bundle op te slaan
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Plaatst 2 waarden in de bundle
        savedInstanceState.putInt(STATE_SCORE, 100);
        savedInstanceState.putInt(STATE_LEVEL, 2);

        // Always call the superclass so it can save the view hierarchy
        super.onSaveInstanceState(savedInstanceState);
        }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
        mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
        }
    }


