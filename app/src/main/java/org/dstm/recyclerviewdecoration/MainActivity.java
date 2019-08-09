package org.dstm.recyclerviewdecoration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private TimeAdapter adapter;
    private TimeDecoration decoration;
    private List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rl);
        itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemList.add("item"+i);
        }
        decoration = new TimeDecoration();
        adapter = new TimeAdapter(this,itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(decoration);
    }
}
