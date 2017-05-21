package com.rohabini.cowsandbulls;

/**
 * Created by rohabini on 21/05/17.
 */

public class GuessTally {
    public Integer guess;
    public Integer cows;
    public Integer bulls;

    public GuessTally(Integer guess, Integer cows, Integer bulls) {
        this.cows = cows;
        this.bulls = bulls;
        this.guess = guess;
    }
}
