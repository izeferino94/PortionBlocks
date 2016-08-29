package edu.izeferinucsd.portionblocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView plansList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    String[] testText = {"low carb", "high energy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plansList = (RecyclerView)findViewById(R.id.planList);
        adapter = new PlanListAdapter(testText);
        layoutManager = new LinearLayoutManager(this);
        plansList.setLayoutManager(layoutManager);
        plansList.setHasFixedSize(true);
        plansList.setAdapter(adapter);
    }
}
