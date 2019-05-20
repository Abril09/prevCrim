package com.source.prevcrim.modelo.conexion;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public  class  conexionBD {

    static private DriverManagerDataSource conexion= new DriverManagerDataSource();
   static  private String className="com.mysql.cj.jdbc.Driver";
   static private String url="jdbc:mysql://localhost:3306/mydb";
   static private String userName="root";
   static private String pass="root";

    public static DriverManagerDataSource Conectar(){
        conexion.setDriverClassName(className);
        conexion.setUrl(url);
        conexion.setUsername(userName);
        conexion.setPassword(pass);
        return conexion;
    }

    public static JdbcTemplate conexionTemplate(){

        return new JdbcTemplate(Conectar());
    }

}
