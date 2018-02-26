import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by Chameera on 18/02/20.
 */
public class Main {


    private static String ecryptedRead = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encrypter encrypter = new Encrypter();
        Decrypter decrypter = new Decrypter();

        String readInput = "";

        String encrypted;
        String decrypted;

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;


        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Chameera\\Desktop\\channel.txt"));

            while (bufferedReader.ready()){

                readInput += bufferedReader.readLine();
            }

            bufferedReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        encrypted = encrypter.encrypt(readInput);

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Chameera\\Desktop\\encryptout.txt"));

            bufferedWriter.write(encrypted);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




        //System.out.println(readInput);

/*

        Encrypter encrypter = new Encrypter();
        String encrypted = encrypter.encrypt(readInput);

        System.out.println("\nEncrpted text is: "+encrypted+"\nKey is: "+encrypter.getKey());

        System.out.println("\nEnter encrypted text: ");
        String encryptedInput = scanner.nextLine();

        System.out.println("\nEnter the key :");
        String keyString = scanner.nextLine();

        int key = Integer.parseInt(keyString);

        Decrypter decrypter = new Decrypter();
        String decrpted = decrypter.decrypt(encryptedInput, key);

        System.out.println("Decrypted Text is: "+decrpted);

        */


        System.out.println("Enter the key: ");
        String keyString = scanner.nextLine();
        int key = Integer.parseInt(keyString);

        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Chameera\\Desktop\\encryptout.txt"));

            while (bufferedReader.ready()){
                ecryptedRead += bufferedReader.readLine();
            }

            bufferedReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        decrypted = decrypter.decrypt(ecryptedRead, key);


        try {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Chameera\\Desktop\\out.txt"));
            bufferedWriter.write(decrypted);



            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }





}
