package com.source.prevcrim.controller.user;

import com.source.prevcrim.modelo.usuarios.usuariosBD;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class userController {



    @GetMapping("/all")
    private Map pro () {

        Boolean res=new usuariosBD().usuario();
        return new usuariosBD().getUsuarios("admin","1233","Activo");
    }

    @PostMapping("/post")
    private Map res(@PathVariable  String id){
        Map s=new HashMap();
            s.put("dev",id);
        return s;
    }

}
