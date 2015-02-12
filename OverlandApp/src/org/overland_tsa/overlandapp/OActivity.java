package org.overland_tsa.overlandapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class OActivity extends Activity {

	//We have two ImageButtons on the home screen
	private ImageButton overlandWebImageButton, bellImageButton, calendarImageButton, clubImageButton, contactImageButton, counselorsImageButton, lunchImageButton, prideImageButton, powerschoolImageButton, seniorsImageButton, sportsImageButton, staffImageButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_o);
		
		this.bellImageButton = (ImageButton)findViewById(R.id.bellschedule);
		this.bellImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, BellScheduleActivity.class) );
					}
				}
			);
		
		this.calendarImageButton = (ImageButton)findViewById(R.id.calendars);
		this.calendarImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent overland = new Intent(OActivity.this, CalendarActivity.class);
						startActivity( overland );
					}
				}
			);
		
		this.clubImageButton = (ImageButton)findViewById(R.id.clubs);
		this.clubImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, ClubsWebActivity.class) );
					}
				}
			);
		
		this.contactImageButton = (ImageButton)findViewById(R.id.contact);
		this.contactImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent overland = new Intent(OActivity.this, ContactsWebActivity.class);
						startActivity( overland );
					}
				}
			);
		this.counselorsImageButton = (ImageButton)findViewById(R.id.counselors);
		this.counselorsImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, CounselorsWebActivity.class) );
					}
				}
			);
		
		this.lunchImageButton = (ImageButton)findViewById(R.id.lunchmenu);
		this.lunchImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, LunchMenuWebActivity.class) );
					}
				}
			);
		
		/*this.notificationImageButton = (ImageButton)findViewById(R.id.notifications);
		this.notificationImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent overland = new Intent(OActivity.this, OActivity.class);
						startActivity( overland );
					}
				}
			);*/
		
		this.prideImageButton = (ImageButton)findViewById(R.id.pointsofpride);
		this.prideImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, PrideWebActivity.class) );
					}
				}
			);
		
		this.powerschoolImageButton = (ImageButton)findViewById(R.id.powerschool);
		this.powerschoolImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, PowerschoolWebActivity.class) );
					}
				}
			);
		
		this.seniorsImageButton = (ImageButton)findViewById(R.id.seniors);
		this.seniorsImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, SeniorsWebActivity.class) );
					}
				}
			);
		
		this.sportsImageButton = (ImageButton)findViewById(R.id.sports);
		this.sportsImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						startActivity( new Intent(OActivity.this, SportsWebActivity.class) );
					}
				}
			);
		
		this.staffImageButton = (ImageButton)findViewById(R.id.staff);
		this.staffImageButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						/*Intent i = new Intent(OActivity.this, WebViewActivity.class);
						i.putExtra(WebViewActivity.WEBPAGE_URL, "http://overland.cherrycreekschools.org/Staff/Pages/FacultyStaff.aspx");
						startActivity( i );
						*/
						startActivity( new Intent(OActivity.this, StaffDirectoryWebActivity.class) );
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.overlandWebButton:
	        	startActivity( new Intent(OActivity.this, OverlandWebActivity.class) );
	            return true;	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}

