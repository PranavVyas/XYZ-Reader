package com.example.xyzreader.ui;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.example.xyzreader.R;

public class AppSettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.app_settings);
    }
}
