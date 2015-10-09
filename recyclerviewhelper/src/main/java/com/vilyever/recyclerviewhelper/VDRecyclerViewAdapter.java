package com.vilyever.recyclerviewhelper;

import android.support.v7.widget.RecyclerView;

/**
 * VDRecyclerAdapter
 * AndroidRecyclerViewHelper <com.vilyever.recyclerviewhelper>
 * Created by vilyever on 2015/10/8.
 * Feature:
 */
public abstract class VDRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final VDRecyclerViewAdapter self = this;

    protected VDRecyclerViewAdapterDatasource datasource;
    protected Delegate delegate;

    protected RecyclerView recyclerView;

    /* #Constructors */
    public VDRecyclerViewAdapter() {
        // Required empty public constructor
    }

    public VDRecyclerViewAdapter(RecyclerView recyclerView) {
        self.recyclerView = recyclerView;
    }

    /* #Overrides */

    /* #Accessors */
    public <T extends VDRecyclerViewAdapterDatasource> T getDatasource() {
        return (T) datasource;
    }

    public void setDatasource(VDRecyclerViewAdapterDatasource datasource) {
        this.datasource = datasource;
        self.notifyDataSetChanged();
    }

    public <T extends Delegate> T getDelegate() {
        return (T) delegate;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    /* #Delegates */

    /* #Private Methods */

    /* #Protected Methods */
    public <T extends VDRecyclerViewHolder> void localOnBindViewHolder(T holder, int position) {
        self.bindItemDatasource(holder, position);
    }

    public int localGetItemCount() {
        int count = 0;
        if (self.getDatasource() != null) {
            count = self.getDatasource().itemCountForRecyclerViewAdapter(self);
        }
        return count;
    }

    /* #Public Methods */
    public <T extends VDRecyclerViewHolder> void bindItemDatasource(T holder, int position) {
        holder.setDatasource(self.getDatasource().itemDatasourceForRecyclerViewAdapter(self, position, holder.getDatasource()));
    }

    /* #Classes */

    /* #Interfaces */
    public interface Datasource extends VDRecyclerViewAdapterDatasource {
    }

    public interface Delegate {
    }
     
    /* #Annotations @interface */    
    
    /* #Enums */
}