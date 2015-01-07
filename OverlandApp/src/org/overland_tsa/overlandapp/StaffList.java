package org.overland_tsa.overlandapp;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class StaffList {
	private static StaffList sCrimeLab;
	private Context mAppContext;
	
	private ArrayList<Crime> mCrimes;
	
	private StaffList(Context appContext) {
		this.mAppContext = appContext;
		this.mCrimes = new ArrayList<Crime>();
		
		// generate some crimes
		for (int i=0; i<100; i++) {
			Crime c = new Crime();
			c.setTitle("Crime #" + i);
			c.setSolved(i%2 == 0);	// Every other one
			mCrimes.add(c);
		}
	}
	
	public static StaffList get(Context c) {
		if (sCrimeLab == null) {
			sCrimeLab = new StaffList(c.getApplicationContext());
		}
		
		return sCrimeLab;
	}

	public ArrayList<Crime> getCrimes() {
		return mCrimes;
	}
	
	public Crime getCrime(UUID id) {
		for (Crime c : mCrimes) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
}
