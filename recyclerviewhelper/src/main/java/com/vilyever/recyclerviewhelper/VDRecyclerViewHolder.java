package com.vilyever.recyclerviewhelper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;

/**
 * VDRecyclerViewHolder
 * AndroidRecyclerViewHelper <com.vilyever.recyclerviewhelper>
 * Created by vilyever on 2015/10/8.
 * Feature:
 */
public abstract class VDRecyclerViewHolder extends RecyclerView.ViewHolder {
    private final VDRecyclerViewHolder self = this;

    protected VDRecyclerViewHolderDatasource datasource;
    protected Delegate delegate;

    /* #Constructors */
    public VDRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    /* #Overrides */

    /* #Accessors */
    public <T extends VDRecyclerViewHolderDatasource> T getDatasource() {
        return (T) datasource;
    }

    public void setDatasource(VDRecyclerViewHolderDatasource datasource) {
        this.datasource = datasource;
        self.reloadData();
    }

    public <T extends Delegate> T getDelegate() {
        return (T) delegate;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    /* #Delegates */

    /* #Private Methods */

    /* #Public Methods */
    public abstract void reloadData();

    public static <T extends VDRecyclerViewHolder> T CreateInstance(Class<?> clazz, ViewGroup parent, int layoutID) {
        ViewGroup itemView = (ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(layoutID, parent, false);

        try {
            Constructor constructor = clazz.getDeclaredConstructor(new Class[]{View.class});
            constructor.setAccessible(true);
            T viewHolder = (T) constructor.newInstance(itemView);
            return viewHolder;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /* #Classes */

    /* #Interfaces */
    public interface Datasource extends VDRecyclerViewHolderDatasource {
    }

    public interface Delegate {
    }

    /* #Annotations @interface */

    /* #Enums */

}