package edu.izeferinucsd.portionblocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class PortionBlocksActivity extends AppCompatActivity {
    private ImageView block;
    private Button addColumn, addRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portion_blocks);
        block = (ImageView) findViewById(R.id.imageView);
        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block.setVisibility(View.GONE);
            }
        });
        final TableLayout blockTable = (TableLayout) findViewById(R.id.blockTable);
        /*
        final TableRow row = new TableRow(PortionBlocksActivity.this);
        blockTable.addView(row);
        addColumn = (Button) findViewById(R.id.test_button);
        addColumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button myButton = new Button(PortionBlocksActivity.this);
                myButton.setText("Add Me");
                row.addView(myButton);
            }
        });
        */
        addRow =(Button) findViewById(R.id.newRowButton);
        addRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TableRow row = new TableRow(PortionBlocksActivity.this);
                blockTable.addView(row);
                addColumn = (Button) findViewById(R.id.test_button);
                addColumn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Button myButton = new Button(PortionBlocksActivity.this);
                        myButton.setText("Add Me");
                        row.addView(myButton);
                        myButton.setOnTouchListener(new Button.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                    // start your timer

                                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                                    // stop your timer.
                                    myButton.setText("Pressed");

                                }
                                return false;
                            }
                        });
                    }
                });
            }
        });

    }

}
