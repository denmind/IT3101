/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author pc-user
 */
public class Modifications {

    private int id;
    private int salary_id;

    private double amount;
    private double updatedSalary;
    private String type;
    private String description;
    private String schedule;

    public Modifications() {
        this.id = 0;
        this.salary_id = 0;
        this.amount = 0.0;
        this.updatedSalary = 0.0;
        this.type = "";
        this.description = "";
        this.schedule = "";
    }

    public Modifications(double amount, String type, String description) {
        this.id = 0;
        this.salary_id = 0;

        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public double getUpdatedSalary() {
        return updatedSalary;
    }

    public void setUpdatedSalary(double updatedSalary) {
        this.updatedSalary = updatedSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(int salary_id) {
        this.salary_id = salary_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
