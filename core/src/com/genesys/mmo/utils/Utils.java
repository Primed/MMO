package com.genesys.mmo.utils;

/**
 * Created by brendan on 1/7/17.
 */
public class Utils {

    /**
     * Clamps a number is between two specified intervals.
     * @param number The number to be clamped.
     * @param lower The lower bound.
     * @param upper The upper bound.
     * @return The clamped number.
     */
    public static int clamp(int number, int lower, int upper) {
        if (number < lower) return lower;
        if (number > upper) return upper;
        return number;
    }
}
