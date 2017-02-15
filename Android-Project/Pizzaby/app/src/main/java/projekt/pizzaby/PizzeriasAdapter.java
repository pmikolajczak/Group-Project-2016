package projekt.pizzaby;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import projekt.pizzaby.api.PizzeriaMapped;
import projekt.pizzaby.databinding.PizzeriaItemBinding;

/**
 * Created by robert on 15.02.2017.
 */

public class PizzeriasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<PizzeriaMapped> list;
    public List<SinglePizzeriaViewModel> vmList = new ArrayList<>();
    public Context context;

    public PizzeriasAdapter(List<PizzeriaMapped> list, Context context) {
        this.list = list;
        this.context = context;

        if (!vmList.isEmpty()) {
            vmList.clear();
        }

        for (PizzeriaMapped pizzeria : this.list) {
            vmList.add(new SinglePizzeriaViewModel(pizzeria));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PizzeriaItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.pizzeria_item, parent, false);
        return new PizzeriaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int pos = position;
        PizzeriaViewHolder pizzeriaViewHolder = (PizzeriaViewHolder) holder;
        PizzeriaItemBinding binding = pizzeriaViewHolder.binding;
        binding.setViewModel(vmList.get(pos));

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PizzaPopUp(context, list.get(pos)).showDialog();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PizzeriaViewHolder extends RecyclerView.ViewHolder {

        private PizzeriaItemBinding binding;

        public PizzeriaViewHolder(PizzeriaItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
