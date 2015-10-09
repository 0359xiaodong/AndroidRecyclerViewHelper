package com.vilyever.recyclerviewhelper;

/**
 * VDRecyclerViewAdapterDatasource
 * AndroidRecyclerViewHelper <com.vilyever.recyclerviewhelper>
 * Created by vilyever on 2015/10/8.
 * Feature:
 */
public interface VDRecyclerViewAdapterDatasource {
    int itemCountForRecyclerViewAdapter(VDRecyclerViewAdapter adapter);
    VDRecyclerViewHolderDatasource itemDatasourceForRecyclerViewAdapter(VDRecyclerViewAdapter adapter, int position, VDRecyclerViewHolderDatasource datasource);
}
