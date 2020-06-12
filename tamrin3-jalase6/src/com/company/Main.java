package com.company;

import com.thaiopensource.xml.dtd.app.Driver;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Scanner scanner=new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hamidreza","myjava123");
           Boolean t=true;
            while (t){
                System.out.println("1:insert");
                System.out.println("2:update");
                System.out.println("3:delete");
                System.out.println("4:exit");
                System.out.print("whitch one:");
                int i=scanner.nextInt();

                switch (i){
                    case 1:
                        PreparedStatement preparedStatement=connection.prepareStatement("insert into uni(code,name,year,avg)values (?,?,?,?)");
                        System.out.println("etelaat");
                        System.out.print("name:");
                        String name = scanner.next();
                        System.out.print("sal vorod:");
                        int year = scanner.nextInt();
                        System.out.print("moadele:");
                        int avg = scanner.nextInt();
                        System.out.print("code insert:");
                        int code=scanner.nextInt();
                        preparedStatement.setLong(1,code);
                        preparedStatement.setString(2,name);
                        preparedStatement.setLong(3,year);
                        preparedStatement.setLong(4,avg);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();break;
                    case 2:PreparedStatement preparedStatement1=connection.prepareStatement("update uni set name=?,year=?,avg=? where code=?");
                        System.out.println("etelaat");
                        System.out.print("code i k mikhid update konid:");
                        int codeup=scanner.nextInt();
                        System.out.print("name:");
                        String name1 = scanner.next();
                        System.out.print("sal vorod:");
                        int year1 = scanner.nextInt();
                        System.out.print("moadele:");
                        int avg1 = scanner.nextInt();
                        preparedStatement1.setLong(4,codeup);
                        preparedStatement1.setString(1,name1);
                        preparedStatement1.setLong(2,year1);
                        preparedStatement1.setLong(3,avg1);
                        preparedStatement1.executeUpdate();
                        preparedStatement1.close();break;
                    case 3:PreparedStatement preparedStatement2=connection.prepareStatement("delete from uni where code=?");
                        System.out.print("code i k mikhid delete konid:");
                        int codeDel=scanner.nextInt();
                        preparedStatement2.setLong(1,codeDel);
                        preparedStatement2.executeUpdate();
                         preparedStatement2.close();break;
                    case 4:t=false;break;
                }
                //connection.close();
            }

        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
