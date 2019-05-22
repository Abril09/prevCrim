package com.source.prevcrim.controller.user;

import com.source.prevcrim.Dao.usuario.usuarios;
import com.source.prevcrim.modelo.usuarios.usuariosBD;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class userController {
    private Map result=new LinkedHashMap();


    @GetMapping("/list")
    private Map getAllOperadores () {
        result.clear();
        try {
            result.put("res",new usuariosBD().getAllOperadores());


        }catch(Exception e){
            result.put("res","ko");
            System.out.println(e.getMessage());

        }
        return result;
    }
    @PostMapping()
    @ResponseBody
    private Map insertPerfilUsr(@RequestBody usuarios usr){
        try{
            result=new usuariosBD().insertUsuario(usr);
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }


        return result;
    }

}
