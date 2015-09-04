/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medadministration;

/**
 *
 * @author Dayron Hernandez
 */
public class Doctor extends Person implements CanBill {
    
    private int doctorID;
    private String medSchool;

    public Doctor(int doctorID, String medSchool, String firstName, String lastName) {
        super(firstName, lastName);
        this.doctorID = doctorID;
        this.medSchool = medSchool;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getMedSchool() {
        return medSchool;
    }

    public void setMedSchool(String medSchool) {
        this.medSchool = medSchool;
    }

    public double getBillAmount()
    {
    return Clinic.BASE_VISIT_FEE;
    }
  
    @Override
    public String toString() {
        String str;
        str = super.toString()
                + "Doctor ID:\t\t" + getDoctorID() + "\n"
                + "Graduated from:\t\t" + getMedSchool() + "\n"
                + "Visit Rate:\t\t" + getBillAmount() + "\n";
        return str;
    }
    
    
}
