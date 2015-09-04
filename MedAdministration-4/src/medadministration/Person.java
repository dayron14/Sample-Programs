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
public class Person {
    
    private String firstName;
    private String lastName;
    
    public Person(String firstName, String lastName) {
        
        this.firstName = toProperCase(firstName);
        this.lastName = toProperCase(lastName);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  private String toProperCase(String str) {
        
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    @Override
    public String toString() {
        String str;
        str = "First Name:\t\t" + getFirstName() + "\n "
            + "Last Name:\t\t" + getLastName() + "\n";
        return str;
    }

    
  
  

    
}
