/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.io.Serializable;

/**
 *
 * @author Lisa
 */
public class Accounts implements Serializable {

    private String employeeID;
    private String password;

        public Accounts() {

        this("", "");

    }
    
    public Accounts(String employeeID, String password) {

        this.employeeID = employeeID;
        this.password = password;
        //all = this.name + "         " + this.quantity;
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
