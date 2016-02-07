package com.example.ryansevilla.addressbookappsample;

/**
 * Created by ryansevilla on 2/4/16.
 */
public class Contact {
    private String name;
    private String company;
    private String home_number;
    private String mobile_number;
    private String work_number;
    private String birthdate;
    private int employeeId;
    private int iconID;


    public Contact(String name, String company,
                   String birthdate, int employeeId, int iconID,
                   String home_number, String mobile_number,
                   String work_number ) {
        super();
        this.name = name;
        this.company = company;
        this.birthdate = birthdate;
        this.employeeId = employeeId;
        this.home_number = home_number;
        this.mobile_number = mobile_number;
        this.work_number = work_number;
        this.iconID = iconID;
    }

    public String getName(){
        return name;
    }

    public String getCompany(){
        return company;
    }

    public String getHome_number(){
        return home_number;
    }

    public String getMobile_number(){
        return mobile_number;
    }

    public String getWork_number(){
        return work_number;
    }

    public String getBirthdate(){
        return birthdate;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public int getIconID(){
        return iconID;
    }
}
