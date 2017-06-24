package db;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;
import model.Place;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class PlacesRepository {

    private DatabaseReference places;

    public PlacesRepository() {
        try {
            final InputStream is = PlacesRepository.class.getClassLoader().getResourceAsStream("firebase.json");


            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredential(FirebaseCredentials.fromCertificate(is))
                    .setDatabaseUrl("https://places-31cec.firebaseio.com")
                    .build();

            final FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
            places = FirebaseDatabase.getInstance().getReference().child("places");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Place> find(){
        return null;
    }

    public void save(Place place) {
        final HashMap<String, Object> placesMap = new HashMap<>();
        placesMap.put(place.getId(), place);
        places.setValue(placesMap);

    }

    public Place find(String id){
        return null;
    }

}
