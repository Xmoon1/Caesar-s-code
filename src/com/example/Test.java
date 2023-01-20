package com.example;

public class Test{

    public static void main(String[] args) {
        String word = "%Ixfnlqj#vkhhw$%";// decrypted text
        String[] k = word.split(" ",0); //splitting text based by the spaces
        for(int p=1;p<=26;p++)                                  // for loop p loops for 26 as there are 26 characters in alphabets.
        {           System.out.println("Key :"+p);              // Key will be printed
            for(int i=0;i<k.length;i++)                             // for loop i loops for length of the splitted string available i.e after eliminating spaces
            {
                for(int j=0;j<k[i].length();j++)                //  for loop j loops for length of the string eg: FSI so its 3.
                {   char singlechar = k[i].charAt(j);           // converting single string to char
                    int chartoascii = singlechar+p;                 // converting char to int where it convert to ascii value of the char
                    if(chartoascii > 90)                             // if char after adding key goes around letter "Z" . it will start with A
                    {
                        chartoascii =64+(p-(90-singlechar));        // Calculations: 64 is one char before A. p is the key and 90 is "Z" and single char is the letter from decrypted text
                    }
                    char newchar = (char)chartoascii;
                    System.out.print(newchar);
                }
                System.out.print("  ");
            }
            System.out.println();
            System.out.println();
        }
    }
}