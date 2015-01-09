package org.overland_tsa.overlandapp;

import android.support.v4.app.Fragment;

public class StaffActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new StaffFragment();
	}

}
