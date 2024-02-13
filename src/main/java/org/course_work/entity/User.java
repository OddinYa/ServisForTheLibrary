package org.course_work.entity;


import org.course_work.exception.AccessRightsException;

import java.util.Calendar;
import java.util.Date;

public class User {
   private final String numberOfTheTicket;
   private char accessRights;
   private int numbOfRegistration = 0;
   private String fullName;

   private int yearOfBirth;

   private String address;

   private String placeOfWorkOrStudy;

    public User(char accessRights, String fullName,
                int yearOfBirth, String address, String placeOfWorkOrStudy) throws AccessRightsException {

       if(checkAccessRights(accessRights)) {

           this.accessRights = accessRights;
           this.fullName = fullName;
           this.yearOfBirth = yearOfBirth;
           this.address = address;
           this.placeOfWorkOrStudy = placeOfWorkOrStudy;
           this.numberOfTheTicket = createNumber(accessRights);

       }
       else
           throw new AccessRightsException("Ошибка права доступа!");
    }

    private boolean checkAccessRights(Character c){
        return switch (c) {
            case 'А', 'Ч', 'В' -> true;
            default -> false;
        };
    }

    private String createNumber(int accessRights){

        StringBuilder stringBuilder = new StringBuilder(accessRights);
        stringBuilder.append(accessRights);

        numbOfRegistration++;
        String string = String.format("%04d",numbOfRegistration);

        stringBuilder.append(string);

        stringBuilder.append("-");

        stringBuilder.append(toGetYear());

        return stringBuilder.toString();
    }

    private int toGetYear(){

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        calendar.setTime(date);

        return calendar.get(Calendar.YEAR) % 100;
    }


    public String getNumberOfTheTicket() {
        return numberOfTheTicket;
    }



    public char getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(char accessRights) {
       this.accessRights = accessRights;
    }

    public Integer getNumbOfRegistration() {
        return numbOfRegistration;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlaceOfWorkOrStudy() {
        return placeOfWorkOrStudy;
    }

    public void setPlaceOfWorkOrStudy(String placeOfWorkOrStudy) {
        this.placeOfWorkOrStudy = placeOfWorkOrStudy;
    }



}