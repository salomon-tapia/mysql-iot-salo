package com.sic;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        //Try-Catch para manejo de errores
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            //Nueva conexión                           conexión a localhost |   nombre de bd | ususario mysql | contraseña  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "sa", "1234salo");
            Statement stmt = con.createStatement();
            //llamada a todos los datos de la tabla tienda
            ResultSet rs = stmt.executeQuery("select * from articulo");
            //Ciclo de todos los elementos obtenidos por el query
            while (rs.next())
                //mostrar los valores
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+ " " + rs.getString(4));
            //Se cierra la conexión 
            con.close();
        } catch (Exception e) {
            //Imprimir errores 
            System.out.println(e);
        }
    }

}