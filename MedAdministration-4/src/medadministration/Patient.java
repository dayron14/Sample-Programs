/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medadministration;

import java.util.Calendar;

/**
 *
 * @author Dayron Hernandez
 */
public class Patient extends Person{
    
    private int patientID;
    private String dateOfBirth;

    public Patient(int patientID, String dateOfBirth, String firstName, String lastName) {
        super(firstName, lastName);
        this.patientID = patientID;
        this.dateOfBirth = dateOfBirth;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
       public static boolean isValidDate(String date)
    {
        return date != null && date.matches("[\\d]{2}/[\\d]{2}/[\\d]{4}");
    }
    
    public static int getCurrentYear()
    {
        Calendar now = Calendar.getInstance();   // This gets the current date and time.
        return now.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        String str = "";
        str = super.toString()
                + "Patient ID:\t\t" + getPatientID() + "\n"
                + "Date Of Birth: \t\t" + getDateOfBirth() + "\n";
        return str;
    }

    
}
