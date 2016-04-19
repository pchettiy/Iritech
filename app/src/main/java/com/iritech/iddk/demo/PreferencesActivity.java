package com.iritech.iddk.demo;

import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

public class PreferencesActivity extends PreferenceActivity implements
		OnPreferenceChangeListener, OnPreferenceClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);

		SharedPreferences sharedPref;
		int index = 0;
		EditTextPreference countPref = (EditTextPreference) findPreference("count_interval_pref");
		countPref.setOnPreferenceChangeListener(this);
		sharedPref = countPref.getSharedPreferences();
		countPref.setSummary(sharedPref.getString("count_interval_pref", ""));
		countPref.setOnPreferenceClickListener(this);

		EditTextPreference outputPref = (EditTextPreference) findPreference("output_dir_pref");
		outputPref.setOnPreferenceChangeListener(this);
		sharedPref = outputPref.getSharedPreferences();

		outputPref.setOnPreferenceClickListener(this);

		EditTextPreference preNamePref = (EditTextPreference) findPreference("prefix_name_pref");
		preNamePref.setOnPreferenceChangeListener(this);
		sharedPref = preNamePref.getSharedPreferences();
		preNamePref.setSummary(sharedPref.getString("prefix_name_pref", ""));
		preNamePref.setOnPreferenceClickListener(this);

		ListPreference listPref = (ListPreference) findPreference("capture_mode_pref");
		listPref.setOnPreferenceChangeListener(this);
		sharedPref = listPref.getSharedPreferences();
		index = listPref.findIndexOfValue(sharedPref.getString(
				"capture_mode_pref", "0"));
		listPref.setSummary(listPref.getEntries()[index].toString());

		listPref = (ListPreference) findPreference("quality_mode_pref");
		listPref.setOnPreferenceChangeListener(this);
		sharedPref = listPref.getSharedPreferences();
		index = listPref.findIndexOfValue(sharedPref.getString(
				"quality_mode_pref", "0"));
		listPref.setSummary(listPref.getEntries()[index].toString());

		listPref = (ListPreference) findPreference("operation_mode_pref");
		listPref.setOnPreferenceChangeListener(this);
		sharedPref = listPref.getSharedPreferences();
		index = listPref.findIndexOfValue(sharedPref.getString(
				"operation_mode_pref", "0"));
		listPref.setSummary(listPref.getEntries()[index].toString());
		listPref.setEnabled(false);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setTitle("Settings");
	}

	public boolean onPreferenceChange(Preference preference, Object newValue) {
		if (preference.getKey().equals("count_interval_pref")) {
			EditTextPreference countPref = (EditTextPreference) preference;

			try {
				int count = Integer.parseInt(countPref.getEditText().getText()
						.toString());
				if (count < 3 || count > 600) {
					throw new NumberFormatException();
				}
				countPref.setSummary(countPref.getEditText().getText());
			} catch (NumberFormatException ex) {
				AlertDialog alertDialog = new AlertDialog.Builder(this)
						.create();
				alertDialog.setTitle("Error");
				alertDialog
						.setMessage("Please enter a number between 3 and 600 !");
				alertDialog.setIcon(R.drawable.ic_menu_notifications);
				alertDialog.setButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								// Do nothing
							}
						});
				alertDialog.show();
				countPref.getEditText().setText("3");
				countPref.setSummary(countPref.getEditText().getText());
				return false;
			}
		} else if (preference.getKey().equals("exposure_pref")) {
			EditTextPreference exposurePref = (EditTextPreference) preference;

			try {
				int count = Integer.parseInt(exposurePref.getEditText()
						.getText().toString());
				if (count < -4 || count > 4) {
					throw new NumberFormatException();
				}
				exposurePref.setSummary(exposurePref.getEditText().getText());
			} catch (NumberFormatException ex) {
				AlertDialog alertDialog = new AlertDialog.Builder(this)
						.create();
				alertDialog.setTitle("Error");
				alertDialog
						.setMessage("Please enter a number between -4 and 4 !");
				alertDialog.setIcon(R.drawable.ic_menu_notifications);
				alertDialog.setButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								// Do nothing
							}
						});
				alertDialog.show();
				exposurePref.getEditText().setText("0");
				exposurePref.setSummary(exposurePref.getEditText().getText());
				return false;
			}
		} else if (preference.getKey().equals("prefix_name_pref")) {
			EditTextPreference preNamePref = (EditTextPreference) preference;
			Pattern p = Pattern.compile("^[A-Za-z0-9_]*$");
			String txtPrefix = preNamePref.getEditText().getText().toString();
			boolean isValidCharacters = p.matcher(txtPrefix).matches();
			if (false == isValidCharacters) {
				AlertDialog dlg = new AlertDialog.Builder(this).create();
				dlg.setMessage("Invalid prefix name!");
				dlg.setTitle("Error");
				dlg.setButton("OK", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});
				dlg.show();
				return false;
			}

			preNamePref.setSummary(preNamePref.getEditText().getText());
		} else if (preference.getKey().equals("output_dir_pref")) {
			EditTextPreference outputPref = (EditTextPreference) preference;
			outputPref.setSummary(outputPref.getEditText().getText());
		} else {
			ListPreference listPref;
			if (preference instanceof ListPreference) {
				listPref = (ListPreference) preference;
				int selectedIndex = 0;
				if (preference.getKey().equals("capture_mode_pref")) {
					selectedIndex = listPref.findIndexOfValue(newValue
							.toString());
					listPref.setSummary(listPref.getEntries()[selectedIndex]
							.toString());
				} else if (preference.getKey().equals("quality_mode_pref")) {
					selectedIndex = listPref.findIndexOfValue(newValue
							.toString());
					listPref.setSummary(listPref.getEntries()[selectedIndex]
							.toString());
				} else if (preference.getKey().equals("operation_mode_pref")) {
					selectedIndex = listPref.findIndexOfValue(newValue
							.toString());
					listPref.setSummary(listPref.getEntries()[selectedIndex]
							.toString());
				}
			}
		}
		return true;
	}

	public boolean onPreferenceClick(Preference preference) {
		EditTextPreference countPref = (EditTextPreference) findPreference("count_interval_pref");
		countPref.getEditText().setText(countPref.getSummary());

		EditTextPreference outputPref = (EditTextPreference) findPreference("output_dir_pref");
		outputPref.getEditText().setText(outputPref.getSummary());

		EditTextPreference preNamePref = (EditTextPreference) findPreference("prefix_name_pref");
		preNamePref.getEditText().setText(preNamePref.getSummary());

		return true;
	}
}
