package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
import org.apache.commons.validator.routines.EmailValidator;

import static za.ac.cput.domain.Amenity.nextId;
import static za.ac.cput.domain.Room.currentRoomNumber;
import static za.ac.cput.domain.HotelLocation.nextHotelId;
import static za.ac.cput.domain.Employee.nextEmployeeID;


public class Helper {


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

    public static String generateHotelID() {
        String id = String.format("%06d", nextHotelId);
        if (nextHotelId == 999999) {
            nextHotelId = 1;
        } else {
            nextHotelId++;
        }
        return id;
    }

    public static String generateEmployeeID() {
        String id = String.format("%06d", nextEmployeeID);
        if (nextEmployeeID == 999999) {
            nextEmployeeID = 1;
        } else {
            nextEmployeeID++;
        }
        return id;
    }

    public static String generateRoomNo() {
        String roomNumber = Integer.toString(currentRoomNumber);
        currentRoomNumber++;
        return roomNumber;
    }


    public static String generateAmenityID() {
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

    public static boolean isDateRangeValid(LocalDate checkInDate, LocalDate checkOutDate) {
        return !checkOutDate.isBefore(checkInDate);
    }
    public static boolean isCheckInTimeValid(LocalDateTime estCheckInTime) {
        LocalTime checkInTime = estCheckInTime.toLocalTime();
        LocalTime startTime = LocalTime.of(0, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        return checkInTime.isBefore(startTime) || checkInTime.isAfter(endTime);
    }

}

