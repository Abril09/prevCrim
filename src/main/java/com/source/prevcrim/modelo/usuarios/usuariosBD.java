package com.source.prevcrim.modelo.usuarios;

import com.source.prevcrim.modelo.conexion.conexionBD;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class usuariosBD {
    private Map result=new LinkedHashMap<>();

    public Map getUsuarios(String user,String pass,String estado){

        try {
            result = conexionBD.conexionTemplate().queryForMap("call validUsuario('"+user+"','"+pass+"','"+estado+"')");

        }catch(Exception e) {

            System.out.println(e.getMessage());

        }
        return result;
    }

    public Boolean usuario(){
        Boolean res=false;

        try{
            conexionBD.conexionTemplate().queryForMap("call getUser('admin','1234','Activo')");
            res=true;
        }
            catch(Exception e){
            System.out.println(e.getMessage());

        }

        return res;

    }





}
