import java.util.Arrays;

/**
 * Created by Chameera on 18/02/25.
 */
public class Decrypter {

    private String encryptedText;
    private int key;
    private int[] ASCIIarray;


    private int encrptionCycles;
    private int permutation;
    private int substituiton;
    private int[] permutationArray;
    private int[] processingASCIIarray;
    private String output;

    public String decrypt(String encrypted, int key) {
        this.encryptedText = encrypted;
        this.key = key;
        ASCIIarray = new int[encryptedText.length()];
        processingASCIIarray = ASCIIarray;
        decodeKey();
        String g = decryptFunction();

        return decryptFunction();
    }


    private String decryptFunction() {

        for (int i = 0; i < encryptedText.length(); i++) {
            char character = encryptedText.charAt(i);
            ASCIIarray[i] = (int) character;
        }
        //System.out.println("Asci Array Decr " + Arrays.toString(ASCIIarray));

        //remove permutation

        int[] tempArray = new int[6];

        for (int i = 0; i < processingASCIIarray.length - 5; i += 6) {

            for (int j = 0; j < 6; j++) {
                tempArray[j] = processingASCIIarray[i + j];
            }
            // System.out.println("Temp Array "+i+" " + Arrays.toString(tempArray));

            for (int j = 0; j < 6; j++) {
                processingASCIIarray[i + permutationArray[j] - 1] = tempArray[j];

            }
            //System.out.println("Processing Array dec" + i + " " + Arrays.toString(processingASCIIarray));

            //System.out.println("");


        }

        //remove substituion

        for (int i = 0; i < processingASCIIarray.length; i++) {
            processingASCIIarray[i] = processingASCIIarray[i] - substituiton;

        }

        output = "";
        for (int i = 0; i < processingASCIIarray.length; i++) {
            output += Character.toString((char) processingASCIIarray[i]);
        }

        //System.out.println("Out " + output);


        return output;

    }

    //Get values from the key

    private void decodeKey() {
        if (key > 999999) {
            this.encrptionCycles = this.key % 10;
            this.permutation = this.key / 10;


            int sum = 0;
            int num = permutation;


            while (num > 0) {
                sum += num % 10;
                num = num / 10;

                if (sum > 9 && num == 0) {
                    num = sum;
                    sum = 0;
                }
            }
            //System.out.println("Sum is " + sum);

            this.substituiton = sum;

            //System.out.println("cycles " + encrptionCycles + " per " + permutation + " sub " + substituiton);

            String tempString = Integer.toString(permutation);
            permutationArray = new int[tempString.length()];
            int tempInt = permutation;

            for (int i = 0; i < tempString.length(); i++) {
                permutationArray[tempString.length() - i - 1] = tempInt % 10;
                tempInt = tempInt / 10;
            }
            //System.out.println("Permu list dec" + Arrays.toString(permutationArray));

        } else
            System.out.println("Invalid key");
    }


}
