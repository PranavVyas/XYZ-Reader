package com.example.xyzreader.ui;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.xyzreader.R;
import com.example.xyzreader.data.SharedUtils;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedUtils.setUserTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setSupportActionBar((Toolbar) findViewById(R.id.settings_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

//        final boolean newPref = sharedPreferences.getBoolean(getString(R.string.key_pref_dots_clickable), false);
//        if (newPref) {
//            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//            dialogBuilder.setTitle("Experimental Feature Enabled")
//                    .setMessage("Sometimes Enabling \"Dots Clickable\" feature sometimes leads to freezing of dots and thus sometimes Indicator Dots are misbehaved")
//                    .setPositiveButton("Continue to Enable", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    })
//                    .setCancelable(false);
//        }
        this.recreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }
}
