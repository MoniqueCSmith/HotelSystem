package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static String generateRoomNo(){
        String letters = "ABC";
        String letter = String.valueOf(letters.charAt((int)(Math.random() * letters.length())));
        String digit = String.valueOf((int)(Math.random() * 9) + 1);
        return digit + letter;
    }

    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String str){
        if(str == null || str.isEmpty()){
            return true;
        }
        return false;
    }
}