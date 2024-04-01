package com.ideapad.my_app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

class User{
    private String name;
    private String email;
    private Date dob;
    private Long number;
    private String address;
    public User(String name, String email, Date dob, Long number, String address){
        this.name = name;
        this.email =email;
        this.dob = dob;
        this.number = number;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Date getDob() {
        return dob;
    }
    public Long getNumber() {
        return number;
    }
    public String getAddress() {
        return address;
    }
}

class UserModule{
    private Connection connection;
    public UserModule() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "2802");
        System.out.println("Connected to Database!");
    }

    public void createuser(User user) throws SQLException{
        String query = "INSERT INTO users (name, email, dob, number, address) VALUES(?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setDate(3, user.getDob());
            stmt.setLong(4, user.getNumber());
            stmt.setString(5, user.getAddress());
            stmt.executeUpdate();
        }
    }
}

@Controller
public class AppController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/store")
    public String getData(@RequestParam("customerName") String customerName,
                                @RequestParam("customerEmail") String customerEmail,
                                @RequestParam("CDob") Date CDob,
                                @RequestParam("customerNumber") Long customerNumber,
                                @RequestParam("cAddress") String cAddress,
                                Model model) {


        model.addAttribute("customerName", customerName);
        model.addAttribute("customerEmail", customerEmail);
        model.addAttribute("CDob", CDob);
        model.addAttribute("customerNumber", customerNumber);
        model.addAttribute("cAddress", cAddress);

        System.out.println(customerName);
        System.out.println(customerEmail);
        System.out.println(CDob);
        System.out.println(customerNumber);
        System.out.println(cAddress);

        try{
            UserModule userModule = new UserModule();
            User newuser = new User(customerName, customerEmail, CDob, customerNumber, cAddress);
            userModule.createuser(newuser);
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return "index";
    }
}
