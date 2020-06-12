package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    try{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","site","myjava123");
        connection.setAutoCommit(false);
       PreparedStatement preparedStatement=connection.prepareStatement("insert into infor(code,name,email,username,age,tahsil)values (?,?,?,?,?,?)");
       preparedStatement.setLong(1,6);
       preparedStatement.setString(2,"asad");
       preparedStatement.setString(3,"asad@gmail.com");
       preparedStatement.setLong(4,2610);
       preparedStatement.setLong(5,32);
       preparedStatement.setString(6,"doctora");
        preparedStatement.executeUpdate();



      Scanner scanner=new Scanner(System.in);
        System.out.println("do you want update ");
        System.out.print("yes or no:");
        String i=scanner.next();
        if(i.equals("yes")) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("update infor set name=?,email=?,username=?,age=?,tahsil=? where code=?");
                System.out.print("Which code do you want to update:");
                int code=scanner.nextInt();
            preparedStatement1.setLong(6, code);
                System.out.print("name:");
                String name=scanner.next();
            preparedStatement1.setString(1, name);
                System.out.print("email");
                String email=scanner.next();
            preparedStatement1.setString(2, email);
                System.out.print("username:");
                int user=scanner.nextInt();
            preparedStatement1.setLong(3, user);
                 System.out.print("age:");
                  int age=scanner.nextInt();
            preparedStatement1.setLong(4, age);
                  System.out.print("tahsilat");
                 String tahsil=scanner.next();
            preparedStatement1.setString(5, tahsil);
                  preparedStatement1.executeUpdate();
        }
       preparedStatement.close();
       connection.close();
    }catch (ClassNotFoundException ex){
        ex.printStackTrace();
    }
    catch (SQLException ex){
        ex.printStackTrace();
    }

    }
}
