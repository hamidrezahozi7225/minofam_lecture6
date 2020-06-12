package com.company;

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
            Connection connection= DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521:xe","hamidhozi","myjava123");

            Boolean t=true;
            while (t){
                System.out.println("1.insert");
                System.out.println("2.exit");
                int i=scanner.nextInt();
                switch (i){
                    case 1:
                        PreparedStatement preparedStatement=connection.prepareStatement
                                ("insert into karmand(code,name,melicode,fathername,semat,hoghogh,sabeghe)values (?,?,?,?,?,?,?)");
                        System.out.print("code:");
                        int code=scanner.nextInt();
                        System.out.print("name:");
                        String name=scanner.next();
                        System.out.print("melicode:");
                        int melicode=scanner.nextInt();
                        System.out.print("fathername:");
                        String fathername=scanner.next();
                        System.out.print("semat:");
                        String semat=scanner.next();
                        System.out.print("hoghogh:");
                        int hoghogh=scanner.nextInt();
                        System.out.print("sabeghe:");
                        int sabeghe=scanner.nextInt();

                        preparedStatement.setLong(1,code);
                        preparedStatement.setString(2,name);
                        preparedStatement.setLong(3,melicode);
                        preparedStatement.setString(4,fathername);
                        preparedStatement.setString(5,semat);
                        preparedStatement.setLong(6,hoghogh);
                        preparedStatement.setLong(7,sabeghe);
                        preparedStatement.executeUpdate();break;

                    case 2:t=false;break;
                }
            }


                PreparedStatement preparedStatement = connection.prepareStatement("delete from karmand where code=?");
                System.out.print("inter code i k mikhid delete konid ");
                int del = scanner.nextInt();
                preparedStatement.setLong(1, del);
                preparedStatement.executeUpdate();

        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
