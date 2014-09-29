package no.lynogtorden.hjerter.restservice;

import org.androidannotations.annotations.EBean;

import java.util.List;

import no.lynogtorden.hjerter.domain.Place;
import no.lynogtorden.hjerter.event.AutoCompleteFailureEvent;
import no.lynogtorden.hjerter.event.AutoCompleteSuccessEvent;
import no.lynogtorden.hjerter.service.AutoCompleteService;
import no.lynogtorden.hjerter.util.BusProvider;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EBean
public class AutoCompleteRestService extends RestService {

        public void autocomplete(String searchTerm) {
            AutoCompleteService autoCompleteService = getRestAdapter().create(AutoCompleteService.class);

            Callback<List<Place>> callback = new Callback<List<Place>>() {
                @Override
                public void success(List<Place> places, Response response) {
                    BusProvider.updateUi(new AutoCompleteSuccessEvent(places));
                }

                @Override
                public void failure(RetrofitError error) {
                    BusProvider.updateUi(new AutoCompleteFailureEvent(error.getMessage()));
                }
            };

            autoCompleteService.autocomplete(searchTerm, callback);
        }
}
