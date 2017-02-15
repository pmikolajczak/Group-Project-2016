package projekt.pizzaby;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import projekt.pizzaby.databinding.ActivitySkladnikiBinding;

/**
 * Created by robert on 15.02.2017.
 */

public class SkladnikiActivity extends AppCompatActivity {

    public SkladnikiViewModel skladnikiViewModel;
    public ActivitySkladnikiBinding binding;
    public String lat;
    public String lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        lat = intent.getStringExtra("lat");
        lon = intent.getStringExtra("lon");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_skladniki);
        skladnikiViewModel = new SkladnikiViewModel(this, binding, lat, lon);
        binding.setViewModel(skladnikiViewModel);
    }
}
