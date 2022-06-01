package com.javarush.cryptoanalyser.alphabet;

public class LatinAlphabet {
    private static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e',
            'f', 'g','h','i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','.', ',',
            '"', '\'', ':', '!', '?', ' ', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private LatinAlphabet() {}

    public static char[] getALPHABET() {
        return ALPHABET;
    }
}
