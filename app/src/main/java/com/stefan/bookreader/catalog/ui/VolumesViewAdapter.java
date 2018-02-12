package com.stefan.bookreader.catalog.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.stefan.bookreader.R;
import com.stefan.bookreader.catalog.CatalogActions;
import com.stefan.bookreader.networking.model.Volume;
import com.stefan.bookreader.networking.model.Volumes;
import com.stefan.bookreader.databinding.RecyclerBookItemBinding;

/**
 * Created by stefan on 2/10/2018.
 */

public class VolumesViewAdapter extends RecyclerView.Adapter<VolumesViewAdapter.VolumesView> {


    private Volumes volumes;
    private CatalogActions catalogActions;

    public VolumesViewAdapter(Volumes volumes, CatalogActions catalogActions) {
        this.volumes = volumes;
        this.catalogActions = catalogActions;
    }

    @Override
    public VolumesView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerBookItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_book_item, parent, false);
        return new VolumesView(binding);
    }

    @Override
    public void onBindViewHolder(VolumesView holder, int position) {
        holder.setBinding(volumes.getItems().get(position),catalogActions);
    }

    @Override
    public int getItemCount() {
        return volumes.getItems().size();
    }

    public static class VolumesView extends RecyclerView.ViewHolder {

        private RecyclerBookItemBinding binding;

        public VolumesView(RecyclerBookItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setBinding(Volume volume, CatalogActions catalogActions) {
            binding.setVolume(volume);
            binding.setCatalogActions(catalogActions);
        }
    }

    @VisibleForTesting
    public Volumes getVolumes() {
        return volumes;
    }
}
