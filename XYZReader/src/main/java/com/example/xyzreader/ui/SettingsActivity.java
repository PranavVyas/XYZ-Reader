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
        if(key == getString(R.string.key_pref_dots_clickable)) {
            final boolean newPref = sharedPreferences.getBoolean(getString(R.string.key_pref_dots_clickable), false);
            if (newPref) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                dialogBuilder.setTitle(R.string.dialog_settings_dots_indicator_title)
                        .setMessage(R.string.dialog_settings_dots_indicator_message)
                        .setPositiveButton(R.string.dialog_settings_dots_indicator_positivebtn, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SettingsActivity.this.recreate();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(R.string.dialog_settings_dots_indicator_negativebtn, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this).edit();
                                edit.putBoolean(getString(R.string.key_pref_dots_clickable), false);
                                edit.apply();
                                dialog.dismiss();
                                SettingsActivity.this.recreate();
                            }
                        })
                        .setCancelable(false).create().show();
            }
        }else if (key == getString(R.string.key_pref_dark_theme)){
            this.recreate();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }
}
