/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author pc-user
 */
public class OurDataBase {

    private Connection db_con;
    private String db_name;

    public Connection getDb_con() {
        return db_con;
    }

    public OurDataBase(String db_name) {
        this.db_name = db_name;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public void setDb_con(Connection db_con) {
        this.db_con = db_con;
    }

    public void initConnection() throws ClassNotFoundException, SQLException {
        String db_driver = "com.mysql.jdbc.Driver";

        Class.forName(db_driver);
        this.db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.getDb_name() + "", "root", "");

    }

    public Employee employeeExists(Employee E) throws SQLException {
        Connection con = this.db_con;
        String query = "SELECT * FROM `employee` WHERE email = ? && password = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, E.getEmail());
        ps.setString(2, E.getPassword());

        ResultSet rs = ps.executeQuery();

        System.out.println(E.getEmail());
        System.out.println(E.getPassword());

        rs.next();

        E.setEmployee_id(rs.getInt("employee_id"));
        E.setPosition(rs.getString("position"));
        E.setFirst_name(rs.getString("first_name"));
        E.setLast_name(rs.getString("last_name"));
        E.setMiddle_initial(rs.getString("middle_initial").charAt(0));
        E.setEmail(rs.getString("email"));
        E.setPassword(rs.getString("password"));
        E.setBirthdate(rs.getString("birthdate"));
        E.setGender(rs.getString("gender"));
        E.setContact_no(rs.getString("contact_no"));

        return E;
    }

    public LinkedList<Employee> getSalaryModifications() {
        LinkedList<Employee> list = new LinkedList();

        return list;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        OurDataBase DB = new OurDataBase("unwind_sms");
        DB.initConnection();

    }
}
