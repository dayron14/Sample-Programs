package medadministration;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Dayron Hernandez
 */
public class MedAdministration 
{
    // create a class constant to store the clinic's name

    static final String CLINIC_NAME = "Healthy Minds and Bodies Clinic";
    // declare a Clinic object
    static Clinic myClinic;

    public static void main(String[] args) 
    {
        // Initialize the Clinic object
        myClinic = new Clinic(CLINIC_NAME);

        // prompt the user for input
        String options = "\t [1] to create a new patient\n"
                + "\t [2] to add a new doctor to the system\n"
                + "\t [3] to display clinic information\n"
                + "\t [q] to quit the application";
    
        String message = "Please enter one of the following options:\n" + options;

        String title = "Welcome to " + CLINIC_NAME;

        String userInput = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

        while (userInput != null && !userInput.equalsIgnoreCase("q")) 
        {
            switch (userInput) 
            {
                case "1":
                    addNewPatient();
                    break;
                case "2":
                    addNewDoctor();
                    break;
                case "3":
                    displayClinicInformation(myClinic);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid entry. Please try again.", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

            userInput = JOptionPane.showInputDialog(message);
        }


        JOptionPane.showMessageDialog(null, "Quitting application.");
        System.exit(0);

    }

    
    public static void addNewPatient() 
    {
        Patient newPatient;

        String first = JOptionPane.showInputDialog(null, "Please enter patient's first name:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        String last = JOptionPane.showInputDialog(null, "Please enter patient's last name:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        String dob = JOptionPane.showInputDialog(null, "Please enter patient's date of birth [MM/DD/YYYY]:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);

        // check that the user entered all values
        if (first != null && !first.isEmpty() && last != null && !last.isEmpty() && !dob.isEmpty() && dob != null) 
        {
            // get the next patient ID available
            int patientID = Clinic.getNextPatientID();
            
            // check if the date of birth provided is valid
            boolean validDOB = Patient.isValidDate(dob);

            if (validDOB) 
            {
                // get the birth year
                String[] dateParts = dob.split("/");
                int birthYear = Integer.parseInt(dateParts[2]);

                // check if the patient is under 18
                if ((Patient.getCurrentYear() - birthYear) < 18) 
                {
                    String guardian = JOptionPane.showInputDialog(null, "Please enter the name of the patient's legal guardian", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
                    /**********************************************************************/
                    /* INITIALIZE THE newPatient VARIABLE TO A NEW UnderagePatient OBJECT */
                    /**********************************************************************/
                    newPatient = new UnderagePatient(guardian,patientID,dob,first,last);
                    
                } 
                else 
                {
                    /**********************************************************************/
                    /*     INITIALIZE THE newPatient VARIABLE TO A NEW Patient OBJECT     */
                    /**********************************************************************/
                    
                    newPatient = new Patient(patientID,dob,first,last);
                }

                /********************************************************************************/
                /*  ADD THE newPatient VARIABLE TO THE LIST OF PATIENTS IN THE myClinic OBJECT  */
                /********************************************************************************/
                
                myClinic.addPatients(newPatient);
                JOptionPane.showMessageDialog(null, "New patient information has been added to the system.", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);

            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "New patient could not be added to the system. Invalid date of birth.", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "New patient could not be added to the system. Not enough information provided.", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    public static void addNewDoctor() 
    {
        Doctor newDoctor;
        
        String first = JOptionPane.showInputDialog(null, "Please enter doctor's first name:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        String last = JOptionPane.showInputDialog(null, "Please enter doctor's last name:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        String medSchool = JOptionPane.showInputDialog(null, "Please enter Medical School attended by the doctor:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        int specialist = JOptionPane.showConfirmDialog(null, "Is this a specialist?", "Specialist", JOptionPane.YES_NO_OPTION);
        // the possible values returned by showConfirmDialog are:
        // 0 -> Yes
        // 1 -> No
        // -1 -> window closed
        
        // check that the user entered all values
        if (first != null && !first.isEmpty() && last != null && !last.isEmpty() && !medSchool.isEmpty() && medSchool != null) 
        {
            // get the next doctor ID available
            int doctorID = Clinic.getNextDoctorID();

            if (specialist == 0) 
            {
                // the user answered Yes. Prompt for specialty.
                String specialty = JOptionPane.showInputDialog(null, "Please enter doctor's specialty:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
                String trainingPrograms = JOptionPane.showInputDialog(null, "Please enter doctor's specialty training programs separated by a comma:", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
                
                // if the user entered a value, create an arraylist of the individual training programs
                ArrayList<String> trainingProgramList = new ArrayList<>();
                if( trainingPrograms != null )
                {
                    String[] trainingProgramArray = trainingPrograms.split(",");
                
                    for (String prog : trainingProgramArray)
                        trainingProgramList.add(prog);
                }
                
                /**********************************************************************/
                /*   INITIALIZE THE newDoctor VARIABLE TO A NEW Specialist OBJECT     */
                /**********************************************************************/
                
                newDoctor = new Specialist( specialty,doctorID,medSchool,first,last);
            } 
            else 
            {
                /**********************************************************************/
                /*     INITIALIZE THE newDoctor VARIABLE TO A NEW Doctor OBJECT       */
                /**********************************************************************/
                
                newDoctor= new Doctor( doctorID,medSchool,first,last);
            }
            
            /********************************************************************************/
            /*  ADD THE newDoctor VARIABLE TO THE LIST OF DOCTORS IN THE myClinic OBJECT   */
            /********************************************************************************/
            myClinic.addDoctors(newDoctor);
            
            JOptionPane.showMessageDialog(null, "New doctor information has been added to the system.", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "New doctor could not be added to the system. Not enough information provided.", CLINIC_NAME, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void displayClinicInformation(Clinic clinic) 
    {
        // Create and setup the output window.
	JFrame frame = new JFrame(CLINIC_NAME);
	frame.setSize(600, 600);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new BorderLayout());
	 
	JTextArea textArea = new JTextArea();
        textArea.setFont(new Font( Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setForeground(Color.BLACK);
        textArea.append( clinic.toString() ); 
        textArea.setVisible(true);
        
	JScrollPane scrollableTextArea = new JScrollPane(textArea);
	scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	 
	frame.getContentPane().add(scrollableTextArea); 
	frame.setVisible(true);
    }
}