package com.source.prevcrim.modelo.menu;

import com.source.prevcrim.modelo.conexion.conexionBD;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public class menuRol {
    private Map result=new LinkedHashMap<>();
    private List itemsMenu=new ArrayList<>();
    private List nivelUno=new ArrayList();
    private List nivelDos=new ArrayList();
    public Map getMenu(String user,String pass){

        try{
            itemsMenu= conexionBD.conexionTemplate().queryForList("call getMenuRol('"+user+"','"+pass+"')");
            for (Object item:itemsMenu)
                 {
                     Map objeto=(Map)item;
                     String nivelActual=(String)objeto.get("nivel");
                        this.switchMenu(nivelActual,objeto);

                 }



            result.put("itemsMenu",this.nivelUno);

            }
        catch(Exception c){
            System.out.println(c.getMessage());
        }
        return result;
    }
    //ordena menu ingresando subItem ver respuesta a mas items//
    public void switchMenu(String op,Map objeto){
           int size=nivelUno.size();

        switch (op){
            case "0":
                    this.nivelUno.add(objeto);
                    this.nivelDos.clear();
                break;
            case "1":

                    for (int i=size;i>0;i--){
                            Object objetoActual=this.nivelUno.get(i-1);
                            objetoActual=(Map)objetoActual;
                            String nivel= (String) ((Map) objetoActual).get("nivel");
                            if(nivel.equals("0")){
                                this.nivelDos.add(objeto);
                                List nivelpas=new ArrayList();
                                    nivelpas.addAll(this.nivelDos);
                                ((Map) objetoActual).put("subMenu",nivelpas);
                                break;

                            }

                    }
                break;


        }


    }

}
