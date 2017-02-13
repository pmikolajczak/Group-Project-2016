package projekt.pizzaby;

import android.content.Context;
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

/**
 * Created by robert on 13.02.2017.
 */

public class MainViewModel extends BaseViewModel implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public LocationManager locationManager;
    public GoogleApiClient googleApiClient;
    public Location location;

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

        if (!gotLocationAlready.get()){
        this.location = location;

        latText.set("" + location.getLatitude());
        lonText.set("" + location.getLongitude());

        gotLocationAlready.set(true);
        }
    }
}
