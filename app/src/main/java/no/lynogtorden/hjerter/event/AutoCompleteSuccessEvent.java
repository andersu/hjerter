package no.lynogtorden.hjerter.event;

import java.util.List;

import no.lynogtorden.hjerter.domain.Place;

public class AutoCompleteSuccessEvent extends Event {

    private List<Place> places;

    public AutoCompleteSuccessEvent(List<Place> places) {
        super();
        this.places = places;
    }

    public List<Place> getPlaces() {
        return places;
    }
}
