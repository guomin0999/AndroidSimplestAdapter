package com.guomin.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listVie);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        BeanAdapter<String> adapter = new BeanAdapter<String>(this, android.R.layout.simple_list_item_1) {
            public void getView(int position, ViewHolder holder, String bean) {
                holder.text(android.R.id.text1, bean);
            }
        };

        RecyclerAdapter<String> recyclerAdapter = new RecyclerAdapter<String>(this, android.R.layout.simple_list_item_1) {
            public void onBindViewHolder(ViewHolder holder, int position, String bean) {
                holder.text(android.R.id.text1, bean);
            }
        };

        for (int i = 0; i < 999; i++) {
            adapter.list.add("Item " + i);
            recyclerAdapter.list.add("Item " + i);
        }

        listView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

    }
}
