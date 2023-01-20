package com.example;
import java.io.IOException;
import java.util.Scanner;

import static com.example.CaesarMethods.*;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) throws IOException {
        String string, encryptedString;
        int key;
        String estring, decryptedString;
        int dkey;
        Scanner input = new Scanner(System.in);

        System.out.println("Выбери 1 или 2\n 1 - Зашифрования файла\n 2 - Расшифрования файла\n 3 - Криптоанализ методом brute force");
        int chose = input.nextInt();

       if (chose == 1) {

           //Encryption Implementation
           System.out.println("Файл (путь к файлу): ");
           String filePath = input.next(); // /Users/john/Desktop/Encryption/src/com/example/doc.txt

           String content = null;
           try {
               content = readFile(filePath);
               System.out.print("Введите криптографический ключ: ");
               key = input.nextInt();

               encryptedString = CaesarMethods.encrypt(content, key);

               System.out.println("Зашифрованная строка: " + encryptedString);
               System.out.println("Введите путь для сохранение файла: ");
               String path = input.next();
               newFile(encryptedString, path);

           } catch (IOException e) {
               e.printStackTrace();
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }else if (chose == 2){ //Decryption Implementation

           System.out.println("Файл (путь к файлу) которую нужно расшифровать"); // /Users/john/Desktop/Encryption/src/com/example/result.txt
           String pathToReadFile = input.next();

           System.out.print("Введите криптографический ключ: ");
           dkey = input.nextInt();

               decryptedString = CaesarMethods.decrypt(readFile(pathToReadFile), dkey);

               System.out.println("Расшифрованная строка: " + decryptedString);

       }else if (chose == 3){
           System.out.println("Файл (путь к файлу) которую нужно расшифровать"); // /Users/john/Desktop/Encryption/src/com/example/result.txt
           String pathToReadFile = input.next();

           System.out.print("Введите кодовое слово: ");
           String secret_word = input.next();

           if (secret_word.equals("brute-force")){
               hackWithBruteForce(readFile(pathToReadFile));
           }else {
               System.out.println("Ошибка!");
           }

       }
       else {
           System.out.println("Ошибка!");
       }
    }
}