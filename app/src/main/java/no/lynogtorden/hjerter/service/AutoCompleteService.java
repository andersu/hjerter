package no.lynogtorden.hjerter.service;

import java.util.List;

import no.lynogtorden.hjerter.domain.Place;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.Callback;

public interface AutoCompleteService {
    @GET("/ReisRest/Place/Autocomplete/{searchTerm}")
    void autocomplete(@Path("searchTerm") String searchTerm, Callback<List<Place>> callback);
}
