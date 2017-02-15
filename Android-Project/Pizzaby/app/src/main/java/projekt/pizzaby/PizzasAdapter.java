package projekt.pizzaby;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import projekt.pizzaby.api.PizzaMapped;
import projekt.pizzaby.databinding.PizzaItemBinding;

/**
 * Created by robert on 15.02.2017.
 */

public class PizzasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<PizzaMapped> listOfPizzas;

    public List<SinglePizzaViewModel> vmList = new ArrayList<>();

    public PizzasAdapter(List<PizzaMapped> list) {
        this.listOfPizzas = list;

        for (PizzaMapped pizza : listOfPizzas) {
            vmList.add(new SinglePizzaViewModel(pizza));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PizzaItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.pizza_item, parent, false);
        return new PizzaVH(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PizzaVH pizzaVH = (PizzaVH) holder;
        PizzaItemBinding binding = pizzaVH.binding;
        binding.setViewModel(vmList.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfPizzas.size();
    }

    public class PizzaVH extends RecyclerView.ViewHolder {

        private PizzaItemBinding binding;

        public PizzaVH(PizzaItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
