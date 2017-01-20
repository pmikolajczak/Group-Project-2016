package projekt.pizzaby;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import projekt.pizzaby.api.Api;
import projekt.pizzaby.utils.RetrofitFactory;
import retrofit2.adapter.rxjava.HttpException;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by User on 2016-11-25.
 */

public abstract class BaseViewModel extends BaseObservable {

    public final ObservableField<STATE> state = new ObservableField<>(STATE.IDLE);
    public Api api;
    protected Context context;

    public BaseViewModel(Context context) {
        this.context = context;
        api = RetrofitFactory.getFactory().getApi();
    }


    public boolean handleException(Throwable throwable) {

        if (throwable instanceof HttpException) {
            HttpException ex = (HttpException) throwable;

            if (ex.code() == 404) {

            }

            if (ex.code() == 500) {

            }

        } else if (throwable instanceof UnknownHostException) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo == null || !netInfo.isConnectedOrConnecting()) {
                Toast.makeText(context, "no_internet_connection_error", Toast.LENGTH_LONG).show();
            }
        } else if (throwable instanceof SocketTimeoutException) {
            Toast.makeText(context, "timeout", Toast.LENGTH_LONG).show();
        } else {
            throwable.printStackTrace();
            Toast.makeText(context, "unknown_error", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public enum STATE {LOADING, IDLE}
}
