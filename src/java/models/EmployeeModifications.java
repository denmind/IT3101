/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author pc-user
 */
public class EmployeeModifications {

    private Employee emp;
    private Modifications modif;

    public EmployeeModifications() {
        this.emp = new Employee();
        this.modif = new Modifications();
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Modifications getModif() {
        return modif;
    }

    public void setModif(Modifications modif) {
        this.modif = modif;
    }

}
