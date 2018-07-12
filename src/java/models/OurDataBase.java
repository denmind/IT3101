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
public class OurDataBase {
    private final String db_name;
    private final String db_pass;
    private final String db_user;

    public OurDataBase() {
        /**Change these to your database**/
        db_name = "salary_management_system";
        db_pass = "";
        db_user = "root";
    }

    public String db_name() {
        return db_name;
    }

    public String db_pass() {
        return db_pass;
    }

    public String db_user() {
        return db_user;
    }
}
