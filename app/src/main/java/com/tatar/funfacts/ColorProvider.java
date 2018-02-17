package com.tatar.funfacts;

import java.util.Random;

/**
 * Created by musta on 10/30/2017.
 */

public class ColorProvider {

    public String[] colors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    Random randomGenerator = new Random();

    public String getRandomColor() {
        int randomNumber = randomGenerator.nextInt(colors.length);

        return colors[randomNumber];
    }
}
