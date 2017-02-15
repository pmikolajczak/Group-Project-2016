package projekt.pizzaby;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import projekt.pizzaby.api.PizzeriaMapped;
import projekt.pizzaby.databinding.ActivitySkladnikiBinding;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by robert on 15.02.2017.
 */

public class SkladnikiViewModel extends BaseViewModel {

    public CheckBoxesAdapter checkBoxesAdapter;
    public List<CheckBoxViewModel> checkBoxViewModelList = new ArrayList<>();
    public List<String> skladniki;
    public Observable<Collection<PizzeriaMapped>> apiPizzeriaResponseObservable;
    public ActivitySkladnikiBinding binding;
    public Double lat;
    public Double lon;
    public Integer minSize = 1;
    public Integer maxSize = 100;

    public SkladnikiViewModel(Context context, ActivitySkladnikiBinding binding,
                              String lat, String lon) {
        super(context);

        this.binding = binding;
        this.lat = Double.valueOf(lat);
        this.lon = Double.valueOf(lon);

        String str = "sos,ser,zioła,pieczarki,papryka,cebula,boczek,salami,ananas,rucola,feta,kukurydza,kurczak,kiełbasa,pomidor,ogórek kiszony,peperoni,szynka";
        skladniki = new ArrayList<String>(Arrays.asList(str.split(",")));

        for (String skladnik : skladniki) {
            checkBoxViewModelList.add(new CheckBoxViewModel(false, skladnik, true));
        }

        checkBoxesAdapter = new CheckBoxesAdapter(checkBoxViewModelList);
        binding.recycler.setLayoutManager(new LinearLayoutManager(context));
        binding.recycler.setAdapter(checkBoxesAdapter);
    }

    public void updateMinMax(String min, String max){
        minSize = Integer.valueOf(min);
        maxSize = Integer.valueOf(max);
    }

    public void onFabClick() {
        Map<String, String> skladniki = new HashMap<>();
        int j = 0;
        for (int i = 0; i < checkBoxesAdapter.getItemCount(); i++) {
            if (checkBoxesAdapter.vms.get(i).checked.get()) {
                skladniki.put("ingredientCollection[" + j + "]", checkBoxesAdapter.vms.get(i).skladnik.get());
                j++;
            }
        }

        apiPizzeriaResponseObservable = api.getData(skladniki, lat, lon, minSize, maxSize); // 54.38, 18.61
        apiPizzeriaResponseObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(apiPizzaResponse -> {
                            PizzeriasListSingleton.getInstance().setList((List<PizzeriaMapped>) apiPizzaResponse);
                            Intent intent = new Intent(context, PizzeriasActivity.class);
                            context.startActivity(intent);
                        },
                        throwable -> {
                            Toast.makeText(context, "błąd", Toast.LENGTH_SHORT).show();
                        });
    }

    public void settings(){
        Intent intent = new Intent("settings");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
