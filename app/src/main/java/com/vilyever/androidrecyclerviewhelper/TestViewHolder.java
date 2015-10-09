package com.vilyever.androidrecyclerviewhelper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vilyever.recyclerviewhelper.VDRecyclerViewHolder;

/**
 * TestViewHolder
 * AndroidRecyclerViewHelper <com.vilyever.androidrecyclerviewhelper>
 * Created by vilyever on 2015/10/8.
 * Feature:
 */
public class TestViewHolder extends VDRecyclerViewHolder {
    final TestViewHolder self = this;

    private TextView titleLabel;

    /* #Constructors */
    public TestViewHolder(View itemView) {
        super(itemView);
        self.titleLabel = (TextView) itemView.findViewById(R.id.titleLabel);
    }
    
    /* #Overrides */
    @Override
    public void reloadData() {
        Datasource datasource = self.getDatasource();
        self.titleLabel.setText(datasource.titleForViewHolder(self));
    }
    
    /* #Accessors */     
     
    /* #Delegates */     
     
    /* #Private Methods */    
    
    /* #Public Methods */
    public static TestViewHolder newInstance(ViewGroup parent) {
        return TestViewHolder.CreateInstance(TestViewHolder.class, parent, R.layout.test_view_holder);
    }

    /* #Classes */

    /* #Interfaces */
    public interface Datasource extends VDRecyclerViewHolder.Datasource {
        String titleForViewHolder(TestViewHolder viewHolder);
    }
     
    /* #Annotations @interface */    
    
    /* #Enums */
}