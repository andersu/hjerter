package no.lynogtorden.hjerter.ui;

import android.app.Activity;
import android.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import no.lynogtorden.hjerter.R;
import no.lynogtorden.hjerter.util.BusProvider;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @AfterViews
    protected void init() {
        replaceFragment(RealTimeFragment_.builder().build(), false);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackstack) {
        if(addToBackstack) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
}
