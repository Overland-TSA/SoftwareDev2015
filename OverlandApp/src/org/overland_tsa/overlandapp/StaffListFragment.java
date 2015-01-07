package org.overland_tsa.overlandapp;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class StaffListFragment extends ListFragment {
	
	// Properties
	private ArrayList<Staff> mStaffs;
	private static final String TAG = "StaffListFragment";
	
	// Methods
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.getActivity().setTitle(R.string.staff_title);
		this.mStaffs = StaffList.get(getActivity()).getStaffs();
		
		// Make this adapter do all the work
		// to display all elements in an array as TextViews
		StaffAdapter adapter = new StaffAdapter(this.mStaffs);
		this.setListAdapter(adapter);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		((StaffAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// Get Staff from the adapter
		Staff s = ((StaffAdapter)super.getListAdapter()).getItem(position);
		
		// Start a StaffPagerActivity (with this Staff)
		startActivity( new Intent(super.getActivity(), BellScheduleActivity.class) );
		Intent i = new Intent(super.getActivity(), StaffPagerActivity.class);
		i.putExtra(StaffFragment.EXTRA_STAFF_ID, s.getId());
		super.startActivity(i);
	}
	
	// Inner class
	private class StaffAdapter extends ArrayAdapter<Staff> {
		
		public StaffAdapter (ArrayList<Staff> staffs) {
			super(getActivity(), 0, staffs);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_staff, null);
			}
			
			// Configure the view for this Staff
			Staff s = getItem(position);
			
			TextView titleTextView = (TextView) convertView.findViewById(R.id.staff_list_item_titleTextView);
				titleTextView.setText(c.getTitle());
				
			TextView dateTextView = (TextView) convertView.findViewById(R.id.staff_list_item_dateTextView);
				dateTextView.setText(c.getDate().toString());
				
			CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.staff_list_item_solvedCheckBox);
				solvedCheckBox.setChecked(c.isSolved());
			
			// Return the configured view
			return convertView;
		}
	}
}
