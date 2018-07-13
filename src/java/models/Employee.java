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
public class Employee {

//    Same with employee table from db
//    1 hr & 30 mins  = 1.5
//    1 hr & 15 mins  = 1.25
//    1 hr & 45 mins  = 1.75;
//    Take the mins = X; HR.(X divided by 60)
//    NO IMAGE NO PROBLEM
//    Use NULL for idsto auto_increment for SQL Insert
//    When using empty constructor make sure to set it afterwards else pseudo data is used
    private int employee_id;
    private String position;
    private String first_name;
    private String last_name;
    private char middle_initial;
    private String email;
    private String password;
    private String birthdate;
    private String gender;
    private String contact_no;
    private LocalDateTime date_account_created;
    private Salary salary;

    public Employee() {
        this.salary = null;
        this.employee_id = 0;
        
        this.date_account_created = java.time.LocalDateTime.now();

        this.birthdate = "example";
        this.position = "example";
        this.first_name = "example";
        this.last_name = "example";
        this.middle_initial = 'e';
        this.email = "example@gmail.com";
        this.password = "example";
        this.gender = "example";
        this.contact_no = "example";
    }


    public Employee(int employee_id ,String position, String first_name, String last_name, char middle_initial, String email, String password, String birthdate, String gender, String contact_no, double working_hours, String working_shift) {
        this.date_account_created = java.time.LocalDateTime.now();
        this.salary = null;
        
        this.employee_id = employee_id;
        this.position = position;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_initial = middle_initial;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
        this.contact_no = contact_no;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public char getMiddle_initial() {
        return middle_initial;
    }

    public void setMiddle_initial(char middle_initial) {
        this.middle_initial = middle_initial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public LocalDateTime getDate_account_created() {
        return date_account_created;
    }

    public void setDate_account_created(LocalDateTime date_account_created) {
        this.date_account_created = date_account_created;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

}
