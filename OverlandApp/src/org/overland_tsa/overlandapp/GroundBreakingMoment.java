package org.overland_tsa.overlandapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class GroundBreakingMoment extends Activity {

	// We have two buttons on the home screen
	private Button prarieButton, overlandButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_screen);
		
		// Declaring the buttons
		this.prarieButton = (Button)findViewById(R.id.prairie_button);
		this.prarieButton.setOnClickListener(
			new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// Not ready
					//Intent prairie = new Intent(GroundBreakingMoment.this, PrarieActivity.class);
					//startActivity( prairie );
				}
			}
		);
		
		this.overlandButton = (Button)findViewById(R.id.overland_button);
		this.overlandButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent overland = new Intent(GroundBreakingMoment.this, OActivity.class);
						startActivity( overland );
					}
				}
			);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.o, menu);
		return true;
	}
}
