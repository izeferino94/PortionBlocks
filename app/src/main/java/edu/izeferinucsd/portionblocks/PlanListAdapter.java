package edu.izeferinucsd.portionblocks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Isaias on 8/29/2016.
 */
public class PlanListAdapter extends RecyclerView.Adapter<PlanListAdapter.PlanListHolder> {

    ArrayList<String> planNames;

    public PlanListAdapter(ArrayList<String> planNames) {
        this.planNames = planNames;
    }

    @Override
    public PlanListHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_layout, parent, false);
        PlanListHolder planListHolder = new PlanListHolder(view);
        return planListHolder;
    }

    @Override
    public void onBindViewHolder(PlanListHolder holder, int position) {
        holder.textName.setText(planNames.get(position));
    }

    @Override
    public int getItemCount()
    {
        return planNames.size();
    }

    public  static class PlanListHolder extends RecyclerView.ViewHolder
    {
        TextView textName;
        public PlanListHolder(View view)
        {
            super(view);
            textName = (TextView) view.findViewById(R.id.plan_name);
        }
    }

}
