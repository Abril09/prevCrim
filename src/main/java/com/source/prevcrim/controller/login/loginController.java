package com.source.prevcrim.controller.login;

import java.util.LinkedHashMap;
import java.util.Map;
import com.source.prevcrim.Dao.usuario.usuarios;
import com.source.prevcrim.modelo.menu.menuRol;
import org.springframework.web.bind.annotation.*;
import com.source.prevcrim.modelo.usuarios.usuariosBD;
import java.util.List;

@RestController
@RequestMapping("/login")
public class loginController {
    private Map result=new LinkedHashMap();

    @PostMapping()
    @ResponseBody
    public Map  validUser(@RequestBody usuarios usuario)

    {   try {
            usuariosBD us=new usuariosBD();
            Map datos=us.getUsuarios(usuario.getUser(),usuario.getPass());
            if(!datos.containsKey("false")){

                Map menu=new menuRol().getMenu(usuario.getUser(),usuario.getPass());
                result.put("data",datos);
                result.put("menu",menu);
                result.put("res","ok");
            }else{
                result.clear();
                result.put("res","ko");

            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return result;
    }


}
