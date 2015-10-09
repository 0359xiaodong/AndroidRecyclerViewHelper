package com.vilyever.androidrecyclerviewhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.vilyever.recyclerviewhelper.VDRecyclerViewAdapter;
import com.vilyever.recyclerviewhelper.VDRecyclerViewHolderDatasource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TestAdapter testAdapter;
    private List<Info> infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(getTestAdapter());
    }

    public TestAdapter getTestAdapter() {
        if (testAdapter == null) {
            testAdapter = new TestAdapter();
            testAdapter.setDatasource(new VDRecyclerViewAdapter.Datasource() {
                @Override
                public int itemCountForRecyclerViewAdapter(VDRecyclerViewAdapter adapter) {
                    return getInfos().size();
                }

                @Override
                public VDRecyclerViewHolderDatasource itemDatasourceForRecyclerViewAdapter(VDRecyclerViewAdapter adapter, int position, VDRecyclerViewHolderDatasource datasource) {
                    return getInfos().get(position);
                }
            });
        }
        return testAdapter;
    }

    public List<Info> getInfos() {
        if (infos == null) {
            infos = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                infos.add(new Info("title " + i));
            }
        }
        return infos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class Info implements TestViewHolder.Datasource {
        public String title;

        public Info() {

        }

        public Info(String title) {
            this.title = title;
        }

        @Override
        public String titleForViewHolder(TestViewHolder viewHolder) {
            return this.title;
        }
    }
}
