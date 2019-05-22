package com.source.prevcrim.modelo.usuarios;

import com.source.prevcrim.Dao.usuario.usuarios;
import com.source.prevcrim.modelo.conexion.conexionBD;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class usuariosBD {
    private Map result=new LinkedHashMap<>();
    private List listaOperadores=new ArrayList();
    public Map getUsuarios(String user,String pass){

        try {
            result = conexionBD.conexionTemplate().queryForMap("call validUsuario('"+user+"','"+pass+"')");

        }catch(Exception e) {

            System.out.println(e.getMessage());

        }
        return result;
    }

    public Boolean usuario(){
        Boolean res=false;

        try{
            conexionBD.conexionTemplate().queryForMap("call getUser('admin','1234')");
            res=true;
        }
            catch(Exception e){
            System.out.println(e.getMessage());

        }

        return res;

    }

    public Map getAllOperadores (){
        result.clear();
        try{

            this.listaOperadores=conexionBD.conexionTemplate().queryForList("call getOperadoresAll()");
            this.result.put("operadores",this.listaOperadores);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            result.put("res","ko");
        }
        return result;
    }

    public Map insertUsuario(usuarios usr){
        result.clear();
        try{
            int institucion=Integer.parseInt(usr.getInstitucion());
            int perfil=Integer.parseInt(usr.getPerfil());
            String rut=usr.getRut();
            String nombre=usr.getNombre();
            String apellido=usr.getApellido();
            String usuario=usr.getUser();
            String pass=usr.getPass();
            result=conexionBD.conexionTemplate().queryForMap("call verficarIngresoPerfilUsuario('"+rut+"','"+nombre+"','"+apellido+"','"+institucion+"','"+usuario+"','"+pass+"','"+perfil+"')");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }





}
