package edu.izeferinucsd.portionblocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class PortionBlocksActivity extends AppCompatActivity implements UserInputObserver{
    private LinearLayout portionView;
    private Button  addRow;
    private int[] colorsp90x = {0xFFA54A0B, 0xFF89A29F, 0xFF920D76, 0xFF486911, 0xFFF5CC3F,
                                0xFFB3846E};
    private int colorCounter = -1;
    private PortionBlockDialog dialog;
    private HorizontalScrollView portionClass;
    private TableRow row;
    private TextView portionHeader;

    private String portionName;
    private int caloriesPerPortion, portionCount;

    public PortionBlocksActivity()
    {
        super();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portion_blocks);

        addRow = (Button) findViewById(R.id.newRowButton);
        portionView = (LinearLayout) findViewById(R.id.portion_view);

        addRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++colorCounter;
                colorCounter = colorCounter == 6 ? 0 : colorCounter;
                portionHeader = new TextView(PortionBlocksActivity.this);
                portionClass = new HorizontalScrollView(PortionBlocksActivity.this);
                row = new TableRow(PortionBlocksActivity.this);
                dialog = new PortionBlockDialog();

                row.setPadding(0, 10, 0, 10);
                portionClass.setHorizontalScrollBarEnabled(false);
                portionView.addView(portionHeader);
                portionView.addView(portionClass);
                portionClass.addView(row);

                dialog.registerObserver(PortionBlocksActivity.this);
                dialog.show(getSupportFragmentManager(), "portion_dialog");

            }
        });
    }
    public void update()
    {
        portionHeader.setText(dialog.getPortionName());
        caloriesPerPortion = dialog.getCaloriesPerPortion();
        portionCount = dialog.getPortionCount();
        generateBlocks();
    }

    private void generateBlocks()
    {
        for (int i = 0; i < portionCount; i++)
        {
            final Button myButton = new Button(PortionBlocksActivity.this);
            row.addView(myButton);
            myButton.getLayoutParams().height = 100;
            myButton.getLayoutParams().width = 100;
            ViewGroup.MarginLayoutParams margins = (ViewGroup.MarginLayoutParams) myButton.getLayoutParams();
            margins.leftMargin = 10;
            margins.rightMargin = 10;
            myButton.setBackgroundColor(colorsp90x[colorCounter]);
            myButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    myButton.setText("");
                    return false;
                }
            });
        }
    }


}
