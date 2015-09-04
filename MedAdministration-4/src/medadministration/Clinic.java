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
public class Clinic {
    
    private String name;
    private ArrayList<Doctor>  listOfDoctors = new ArrayList<Doctor>();
    private ArrayList <Patient> listOfPatients = new ArrayList<Patient>();
    
    private static int nextAvailablePatientID =0;
    private static int nextAvailableDoctorID=0;
    
    public static final double BASE_VISIT_FEE=100;

    public Clinic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList <Doctor> getDoctors() {
        return listOfDoctors;
    }

    public void addDoctors(Doctor listOfDoctors) {
        this.listOfDoctors.add (listOfDoctors);
    }

    public ArrayList <Patient> getPatients() {
        return listOfPatients;
    }

    public void addPatients(Patient listOfPatients) {
        this.listOfPatients.add (listOfPatients);
    }



    public static int getNextPatientID()
    {
        
            return nextAvailablePatientID+=1;
    }
   public static int getNextDoctorID()
   {
        
            return nextAvailableDoctorID+=1;
    }

    @Override
    public String toString() 
    {
        String str = "************************************\n";
        str +=       "*          List Of patients        *\n";
        str+=        "************************************\n\n";
        for (Patient patient : listOfPatients) {
            if (patient instanceof UnderagePatient) {
                str += ((UnderagePatient) patient).toString() + "\n";
            } else {
                str += patient.toString() + "\n";
            }

        }
        str+=  "************************************\n";
        str += "*          List Of Doctors         *\n";
        str+=  "************************************\n\n";
        for (Doctor doctor : listOfDoctors) {
            if (doctor instanceof Specialist) {
                str += ((Specialist) doctor).toString() + "\n";
            } else {
                str += doctor.toString() + "\n";
            }
        }
        return str;
    }
   
}

