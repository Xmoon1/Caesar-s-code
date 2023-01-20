package com.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author John
 */

public class CaesarMethods {

    /**
     * Этот метод использует технику сдвига Цезаря для шифрования строки, передаваемой в функцию.
     * Значение символа сдвигается в зависимости от ключа, переданного в функцию.
     * Он возвращает строку, которая является результатом шифрования.
     *
     * @param string type String
     * @param key type int
     * @return type String
     */
    public static String encrypt(String string, int key) {
        String coded = "";
        for (int i = 0; i < string.length(); i++) {
            char sm = (char) (string.codePointAt(i) + key);
            coded += sm;
        }
        return coded;
    }

    /**
     * Этот метод использует метод сдвига Цезаря для расшифровки зашифрованной Цезарем строки, переданной в функцию.
     * Значение символа смещается в зависимости от ключа, переданного в функцию.
     * Возвращает строку, которая является результатом расшифровки.
     * @param coded type String
     * @param key type int
     * @return type String
     */
    public static String decrypt(String coded, int key) {
        String decoded = "";
        for (int i = 0; i < coded.length(); i++) {
            char sm = (char) (coded.codePointAt(i) - key);
            decoded += sm;
        }
        return decoded;
    }

    public static String readFile(String path) throws IOException
    {
        String content;
        try (Scanner scanner = new Scanner(new File(path))) {
            content = scanner.useDelimiter("\\A").next();
        }

        return content;
    }

    public static void newFile(String content, String filePath) throws Exception {
        File myObj = new File("result.txt");
        FileWriter fileWriter = new FileWriter(filePath + myObj.getName());
        myObj.createNewFile();
        fileWriter.write(content);
        fileWriter.close();
    }

    public static void hackWithBruteForce(String textOfFile){


        for (int key = 0; key < 15; key++) {
            String decoded = "";
            for (int i = 0; i < textOfFile.length(); i++) {
                char sm = (char) (textOfFile.codePointAt(i) - key);
                decoded += sm;
            }
            System.out.println("KEY :" + key +"\n"+ "Decode: " +decoded);
            System.out.println();
            System.out.println();
        }

    }
}

