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
		this.mStaffs = StaffList.get(getActivity()).getStaff();
		
		// Make this adapter do all the work
		// to display all elements in an array as TextViews
		CrimeAdapter adapter = new CrimeAdapter(this.mCrimes);
		this.setListAdapter(adapter);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// Get Crime from the adapter
		Crime c = ((CrimeAdapter)super.getListAdapter()).getItem(position);
		
		// Start a CrimePagerActivity (with this crime)
		Intent i = new Intent(super.getActivity(), CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
		super.startActivity(i);
	}
	
	// Inner class
	private class CrimeAdapter extends ArrayAdapter<Crime> {
		
		public CrimeAdapter (ArrayList<Crime> crimes) {
			super(getActivity(), 0, crimes);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
			}
			
			// Configure the view for this Crime
			Crime c = getItem(position);
			
			TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
				titleTextView.setText(c.getTitle());
				
			TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
				dateTextView.setText(c.getDate().toString());
				
			CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
				solvedCheckBox.setChecked(c.isSolved());
			
			// Return the configured view
			return convertView;
		}
	}
}
