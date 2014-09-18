package com.backfield.imagegenerator.java.sep2014;

import java.security.SecureRandom;
import java.util.Random;

public class Color {

    int baseColor = 0x313A75;

    int[] baseColorPalette = {0x182157, 0x080F3A, 0x525B92, 0x7C93AF};

    int compliment = 0xAA8A39;

    int[] complimentPalette = {0xFFE7AA, 0xD4B66A, 0x806115, 0x553D00};

    public int nextColor(Random random) {
        float rand = random.nextFloat();
        int base;
        int[] palette;
        if(rand < 0.1) {
            base = compliment;
            palette = complimentPalette;
        } else {
            base = baseColor;
            palette = baseColorPalette;
        }
        if(rand < 0.6) {
            return base;
        } else {
            return palette[(int)(rand * 4)];
        }
    }
}
