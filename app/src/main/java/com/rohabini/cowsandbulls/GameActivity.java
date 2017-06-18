package com.rohabini.cowsandbulls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ArrayList<Integer> digits;
    ArrayList<GuessTally> guesses = new ArrayList<>();

    private void generateNumberGuess() {
        Random r = new Random();
        int n = r.nextInt(10);
        digits.add(n);

        for(int i=0; i<3; i++) {
            do n = r.nextInt(10); while(!digits.contains(n));
            digits.add(n);
        }
    }

    private ArrayList<Integer> numberToDigits(int num) {
        ArrayList<Integer> res = new ArrayList<>();
        while(num > 0) {
            res.add(num % 10);
            num /= 10;
        }
        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generateNumberGuess();
        setContentView(R.layout.activity_game);

        final ListView listView = (ListView) findViewById(R.id.listView);
        final GuessAdapter adapter = new GuessAdapter(this, R.layout.guess_list_item, guesses);
        listView.setAdapter(adapter);

    }

    public void calculateCowsAndBulls(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        String guessNumber = editText.getText().toString();
        Integer number = Integer.parseInt(guessNumber);
        int bulls = 0;
        int cows = 0;
        ArrayList<Integer> guessDigits = numberToDigits(number);
        for(Integer i : guessDigits) {
                if(digits.contains(i)) {
                    int locationInDigits = digits.indexOf(i);
                    int locationInGuess = guessDigits.indexOf(i);
                    if (locationInDigits == locationInGuess)
                        bulls++;
                    else
                        cows++;
                }
        }

        GuessTally tally = new GuessTally(number, cows, bulls);
        guesses.add(tally);
        GuessAdapter adapter = (GuessAdapter)((ListView)findViewById(R.id.listView)).getAdapter();
        adapter.notifyDataSetChanged();
    }
}
