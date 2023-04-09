package za.ac.cput.util;

import java.text.SimpleDateFormat;
import java.util.*;

import static za.ac.cput.factory.HotelLocationFactory.possibleLocations;
import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.HotelLocation;

public class Helper {

    private static final int idSize = 10;
    private static final int dateSize = 6;
    private static final String currentDate = "ddMMyy";
    private static final String charAmount = "0123456789";
    private static final Random randomNum = new Random();
    private static final Set<String> randomInvoiceID = new HashSet<>();
    public static String generateUniqueID() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(currentDate);
        String date = dateFormat.format(new Date());
        String randID = generateRandomID(idSize - dateSize);
        String invoiceID = date + randID;
        while (randomInvoiceID.contains(invoiceID)) {
            randID = generateRandomID(idSize - dateSize);
            invoiceID = date + randID;
        }
        randomInvoiceID.add(invoiceID);
        return invoiceID;
    }
    private static String generateRandomID(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = randomNum.nextInt(charAmount.length());
            builder.append(charAmount.charAt(index));
        }
        return builder.toString();
    }

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

    public static boolean isValidInt(int a) {
        return a < 0;
    }
    public static boolean isValidDouble(Double doubles) {
        if (doubles == null || doubles.isNaN()) {
            return true;
        } else if (doubles < 0) {
            return true;
        }
        return false;
    }

    public static List<String> getHotelLocations(List<String> hotels) {
        List<String> locations = new ArrayList<>();
        for (String hotel : hotels) {
            String hotelCode = hotel.substring(0, 3);
            locations.add(hotelCode);
        }
        return locations;
    }
    public static List<HotelLocation> getPossibleLocations() {
        return possibleLocations;
    }
    public static String generateHotelCode(String province) {
        String prefix = province.substring(0, 3).toUpperCase();
        int count = 0;
        for (HotelLocation location : possibleLocations) {
            if (location.getHotelProvince().equals(province)) {
                count++;
            }
        }
        return prefix + String.format("%03d", count);
    }

    public static boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }
}