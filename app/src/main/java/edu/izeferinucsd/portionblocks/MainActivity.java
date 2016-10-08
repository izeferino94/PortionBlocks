package edu.izeferinucsd.portionblocks;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView plansList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    FloatingActionButton fab;
    private ArrayList<String> testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testText = new ArrayList<>();
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
                Intent intent = new Intent(MainActivity.this, PortionBlocksActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                testText.add(data.getStringExtra("PlanName"));
                plansList.setAdapter(adapter);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //NOCODE YET
            }
        }
    }
}
