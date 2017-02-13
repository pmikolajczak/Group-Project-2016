package projekt.pizzaby;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import projekt.pizzaby.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public MainViewModel mainViewModel;
    public ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        binding.setViewModel(mainViewModel);

    }
}
