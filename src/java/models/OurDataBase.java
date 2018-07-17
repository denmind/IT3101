/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;

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
        Connection con = this.getDb_con();
        String query = "SELECT * FROM `employee` WHERE email = ? && password = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, E.getEmail());
        ps.setString(2, E.getPassword());

        ResultSet rs = ps.executeQuery();

        rs.next();

        E.setEmployee_id(rs.getInt("employee_id"));
        E.setPosition(rs.getString("position"));
        E.setFirst_name(rs.getString("first_name"));
        E.setLast_name(rs.getString("last_name"));
        E.setMiddle_initial(rs.getString("middle_initial"));
        E.setEmail(rs.getString("email"));
        E.setPassword(rs.getString("password"));
        E.setBirthdate(rs.getString("birthdate"));
        E.setGender(rs.getString("gender"));
        E.setContact_no(rs.getString("contact_no"));

        return E;
    }

    public LinkedList<EmployeeModifications> getSalaryModifications() throws SQLException {
        LinkedList<EmployeeModifications> list = new LinkedList();

        String query = "SELECT m.*, e.* FROM modifications m  JOIN salary s ON s.sal_id = m.salary_id JOIN unwind.employee e ON s.employee_id = e.employee_id ORDER BY m.mod_id DESC";

        Connection con = this.getDb_con();
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            EmployeeModifications EM = new EmployeeModifications();

            EM.getModif().setId(rs.getInt("mod_id"));
            EM.getModif().setDescription(rs.getString("description"));
            EM.getModif().setAmount(rs.getDouble("amount"));
            EM.getModif().setUpdatedSalary(rs.getDouble("salary"));
            EM.getModif().setSchedule(rs.getString("datetime"));

            EM.getEmp().setEmployee_id(rs.getInt("employee_id"));
            EM.getEmp().setFirst_name(rs.getString("first_name"));
            EM.getEmp().setMiddle_initial(rs.getString("middle_initial"));
            EM.getEmp().setLast_name(rs.getString("last_name"));
            EM.getEmp().setPosition(rs.getString("position"));

            list.add(EM);
        }

        return list;
    }

    public LinkedList<String> getPositions() throws SQLException {
        LinkedList<String> list = new LinkedList();

        String query = "SELECT position FROM employee GROUP BY position";

        Connection con = this.getDb_con();
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(rs.getString("position"));
        }

        return list;
    }

    public LinkedList<Employee> getEmployeeIDs() throws SQLException {
        LinkedList<Employee> list = new LinkedList();

        String query = "SELECT employee_id,first_name,middle_initial,last_name FROM employee ORDER BY employee_id ASC";

        Connection con = this.getDb_con();
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Employee Em = new Employee();

            Em.setEmployee_id(rs.getInt("employee_id"));
            Em.setFirst_name(rs.getString("first_name"));
            Em.setMiddle_initial(rs.getString("middle_initial"));
            Em.setLast_name(rs.getString("last_name"));

            list.add(Em);
        }

        return list;
    }

    public Employee getUserCredentials(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        Employee e = new Employee();
        OurDataBase db = this;

        this.initConnection();
        e.setEmail(request.getParameter("email"));
        e.setPassword(request.getParameter("password"));
        e = db.employeeExists(e);

        return e;
    }

    public LinkedList<Employee> getAllEmployees() throws SQLException {
        LinkedList<Employee> list = new LinkedList();

        String query = "SELECT e.*,s.amount FROM employee e JOIN unwind_sms.salary s ON s.employee_id = e.employee_id ORDER BY e.employee_id ASC ";

        Connection con = this.getDb_con();
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Employee E = new Employee();

            E.setEmployee_id(rs.getInt("employee_id"));
            E.setFirst_name(rs.getString("first_name"));
            E.setLast_name(rs.getString("last_name"));
            E.setMiddle_initial(rs.getString("middle_initial"));
            E.setPosition(rs.getString("position"));
            E.setSalary(rs.getDouble("amount"));

            list.add(E);
        }

        return list;
    }

    public LinkedList<Employee> getAllEmployeesBasedOnPosition(String selectedPosition) throws SQLException {
        LinkedList<Employee> list = new LinkedList();

        String query = "SELECT e.*,s.amount FROM employee e JOIN unwind_sms.salary s ON s.employee_id = e.employee_id WHERE e.position = '" + selectedPosition + "' ORDER BY e.employee_id ASC ";

        Connection con = this.getDb_con();
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Employee E = new Employee();

            E.setEmployee_id(rs.getInt("employee_id"));
            E.setFirst_name(rs.getString("first_name"));
            E.setLast_name(rs.getString("last_name"));
            E.setMiddle_initial(rs.getString("middle_initial"));
            E.setPosition(rs.getString("position"));
            E.setSalary(rs.getDouble("amount"));

            list.add(E);
        }

        return list;
    }

    public double getSalary(int employee_id) throws SQLException {
        Connection con = this.getDb_con();
        double salary = 0.0;
        String query = "SELECT amount FROM salary WHERE employee_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, employee_id);

        ResultSet rs = ps.executeQuery();

        rs.next();

        salary = rs.getDouble("amount");

        return salary;
    }

    public void changeEmployeeSalary(int employee_id, double salary) throws SQLException {
        Connection con = this.getDb_con();
        String query = "UPDATE `salary` SET `amount` = ? WHERE `salary`.`sal_id` = ?;";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setDouble(1, salary);
        ps.setInt(2, employee_id);

        ps.executeUpdate();

    }

    public void addEmployeeModification(int salary_id, double amount, double salary, String description, String type, String datetime) throws SQLException {
        Connection con = this.getDb_con();
        String query = "INSERT INTO `modifications` (`salary_id`, `amount`, `salary`, `description`, `type`, `datetime`) VALUES (?, ?, ?, ?, ?, ?) ";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, salary_id);
        ps.setDouble(2, amount);
        ps.setDouble(3, salary);
        ps.setString(4, description);
        ps.setString(5, type);
        ps.setString(6, datetime);

        ps.executeUpdate();

    }

    public void insertNewEmployee(String position, String fname, String lname, String mi, String email, String password, String dob, String gender, String contact, String accCreate) throws SQLException {

        Connection con = this.getDb_con();
        String query = "INSERT INTO `employee`( `position`, `first_name`, `last_name`, `middle_initial`, `email`, `password`, `birthdate`, `gender`, `contact_no`, `date_account_created`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, position);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setString(4, mi);
        ps.setString(5, email);
        ps.setString(6, password);
        ps.setString(7, dob);
        ps.setString(8, gender);
        ps.setString(9, contact);
        ps.setString(10, accCreate);

        ps.executeUpdate();
    }
    
    public void updateEmployee(String employee_id, String position, String fname, String lname, String mi, String email, String password, String dob, String gender, String contact) throws SQLException {

        Connection con = this.getDb_con();
        String query = "UPDATE `employee` SET `position`=?,`first_name`=?,`last_name`=?,`middle_initial`=?,`email`=?,`password`=?,`birthdate`=?,`gender`=?,`contact_no`=? WHERE `employee_id`=?";
        
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, position);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setString(4, mi);
        ps.setString(5, email);
        ps.setString(6, password);
        ps.setString(7, dob);
        ps.setString(8, gender);
        ps.setString(9, contact);
        ps.setString(10, employee_id);

        ps.executeUpdate();
    }
    
    public void deleteEmployee(int id) throws SQLException{
        Connection con=this.getDb_con();
        String query = "DELETE FROM `employee` WHERE `employee_id`=?";
        PreparedStatement ps=con.prepareStatement(query);
        
        ps.setInt(1, id);
        
        ps.executeUpdate();
    }

//<editor-fold defaultstate="collapsed" desc="Test methods here">
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        OurDataBase DB = new OurDataBase("unwind_sms");
        DB.initConnection();

        DB.changeEmployeeSalary(1, 233);
    }
//</editor-fold>
}
