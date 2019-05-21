package com.source.prevcrim.modelo.instituciones;

import com.source.prevcrim.modelo.conexion.conexionBD;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class institucionesModel {
    private Map result=new LinkedHashMap<>();
    private List Insituciones=new ArrayList<>();

    public Map getInstituciones(){
          try{
              Insituciones= conexionBD.conexionTemplate().queryForList("call getInstitucionesAll()");

          }
          catch (Exception e){
              System.out.println(e.getMessage());
          }
          result.put("instituciones",Insituciones);
     return result;
    }

    public Map getInstitucion(String id){
        try{
            int parametro=Integer.parseInt(id);
            result=conexionBD.conexionTemplate().queryForMap("call getInstitucion('"+parametro+"')");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            result.clear();
            result.put("res","ko");
        }
        return result;
    }

    public Boolean deleteInstitucion(String id){
        Boolean res=false;
        try{
            int parametro=Integer.parseInt(id);
            conexionBD.conexionTemplate().execute("call deleteInstitucion('"+parametro+"')");
            res=true;
        }
        catch (Exception e){
            res=false;
            System.out.println(e.getMessage());

        }
        System.out.println(res);
        return res;

    }

    public Boolean updateInstitucion(String id,String nombre){
        Boolean res=false;
        try{
            int parametro=Integer.parseInt(id);
            conexionBD.conexionTemplate().execute("call updateInstitucion('"+parametro+"','"+nombre+"')");
            res=true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            res=false;
        }

        return res;

    }
    public Boolean insertInstitucion(String nombre){
        Boolean res=false;
        try{
            String parametro=nombre;
            conexionBD.conexionTemplate().execute("call insertInstitucion('"+parametro+"')");
            res=true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            res=false;
        }

        return res;
    }



}
