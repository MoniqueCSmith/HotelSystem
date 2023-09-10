package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class Helper {

    /*private static final int idSize = 10;
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
    }*/

    private static int nextId = 1;

    public static String generateID() {
        String id = String.format("%06d", nextId);
        if (nextId == 999999) {
            nextId = 1;
        } else {
            nextId++;
        }
        return id;
    }


    public static String generateRoomNo() {
        int building = 1;
        int floor = 0;
        int room = 1;
        String roomNo = String.format("%d%02d", building, room);

        room++;
        if (room > 5) {
            room = 1;
            floor++;
            if (floor > 3) {
                floor = 1;
                building++;
            }
        }

        return roomNo;
    }


    public static String generateAmenityID() {
        int nextId = 1;
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

    public static boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }

    public static boolean isValidCellNo(String cellNo) {
        // Check if the cellNo is exactly 10 characters long
        if (cellNo.length() != 10) {
            return false;
        }
        if (cellNo.charAt(0) != '0') {
            return false;
        }
        for (int i = 1; i < cellNo.length(); i++) {
            if (!Character.isDigit(cellNo.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static String reservationID(){
        return UUID.randomUUID().toString();
    }

}

