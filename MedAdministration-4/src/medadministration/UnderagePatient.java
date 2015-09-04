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
public class UnderagePatient extends Patient {
    
    private String legalGuardian;

    public UnderagePatient(String legalGuardian, int patientID, String dateOfBirth, String firstName, String lastName) {
        super(patientID, dateOfBirth, firstName, lastName);
        this.legalGuardian = legalGuardian;
    }

    public String getLegalGuardian() {
        return legalGuardian;
    }

    public void setLegalGuardian(String legalGuardian) {
        this.legalGuardian = legalGuardian;
    }

    @Override
    public String toString() {  
        String str = "";
        str = super.toString()
                + "\n" + "Legal Guardian:" + "\t\t" + getLegalGuardian();
        return str;
    }
    
    
}
