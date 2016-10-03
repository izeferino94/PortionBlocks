package edu.izeferinucsd.portionblocks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Isaiah on 9/18/2016.
 */



public class PortionBlockDialog extends DialogFragment implements UserInputSubject{

    private LayoutInflater inflater;
    private View portionDialog;
    private UserInputObserver observer;


    private String portionName;
    private int caloriesPerPortion, portionCount;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        portionDialog = inflater.inflate(R.layout.dialog_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(portionDialog).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                portionName = ((EditText)portionDialog.findViewById(R.id.portion_name)).getText().toString();
                caloriesPerPortion = Integer.parseInt(((EditText) portionDialog.findViewById(R.id.cal_per_portion))
                                    .getText().toString());
                portionCount = Integer.parseInt(((EditText) portionDialog.findViewById(R.id.num_of_portions))
                                   .getText().toString());
                notifyObserver();

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PortionBlocksActivity pba = new PortionBlocksActivity();
                //LinearLayout portionView = pba.getPortionView();
                //portionView.removeView(row);
                //portionView.removeView(tv);
            }
        });
        return builder.create();
    }

    public void registerObserver(UserInputObserver observer)
    {
        this.observer = observer;
    }

    public void removeObserver() {}

    public void notifyObserver()
    {
        observer.update();
    }

    public String getPortionName()
    {
        return portionName;
    }

    public int getCaloriesPerPortion() { return caloriesPerPortion; }

    public int getPortionCount() { return portionCount; }
}
