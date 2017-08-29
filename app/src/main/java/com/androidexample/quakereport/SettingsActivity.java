package com.androidexample.quakereport;


import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }
// our PreferenceFragment can implement the OnPreferenceChangeListener interface to get notified when a preference changes.
// Then when a single Preference has been changed by the user and is about to be saved, the onPreferenceChange() method
// will be invoked with the key of the preference that was changed. Note that this method returns a boolean,
// which allows us to prevent a proposed preference change by returning false.

    public static class EarthquakePreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
        private void bindPreferenceSummaryToValue(Preference preference) {
            // prefence ayi us pr change listener chalaya
            preference.setOnPreferenceChangeListener(this);
            // preference nikal li sshared prefernce me
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            //string me convert key value ko
            String preferenceString = preferences.getString(preference.getKey(), "");
            //set krdi summary value m
            onPreferenceChange(preference, preferenceString);
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);
            //preference ka obj
            Preference minMagnitude = findPreference(getString(R.string.settings_min_magnitude_key));
            // set krdia min mag ke neeche
            bindPreferenceSummaryToValue(minMagnitude);
//Finally, we'll add additional logic in the EarthquakePreferenceFragment so that it is aware of the
// new ListPreference, similar to what we did for the EditTextPreference. In the onCreate() method of the fragment,
// find the “order by” Preference object according to its key. Then call the bindPreferenceSummaryToValue()
// helper method on this Preference object, which will set this fragment as the OnPreferenceChangeListener and
// update the summary so that it displays the current value stored in SharedPreferences.
            Preference orderBy = findPreference(getString(R.string.settings_order_by_key));
            bindPreferenceSummaryToValue(orderBy);

        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            // change hote hi value nikal ke sambhal li
            String stringValue = value.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                preference.setSummary(stringValue);
            }
            return true;

        }
    }
    }
