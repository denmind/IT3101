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
    private String type;
    private String description;
    private LocalDateTime schedule;

    public Modifications() {
        this.id = 0;
        this.salary_id = 0;
        this.amount = 0;
        this.type = "ADDITION";
        this.description = "example";
        this.schedule = java.time.LocalDateTime.now();
    }

    public Modifications(double amount, String type, String description, LocalDateTime schedule) {
        this.id = 0;
        this.salary_id = 0;
        
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.schedule = schedule;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }
    
    
}
