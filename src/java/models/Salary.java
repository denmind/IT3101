package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc-user
 */
public class Salary {
    private int id;
    private int employee_id;
    private double amount;

    public Salary() {
        this.id = 0;
        this.employee_id = 0;
        this.amount = 0.0;
    }

    public Salary(double amount) {
        this.id = 0;
        this.employee_id = 0;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
