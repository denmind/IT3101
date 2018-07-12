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
    private double value;
    private String description;
    private LocalDateTime schedule;

    public Modifications() {
    }

    public Modifications(double value, String description) {
        this.value = value;
        this.description = description;
        this.schedule = java.time.LocalDateTime.now();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
