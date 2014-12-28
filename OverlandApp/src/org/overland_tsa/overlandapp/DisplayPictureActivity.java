package org.overland_tsa.overlandapp;

import android.app.Activity;
import android.os.Bundle;

public class DisplayPictureActivity extends Activity {
	
	private int picLocation;
	
	public DisplayPictureActivity( int pic ) {
		super();
		this.picLocation = pic;
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Display the view to show the picture
        setContentView( this.picLocation );
        
    }
	
}
