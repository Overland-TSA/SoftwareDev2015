package org.overland_tsa.overlandapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
	
	protected abstract Fragment createFragment();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		
		FragmentManager fm = this.getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);  // try to get the fragment
		
		if (fragment == null) {	// if the fragment doesn't already exist
			// create it
			fragment = createFragment();
			fm.beginTransaction()
				.add(R.id.fragmentContainer, fragment)
				.commit();
		}	// end if fragment is null
	}
	
}
