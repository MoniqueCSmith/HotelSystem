/* HotelLocationFactory.java
Factory for Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.factory;

import za.ac.cput.domain.HotelLocation;
import za.ac.cput.util.Helper;
import static za.ac.cput.util.Helper.generateHotelID;


public class HotelLocationFactory {

    public static HotelLocation createHotelLocation(String Address, String City,
                                                        String Province, int ZipCode, String phoneNo){

        String ID = generateHotelID();

        if(Helper.isNullOrEmpty(ID)||Helper.isNullOrEmpty(Address)||Helper.isNullOrEmpty(City) ||
                Helper.isNullOrEmpty(Province) || Helper.isNullOrEmpty(phoneNo)){
            return null;
        }
        if(Helper.isValidInt(ZipCode)){
            return null;
        }

        return new HotelLocation.Builder()

                .setID(ID)
                .setAddress(Address)
                .setCity(City)
                .setProvince(Province)
                .setZipCode(ZipCode)
                .setPhoneNo(phoneNo)
                .build();
            }
        }
