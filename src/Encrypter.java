import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * Created by Chameera on 18/02/24.
 */
public class Encrypter {

    private CypherText cypherText;
    private int[] inuptASCIIarray, processingASCIIarray;



    private int key;

    private int permutation;
    private int substituiton;
    private int encrptionCycles;

    private int[] permutationArray;

    private String output;
    private String encryptedText;


    //encryption method visible to Main class
    public String encrypt(String text) {
        this.cypherText = new CypherText(text);
        this.key = cypherText.getKey();
        decodeKey();
        this.processingASCIIarray = cypherText.getASCIIarray();
        this.encryptedText = encryptFunction();

        return encryptedText;

    }


    //actual encrytion function. Not visible to outside
    private String encryptFunction() {
        //substitution

        for (int i = 0; i < processingASCIIarray.length; i++) {
            processingASCIIarray[i] = processingASCIIarray[i] + substituiton;
        }

        //permutation
        int[] tempArray = new int[6];

        for (int i = 0; i < processingASCIIarray.length - 5; i += 6) {

            for (int j = 0; j < 6; j++) {
                tempArray[j] = processingASCIIarray[i + j];
            }
           // System.out.println("Temp Array "+i+" " + Arrays.toString(tempArray));

            for (int j = 0; j < 6; j++) {
                processingASCIIarray[i + j] = tempArray[permutationArray[j]-1];

            }
            //System.out.println("Processing Array "+i+" "+ Arrays.toString(processingASCIIarray));

            //System.out.println("");
        }

        //Take permutated ASCII list to a String

        output = "";
        for (int i = 0; i <processingASCIIarray.length; i++) {
            output += Character.toString((char) processingASCIIarray[i]);
        }

        //System.out.println("Out "+output);



        return output;

    }

    //decode the details in the key

    private void decodeKey() {
        if (cypherText != null) {
            this.encrptionCycles = cypherText.getKey() % 10;
            this.permutation = cypherText.getKey() / 10;


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
            //System.out.println("Permu list"+ Arrays.toString(permutationArray));

        } else
            System.out.println("Cypher text object not created");
    }

    //getter for key
    public int getKey() {
        return key;
    }


}
