import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by Chameera on 18/02/20.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encrypter encrypter = new Encrypter();

        String readInput = "";

        String encrypted;

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;


        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Chameera\\Desktop\\channel.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Chameera\\Desktop\\out.txt"));

            while (bufferedReader.ready()){

                readInput = bufferedReader.readLine();

                encrypted = encrypter.encrypt(readInput);


                bufferedWriter.write(encrypted);
                bufferedWriter.newLine();






            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
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


    }





}
