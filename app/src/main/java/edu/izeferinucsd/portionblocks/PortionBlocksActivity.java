package edu.izeferinucsd.portionblocks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.firebase.client.Firebase;


public class PortionBlocksActivity extends AppCompatActivity implements UserInputObserver{
    private LinearLayout portionView;
    private Button  addRow, savePlan;
    private int[] colorsp90x = {0xFFA54A0B, 0xFF89A29F, 0xFF920D76, 0xFF486911, 0xFFF5CC3F,
                                0xFFB3846E};
    private int colorCounter = -1;
    private PortionBlockDialog dialog;
    private PortionPlanNameDialog savePlanDialog;
    private HorizontalScrollView portionClass;
    private TableRow row;
    private TextView portionHeader;

    private String portionName;
    private int caloriesPerPortion, portionCount;

    private Firebase mRef;

    public PortionBlocksActivity()
    {
        super();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portion_blocks);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://portionblocks.firebaseio.com/");

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

        savePlan = (Button) findViewById(R.id.save_plan);
        savePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePlanDialog = new PortionPlanNameDialog();
                savePlanDialog.registerObserver(PortionBlocksActivity.this);
                savePlanDialog.show(getSupportFragmentManager(), "plan_name_dialog");
            }
        });
    }
    public void update(int returnCode)
    {
        if(returnCode == 1) {
            portionHeader.setText(dialog.getPortionName() + ": " + Integer.toString((dialog.getCaloriesPerPortion())));
            caloriesPerPortion = dialog.getCaloriesPerPortion();
            portionCount = dialog.getPortionCount();
            mRef.child("TempPortionClass").child("ClassName").setValue("Prot");
            mRef.child("TempPortionClass").child("NumberOfPortions").setValue(portionCount);
            mRef.child("TempPortionClass").child("CaloriesPerPortion").setValue(caloriesPerPortion);
            //Firebase mRefChild = mRef.child("TempPortionClass");
            //mRefChild.setValue("TempClass");
            generateBlocks();
        }
        else if(returnCode == 0)
        {
            portionView.removeView(portionClass);
            portionView.removeView(portionHeader);
        }
        else if(returnCode == 2)
        {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("PlanName", savePlanDialog.getPlanName());
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
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
