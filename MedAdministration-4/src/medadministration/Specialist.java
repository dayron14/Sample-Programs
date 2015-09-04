/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medadministration;

import java.util.ArrayList;

/**
 *
 * @author Dayron Hernandez
 */
public class Specialist extends Doctor implements CanBill{
    
    private String specialty;
    private ArrayList<String> trainingPrograms = new ArrayList<String> ();

    public Specialist(String specialty, int doctorID, String medSchool, String firstName, String lastName) {
        super(doctorID, medSchool, firstName, lastName);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ArrayList<String> getTrainingPrograms() {
        return trainingPrograms;
    }

    public void setTrainingPrograms(ArrayList<String> trainingPrograms) {
        this.trainingPrograms = trainingPrograms;
    }
    
    public double getBillAmount()
    {
    return super.getBillAmount() +(25*trainingPrograms.size());
    }

    @Override
    public String toString() {  
        
        String specialtyString;
        specialtyString = super.toString()
                + "Specialty:\t\t" + getSpecialty() + "\n"
                + "Specialty Training Programs:";
        for (String str : getTrainingPrograms()) {
            specialtyString += str + "\n\t\t\t"
             + "Visit Rate:\t\t" + getBillAmount() + "\n";
            
        }

        return specialtyString;
    }
    
}
