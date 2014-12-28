package org.overland_tsa.overlandapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LoadingActivity extends Activity {
	
	// Thanks http://stackoverflow.com/questions/17357226/add-the-loading-screen-in-starting-of-the-android-application
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        
        // Do the loading in a new thread
        Thread welcomeThread = new Thread() {
        	
            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5 * 1000);  //Delay of 5 seconds
                }
                catch (Exception e) {
                }
                finally {
                    Intent transition = new Intent(LoadingActivity.this, GroundBreakingMoment.class);
                    startActivity(  transition  );
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
