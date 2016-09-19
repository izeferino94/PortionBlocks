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
    private RelativeLayout relativeLayout;
    private Button addColumn, addRow;
    private int[] colors = {0xFFAE69AE, 0xFF0080FF, 0xFFCCFFCC, 0xFFFF7373, 0xFFEEAEEE};
    private int[] colorsp90x = {0xFFA54A0B, 0xFF89A29F, 0xFF920D76, 0xFF486911, 0xFFF5CC3F,
                                0xFFB3846E};
    private int i = -1;
    private boolean blockAdded = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portion_blocks);

        addRow = (Button) findViewById(R.id.newRowButton);
        addColumn = (Button) findViewById(R.id.newColumnButton);
        final LinearLayout portionView = (LinearLayout) findViewById(R.id.portion_view);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl);


        addRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PortionBlockDialog dialog = new PortionBlockDialog();
                dialog.show(getSupportFragmentManager(), "portion_dialog");


                if(blockAdded) {
                    blockAdded = !blockAdded;
                    ++i;
                    i = i == 6 ? 0 : i;
                    HorizontalScrollView portionClass = new HorizontalScrollView(PortionBlocksActivity.this);
                    final TableRow row = new TableRow(PortionBlocksActivity.this);
                    row.setPadding(0, 10, 0, 10);

                    portionClass.setHorizontalScrollBarEnabled(false);

                    portionView.addView(portionClass);
                    portionClass.addView(row);

                    addColumn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            blockAdded = true;
                            final Button myButton = new Button(PortionBlocksActivity.this);
                            row.addView(myButton);
                            myButton.getLayoutParams().height = 100;
                            myButton.getLayoutParams().width = 100;
                            ViewGroup.MarginLayoutParams margins = (ViewGroup.MarginLayoutParams) myButton.getLayoutParams();
                            margins.leftMargin = 10;
                            margins.rightMargin = 10;
                            myButton.setBackgroundColor(colorsp90x[i]);

                            myButton.setOnLongClickListener(new View.OnLongClickListener() {
                                @Override
                                public boolean onLongClick(View v) {
                                    myButton.setText("OK");
                                    return false;
                                }
                            });
                        }
                    });
                }
            }
        });

    }



}
