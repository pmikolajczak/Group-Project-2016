package projekt.pizzaby;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import projekt.pizzaby.databinding.ActivitySkladnikiBinding;

/**
 * Created by robert on 15.02.2017.
 */

public class SkladnikiViewModel extends BaseViewModel {

    public CheckBoxesAdapter checkBoxesAdapter;
    public List<CheckBoxViewModel> checkBoxViewModelList = new ArrayList<>();
    public List<String> skladniki;

    public SkladnikiViewModel(Context context, ActivitySkladnikiBinding binding) {
        super(context);

        String str = "sos,ser,zioła,pieczarki,papryka,cebula,boczek,salami,ananas,rucola,feta,kukurydza,kurczak,kiełbasa,pomidor,ogórek kiszony,peperoni,szynka";
        skladniki = new ArrayList<String>(Arrays.asList(str.split(",")));

        for (String skladnik : skladniki) {
            checkBoxViewModelList.add(new CheckBoxViewModel(false, skladnik, true));
        }

        checkBoxesAdapter = new CheckBoxesAdapter(checkBoxViewModelList);
        binding.recycler.setLayoutManager(new LinearLayoutManager(context));
        binding.recycler.setAdapter(checkBoxesAdapter);
    }

    public void onFabClick() {

    }
}
