package no.lynogtorden.hjerter.task;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import no.lynogtorden.hjerter.event.AutoCompleteFailureEvent;
import no.lynogtorden.hjerter.restservice.AutoCompleteRestService;
import no.lynogtorden.hjerter.util.BusProvider;

@EBean
public class AutoCompleteTask {

    @Bean
    protected AutoCompleteRestService autoCompleteRestService;

    @Background
    public void autocomplete(String searchTerm) {
        try {
            autoCompleteRestService.autocomplete(searchTerm);
        } catch (Exception e) {
            BusProvider.updateUi(new AutoCompleteFailureEvent(e.getMessage()));
        }
    }
}
