package edu.izeferinucsd.portionblocks;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView plansList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    FloatingActionButton fab;
    String[] testText1 = new String[1];
    String[] testText = {"low carb", "high energy", "diet", "bulking", "lean", "dgaf", "cheat day", "regular", "1more", "and another"};

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
        fab = (FloatingActionButton) findViewById(R.id.fab_newPlan);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PortionBlocksActivity.class));
            }
        });
    }
}
