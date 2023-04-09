package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
    private static int nextId = 1;
    public static String generateRoomNo(){
        String letters = "ABC";
        String letter = String.valueOf(letters.charAt((int)(Math.random() * letters.length())));
        String digit = String.valueOf((int)(Math.random() * 9) + 1);
        return digit + letter;
    }
        public static String generateID() {
            String id = String.format("%06d", nextId);
            if (nextId == 999999) {
                nextId = 1;
            } else {
                nextId++;
            }
            return id;
        }

    public static boolean isNullOrEmpty(String str){
        if(str == null || str.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }
}