import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Chameera on 18/02/20.
 */
public class CypherText {
    private String plainText;
    private char[] charArray;
    private int[] ASCIIarray;
    private int key;


    public CypherText(String plainText) {
        this.plainText = plainText;
        charArray = plainText.toCharArray();
        ASCIIarray = charToASCIIarray(charArray);
        this.key = generateKey();

    }

    //charcaters to ASCII integer Array with lenght of 6 multiple
    private int[] charToASCIIarray(char[] chars) {
        int balance = 6 - chars.length%6;
        int[] ASCII = new int[chars.length + balance];
        for (int i = 0; i < chars.length; i++) {
            ASCII[i] = (int) chars[i];
        }

        for (int j = 0; j < balance; j++) {
            ASCII[chars.length+j] = 32;

        }
       // System.out.println("Asci list "+Arrays.toString(ASCII));
        return ASCII;
    }

    //gnerete a key for the text
    private int generateKey() {
        ArrayList<Integer> keyArray = new ArrayList<>();
        Random random = new Random();
        int firstNumber = random.nextInt(7) + 2;

        //keyArray.add(firstNumber);
        int i = firstNumber + 6;

        while (keyArray.size() < 6) {
            keyArray.add(i % 6 + 1);
            i = i - 1;
        }

        keyArray.add(firstNumber);

        String listString = "";

        for (int s : keyArray) {
            listString += s;
        }
        System.out.println("The key is" +listString);
        return Integer.parseInt(listString);
    }


    public int getKey() {
        return key;
    }

    public int[] getASCIIarray() {
        return ASCIIarray;
    }


}
