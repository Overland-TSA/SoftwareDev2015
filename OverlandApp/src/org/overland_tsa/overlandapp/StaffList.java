package org.overland_tsa.overlandapp;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class StaffList {
	private static StaffList sStaffList;
	private Context mAppContext;
	
	private ArrayList<Staff> mStaffs;
	
	private StaffList(Context appContext) {
		this.mAppContext = appContext;
		this.mStaffs = new ArrayList<Staff>();
		
		// generate some Staffs
		for (int i=0; i<100; i++) {
			Staff s = new  Staff(i + "", i + "", i + "", i + "");
			mStaffs.add(s);
		}
	}
	
	public static StaffList get(Context c) {
		if (sStaffList == null) {
			sStaffList = new StaffList(c.getApplicationContext());
		}
		
		return sStaffList;
	}

	public ArrayList<Staff> getStaffs() {
		return mStaffs;
	}
	
	public Staff getStaff(UUID id) {
		for (Staff s : mStaffs) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}
}
