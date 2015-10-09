package com.vilyever.androidrecyclerviewhelper;

import android.view.ViewGroup;

import com.vilyever.recyclerviewhelper.VDRecyclerViewAdapter;
import com.vilyever.recyclerviewhelper.VDRecyclerViewHolder;

/**
 * TestAdapter
 * AndroidRecyclerViewHelper <com.vilyever.androidrecyclerviewhelper>
 * Created by vilyever on 2015/10/8.
 * Feature:
 */
public class TestAdapter extends VDRecyclerViewAdapter<VDRecyclerViewHolder> {
    final TestAdapter self = this;

    /* #Constructors */
    
    /* #Overrides */
    @Override
    public VDRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return TestViewHolder.newInstance(viewGroup);
    }

    @Override
    public void onBindViewHolder(VDRecyclerViewHolder vdRecyclerViewHolder, int i) {
        self.localOnBindViewHolder(vdRecyclerViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return self.localGetItemCount();
    }
    
    /* #Accessors */     
     
    /* #Delegates */     
     
    /* #Private Methods */    
    
    /* #Public Methods */

    /* #Classes */

    /* #Interfaces */     
     
    /* #Annotations @interface */    
    
    /* #Enums */
}