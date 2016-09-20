package edu.izeferinucsd.portionblocks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;

/**
 * Created by Isaiah on 9/18/2016.
 */



public class PortionBlockDialog extends DialogFragment {

    private LayoutInflater inflater;
    private View v;
    private EditText caloriesPerPortion;
    private int numberOfPortions;
    private TableRow row;
    private Context context;
    private int[] colors;
    private int counter;

    public PortionBlockDialog(Context context, TableRow row, int[] colors, int counter)
    {
        this.context = context;
        this.row = row;
        this.colors = colors;
        this.counter = counter;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.dialog_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(v).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                caloriesPerPortion = (EditText) v.findViewById(R.id.cal_per_portion);
                numberOfPortions = Integer.parseInt(((EditText) v.findViewById(R.id.num_of_portions))
                                   .getText().toString());
                generateBlocks();

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }

    private void generateBlocks()
    {
        for (int i = 0; i < numberOfPortions; i++)
        {
            final Button myButton = new Button(context);
            row.addView(myButton);
            myButton.getLayoutParams().height = 100;
            myButton.getLayoutParams().width = 100;
            ViewGroup.MarginLayoutParams margins = (ViewGroup.MarginLayoutParams) myButton.getLayoutParams();
            margins.leftMargin = 10;
            margins.rightMargin = 10;
            myButton.setBackgroundColor(colors[counter]);
            myButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    myButton.setText(caloriesPerPortion.getText().toString());
                    return false;
                }
            });
        }
    }

}
