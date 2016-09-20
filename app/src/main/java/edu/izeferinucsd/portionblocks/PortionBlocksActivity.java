package edu.izeferinucsd.portionblocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;


public class PortionBlocksActivity extends AppCompatActivity {
    private LinearLayout portionView;
    private Button  addRow;
    private int[] colors = {0xFFAE69AE, 0xFF0080FF, 0xFFCCFFCC, 0xFFFF7373, 0xFFEEAEEE};
    private int[] colorsp90x = {0xFFA54A0B, 0xFF89A29F, 0xFF920D76, 0xFF486911, 0xFFF5CC3F,
                                0xFFB3846E};
    private int i = -1;
    private PortionBlockDialog dialog;
    private HorizontalScrollView portionClass;
    private TableRow row;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portion_blocks);

        addRow = (Button) findViewById(R.id.newRowButton);
        portionView = (LinearLayout) findViewById(R.id.portion_view);


        addRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++i;
                i = i == 6 ? 0 : i;
                portionClass = new HorizontalScrollView(PortionBlocksActivity.this);
                row = new TableRow(PortionBlocksActivity.this);
                row.setPadding(0, 10, 0, 10);
                portionClass.setHorizontalScrollBarEnabled(false);
                portionView.addView(portionClass);
                portionClass.addView(row);
                dialog = new PortionBlockDialog(getApplicationContext(), row, colorsp90x, i);
                dialog.show(getSupportFragmentManager(), "portion_dialog");

            }
        });
    }
}
