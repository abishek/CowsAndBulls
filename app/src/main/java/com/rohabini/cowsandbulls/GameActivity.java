package com.rohabini.cowsandbulls;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    ArrayList<GuessTally> guesses = new ArrayList<GuessTally>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final ListView listView = (ListView) findViewById(R.id.listView);
        final GuessAdapter adapter = new GuessAdapter(this, R.layout.guess_list_item, guesses);
        listView.setAdapter(adapter);

    }

    public void calculateCowsAndBulls(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        String guessNumber = editText.getText().toString();
        Integer number = Integer.parseInt(guessNumber);

        GuessTally tally = new GuessTally(number, 0, 0);
        guesses.add(tally);
        GuessAdapter adapter = (GuessAdapter)((ListView)findViewById(R.id.listView)).getAdapter();
        adapter.notifyDataSetChanged();
    }
}
