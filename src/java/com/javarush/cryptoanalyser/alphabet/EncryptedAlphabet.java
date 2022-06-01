package com.javarush.cryptoanalyser.alphabet;

public class EncryptedAlphabet {
    private final char[] ALPHABET = LatinAlphabet.getALPHABET();

    public char[] getEncryptedAlphabet(int key) {
        char[] encryptedAlphabet = new char[ALPHABET.length];
        for (int i = 0; i < ALPHABET.length; i++) {
            int offset = (i + key) % ALPHABET.length;
            encryptedAlphabet[i] = ALPHABET[offset];
        }
        return encryptedAlphabet;
    }

    public int getIndexOfSymbol(char symbol, char[] alphabet) {
        int index = -1;
        for (int i = 0; i < alphabet.length; i++) {
            char value = alphabet[i];
            if (symbol == value) {
                index = i;
            }
        }
        return index;
    }
}
