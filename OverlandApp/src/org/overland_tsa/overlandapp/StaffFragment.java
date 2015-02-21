package org.overland_tsa.overlandapp;

import java.util.Date;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class StaffFragment extends Fragment {
	
	// Tags names and such
	public static final String EXTRA_STAFF_ID = "com.bignerdranch.android.criminalintent.staff_id";
	
	private static final int REQUEST_ThouYoungAskingDialog = 84121;
	
	// Instance variables
	private Staff mStaff;
	private TextView mTextName;
	private TextView mTextPhone;
	private TextView mTextEmail;
	
	
	// Methods
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// select the current staff
		UUID staffId = (UUID)getActivity().getIntent().getSerializableExtra(StaffFragment.EXTRA_STAFF_ID);
		this.mStaff = StaffList.get(getActivity()).getStaff(staffId);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_staff, parent, false);
		
		// Name Label
		this.mTextName = (TextView) v.findViewById(R.id.staff_name);
		this.mTextName.setText(this.mStaff.getName());
		
		// Phone Label
		this.mTextPhone = (TextView) v.findViewById(R.id.staff_phone);
		this.mTextPhone.setText(this.mStaff.getPhone());
				
		// Email Label
		this.mTextEmail = (TextView) v.findViewById(R.id.staff_email);
		this.mTextEmail.setText(this.mStaff.getEmail());
		
		return v;
	}
	
	
	public static StaffFragment newInstance(UUID staffId) {
		Bundle args = new Bundle();
			args.putSerializable(EXTRA_STAFF_ID, staffId);
		
		StaffFragment fragment = new StaffFragment();
			fragment.setArguments(args);
		
		return fragment;
	}
}
