package com.rohabini.cowsandbulls;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by rohabini on 21/05/17.
 */

public class GuessAdapter extends ArrayAdapter<GuessTally> {

    Context ctx;
    int layoutResourceId;
    ArrayList<GuessTally> guessTally = null;

    static class GuessTallyHolder {
        TextView guessNumber;
        TextView cows;
        TextView bulls;
    }

    public GuessAdapter(Context context, int layoutResourceId, ArrayList<GuessTally> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.ctx = context;
        this.guessTally = data;
    }

    @Override
    public View getView(int position, View rowView, ViewGroup parent) {
        View row = rowView;
        GuessTallyHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity)ctx).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new GuessTallyHolder();
            holder.guessNumber = (TextView)row.findViewById(R.id.guess);
            holder.cows = (TextView) row.findViewById(R.id.cows);
            holder.bulls = (TextView) row.findViewById(R.id.bulls);

            row.setTag(holder);
        } else {
            holder = (GuessTallyHolder)row.getTag();
        }
        holder.guessNumber.setText(guessTally.get(position).guess.toString());
        holder.cows.setText(guessTally.get(position).cows.toString());
        holder.bulls.setText(guessTally.get(position).bulls.toString());

        return row;
    }

}

