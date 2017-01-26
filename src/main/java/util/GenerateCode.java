package util;

import java.util.Random;

/**
 * Created by Flyme on 2017/1/23.
 */
public class GenerateCode {
    private static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static  String randomCode(int len){
        if(len <= 0)
            return "";
        int totallen = letters.length();
        StringBuilder builder = new StringBuilder();

        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < len; i++){
            builder.append(letters.charAt(random.nextInt(totallen-1)));
        }

        return builder.toString();
    }
}
