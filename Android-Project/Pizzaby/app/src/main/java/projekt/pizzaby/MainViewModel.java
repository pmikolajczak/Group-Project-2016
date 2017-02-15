package projekt.pizzaby;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.Collection;
import java.util.List;

import projekt.pizzaby.api.PizzaMapped;
import projekt.pizzaby.api.PizzeriaMapped;
import rx.Observable;

/**
 * Created by robert on 13.02.2017.
 */

public class MainViewModel extends BaseViewModel implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public LocationManager locationManager;
    public GoogleApiClient googleApiClient;
    public Location location;
    public Observable<Collection<PizzeriaMapped>> apiPizzeriaResponseObservable;
    public Observable<PizzaMapped[]> apiPizzaResponseObservable;
    public List<String> skladniki;

    public ObservableField<String> latText = new ObservableField<>("");
    public ObservableField<String> lonText = new ObservableField<>("");

    public ObservableBoolean gotLocationAlready = new ObservableBoolean(false);
    public LocationRequest mLocationRequest;

    public MainViewModel(Context context) {
        super(context);

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        mLocationRequest = new LocationRequest();

        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            googleApiClient.connect();
        }

        System.out.println("aaaaa");
    }

    private void startLocationUpdates() {
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10000)
                .setFastestInterval(5000);

        try {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, mLocationRequest, this);
        } catch (SecurityException e) {
            Toast.makeText(context, "error2", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {

        if (!gotLocationAlready.get()) {
            this.location = location;

            latText.set("" + location.getLatitude());
            lonText.set("" + location.getLongitude());

            gotLocationAlready.set(true);
        }
    }

    public void buttonAction() {
        Intent intent = new Intent(context, SkladnikiActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("lat", latText.get());
        intent.putExtra("lon", lonText.get());
        context.startActivity(intent);
    }


    /*

        Map<String, String> skladniki = new HashMap<>();

        skladniki.put("ingredientCollection[0]", "pieczarki");
        skladniki.put("ingredientCollection[1]", "szynka");

        apiPizzeriaResponseObservable = api.getData(skladniki, 54.368, 18.61, 2, 100);
        apiPizzeriaResponseObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(apiPizzaResponse -> {
                            System.out.println("00000000000000000000000000000000000");
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            System.out.println("1111111111111111111111111111111111111");
                        });
     */
}
