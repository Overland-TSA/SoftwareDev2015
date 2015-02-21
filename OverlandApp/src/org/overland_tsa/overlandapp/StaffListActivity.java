package org.overland_tsa.overlandapp;

import android.support.v4.app.Fragment;

public class StaffListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new StaffListFragment();
	}

}
