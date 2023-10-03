package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static za.ac.cput.domain.Amenity.nextAmenityId;

import static za.ac.cput.domain.Guest.nextGuestId;
import static za.ac.cput.domain.MealPlan.nextMealPlanId;
import static za.ac.cput.domain.Member.nextMemberId;
import static za.ac.cput.domain.Query.nextQueryId;
import static za.ac.cput.domain.Reservation.nextReservationId;
import static za.ac.cput.domain.Review.nextReviewId;
import static za.ac.cput.domain.Room.currentRoomNumber;
import static za.ac.cput.domain.HotelLocation.nextHotelId;
import static za.ac.cput.domain.Employee.nextEmployeeID;
import static za.ac.cput.domain.User.nextUserId;


public class Helper {

    public static String generateQueryID() {
        String id = String.format("%06d", nextQueryId);
        if (nextQueryId == 999999) {
            nextQueryId = 1;
        } else {
            nextQueryId++;
        }
        return id;
    }

    public static String generateReservationID() {
        String id = String.format("%06d", nextReservationId);
        if (nextReservationId == 999999) {
            nextReservationId = 1;
        } else {
            nextReservationId++;
        }
        return id;
    }
    public static String generateUserID() {
        String id = String.format("%06d", nextUserId);
        if (nextUserId == 999999) {
            nextUserId = 1;
        } else {
            nextUserId++;
        }
        return id;
    }

    public static String generateReviewID() {
        String id = String.format("%06d", nextReviewId);
        if (nextReviewId == 999999) {
            nextReviewId = 1;
        } else {
            nextReviewId++;
        }
        return id;
    }



    public static String generateMemberID() {
        String id = String.format("%06d", nextMemberId);
        if (nextMemberId == 999999) {
            nextMemberId = 1;
        } else {
            nextMemberId++;
        }
        return id;
    }
    public static String generateGuestID() {
        String id = String.format("%06d", nextGuestId);
        if (nextGuestId == 999999) {
            nextGuestId = 1;
        } else {
            nextGuestId++;
        }
        return id;
    }
    public static String generateMealPlanID() {
        String id = String.format("%06d", nextMealPlanId);
        if (nextMealPlanId == 999999) {
            nextMealPlanId = 1;
        } else {
            nextMealPlanId++;
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
        String id = String.format("%06d", nextAmenityId);
        if (nextAmenityId == 999999) {
            nextAmenityId = 1;
        } else {
            nextAmenityId++;
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
    public static boolean isCheckInTimeValid(LocalTime estCheckInTime) {
        LocalTime startTime = LocalTime.of(0, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        return estCheckInTime.isBefore(startTime) || estCheckInTime.isAfter(endTime);
    }


}

