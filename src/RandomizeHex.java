import java.util.Random;

/**
 * Created by Korybut on 15.07.2017.
 */
public class RandomizeHex {

    String randVal = "";

    public RandomizeHex(){
        Random random = new Random();
        randVal = Integer.toHexString(random.nextInt(65535));
        while(randVal.length()<4){
            randVal = "0" + randVal;
        }
    }

    public RandomizeHex(int val){
        Random random = new Random();
        if(val == 0){
            randVal = Integer.toHexString(random.nextInt(32767));
            while(randVal.length()<4){
                randVal = "0" + randVal;
            }
        }
        else if(val == 1) {
            randVal = Integer.toHexString(random.nextInt(32767)+ 32768);
            while (randVal.length() < 4) {
                randVal = "0" + randVal;
            }
        }
    }

    public String getRandomHex(){
        return randVal.toUpperCase();
    }

}
