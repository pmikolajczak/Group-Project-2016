package projekt.pizzaby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projekt.pizzaby.databinding.ActivitySkladnikiBinding;

/**
 * Created by robert on 15.02.2017.
 */

public class SkladnikiActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "SharedPreferences";
    public SkladnikiViewModel skladnikiViewModel;
    public ActivitySkladnikiBinding binding;
    public String lat;
    public String lon;
    public AlertDialog alert;
    public int rozmiarOd = 1;
    public int rozmiarDo = 100;
    private SharedPreferences sharedPreferences;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("settings")) {

                final View layout = View.inflate(SkladnikiActivity.this, R.layout.settings_dialog, null);
                alert = new AlertDialog.Builder(SkladnikiActivity.this).create();
                alert.setView(layout);

                sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                final EditText min = (EditText) layout.findViewById(R.id.size_od);
                min.setText(sharedPreferences.getString("min", "1"));

                final EditText max = (EditText) layout.findViewById(R.id.size_do);
                max.setText(sharedPreferences.getString("max", "99"));

                final Button okButton = (Button) layout.findViewById(R.id.ok_button);

                okButton.setOnClickListener(view -> {

                    if (Integer.valueOf(min.getText().toString()) > 0
                            && Integer.valueOf(min.getText().toString()) < 101
                            && Integer.valueOf(max.getText().toString()) < 101
                            && Integer.valueOf(max.getText().toString()) > 0
                            && Integer.valueOf(max.getText().toString()) > Integer.valueOf(min.getText().toString())) {
                        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("min", min.getText().toString());
                        editor.putString("max", max.getText().toString());
                        editor.apply();
                        skladnikiViewModel.updateMinMax(min.getText().toString(), max.getText().toString());

                        alert.dismiss();
                    } else {
                        Toast.makeText(context, "Podaj liczby w zakresie od 1 do 100", Toast.LENGTH_SHORT).show();
                    }
                    
                });

                alert.show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        lat = intent.getStringExtra("lat");
        lon = intent.getStringExtra("lon");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_skladniki);
        skladnikiViewModel = new SkladnikiViewModel(this, binding, lat, lon);
        binding.setViewModel(skladnikiViewModel);


        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter("settings"));
    }
}
