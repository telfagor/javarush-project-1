package com.javarush.cryptoanalyser.file;

import com.javarush.cryptoanalyser.alphabet.EncryptedAlphabet;
import com.javarush.cryptoanalyser.alphabet.LatinAlphabet;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Decrypt {
    private final char[] ALPHABET = LatinAlphabet.getALPHABET();
    private final EncryptedAlphabet ENCRYPTED_ALPHABET = new EncryptedAlphabet();

    public void decode(String src, String dest, int key, char[] encryptedAlphabet) {
        try (RandomAccessFile sourceFile = new RandomAccessFile(src, "rw");
             RandomAccessFile destFile = new RandomAccessFile(dest, "rw")) {
            FileChannel inputChannel = sourceFile.getChannel();
            FileChannel outputChannel = destFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) inputChannel.size());
            StringBuilder builder = new StringBuilder(byteBuffer.capacity());
            inputChannel.read(byteBuffer);
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                char symbol = (char) byteBuffer.get();
                int index = ENCRYPTED_ALPHABET.getIndexOfSymbol(symbol, encryptedAlphabet);
                builder.append(ALPHABET[index]);
            }

            ByteBuffer byteBuffer2 = ByteBuffer.allocate(builder.toString().getBytes().length);
            byteBuffer2.put(builder.toString().getBytes());
            byteBuffer2.flip();
            outputChannel.write(byteBuffer2);

        } catch (IOException e) {
            System.err.println("Problem with file" + e.getMessage());
        }
    }
}
