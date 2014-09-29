package no.lynogtorden.hjerter.ui;

import android.app.Fragment;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import no.lynogtorden.hjerter.R;
import no.lynogtorden.hjerter.domain.Place;
import no.lynogtorden.hjerter.event.AutoCompleteFailureEvent;
import no.lynogtorden.hjerter.event.AutoCompleteSuccessEvent;
import no.lynogtorden.hjerter.task.AutoCompleteTask;
import no.lynogtorden.hjerter.util.BusProvider;

@EFragment(R.layout.fragment_realtime)
public class RealTimeFragment extends Fragment {

    @ViewById
    protected EditText editTextSearch;

    @Bean
    protected AutoCompleteTask autoCompleteTask;

    @Click
    protected void buttonSearchClicked() {
        String searchTerm = editTextSearch.getText().toString();
        autoCompleteTask.autocomplete(searchTerm);
    }

    @Subscribe
    public void onAutoCompleteSuccessEvent(AutoCompleteSuccessEvent autoCompleteSuccessEvent) {
        List<Place> places = autoCompleteSuccessEvent.getPlaces();
        Log.d("Hjerter", autoCompleteSuccessEvent.getPlaces().toString());
        Toast.makeText(getActivity(), "Fikk success", Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onAutoCompleteFailureEvent(AutoCompleteFailureEvent autoCompleteFailureEvent) {
        Toast.makeText(getActivity(), "Fikk failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        BusProvider.getInstance().unregister(this);
        super.onPause();
    }
}
