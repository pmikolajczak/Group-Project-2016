package projekt.pizzaby;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import projekt.pizzaby.databinding.CheckboxItemBinding;

/**
 * Created by robert on 15.02.2017.
 */

public class CheckBoxesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<CheckBoxViewModel> vms;

    public CheckBoxesAdapter(List<CheckBoxViewModel> vms) {
        this.vms = vms;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CheckboxItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.checkbox_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        CheckboxItemBinding binding = myViewHolder.binding;
        CheckBoxViewModel vm = vms.get(position);
        if (position <= 2) {
            vm.enabled.set(false);
            vm.checked.set(true);
        }
        binding.setViewModel(vm);
    }

    @Override
    public int getItemCount() {
        return vms.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CheckboxItemBinding binding;

        public MyViewHolder(CheckboxItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
