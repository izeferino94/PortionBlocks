package edu.izeferinucsd.portionblocks;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    private RecyclerView plansList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
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
    }
}
