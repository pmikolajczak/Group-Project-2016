package projekt.pizzaby;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

/**
 * Created by robert on 15.02.2017.
 */

public class CheckBoxViewModel {

    public ObservableBoolean checked = new ObservableBoolean(false);
    public ObservableBoolean enabled = new ObservableBoolean(true);
    public ObservableField<String> skladnik = new ObservableField<>("");

    public CheckBoxViewModel(boolean checked, String skladnik, boolean enabled){
        this.checked.set(checked);
        this.skladnik.set(skladnik);
        this.enabled.set(enabled);
    }
}
