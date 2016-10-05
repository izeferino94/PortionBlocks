package edu.izeferinucsd.portionblocks;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by zefer on 10/4/2016.
 */

public class PortionPlanNameDialog extends DialogFragment implements UserInputSubject {
    private LayoutInflater inflater;
    private View portionPlanName;
    private String planName;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        portionPlanName = inflater.inflate(R.layout.plan_name_dialog_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(portionPlanName).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                planName = ((EditText)portionPlanName.findViewById(R.id.portion_plan_name)).getText().toString();
                MainActivity.testText1[0] = planName;
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        return builder.create();
    }

    public void registerObserver(UserInputObserver observer) {}
    public void removeObserver() {}
    public void notifyObserver(int returnCode) {}
}
