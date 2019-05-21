package com.source.prevcrim.controller.institucion;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.source.prevcrim.Dao.institucion.institucion;
import org.springframework.web.bind.annotation.*;
import com.source.prevcrim.modelo.instituciones.institucionesModel;

@RestController
@RequestMapping("/institucion")
public class institucionController {
    private Map result=new HashMap();
    private institucionesModel inst=new institucionesModel();

    @GetMapping("/getInstitucionAll")
    public Map getInstitucionesAll(){
        result.clear();
        result.put("result",inst.getInstituciones());
        return result;
    }

    @PostMapping("/getInstitucion")
    @ResponseBody
    public Map getInstitucion(@RequestBody institucion institucion){
        result.clear();
        String id=String.valueOf(institucion.getId());
        Map institucionMap=new LinkedHashMap();
        institucionMap.put("institucion",inst.getInstitucion(id));
        result.put("result",institucionMap);
        return result;
    }
    @DeleteMapping("/delete")
    public Map deleteInstitucion(@RequestBody institucion institucion){

        result.clear();
        String id=String.valueOf(institucion.getId());
        String res=(String)inst.getInstitucion(id).get("res");

        if(res==null){
            //eliminada correctamente//
           if(inst.deleteInstitucion(id)){
               result.put("res","ok");
           }else{
               //existe pero no se puede eliminar//
               result.put("res","fail");
           }

        }else{
             //no existe//
            result.put("res","ko");
        }

    return result;

    }

    @PutMapping("/update")
    public Map updateInstitucion(@RequestBody institucion institucion){

        result.clear();
        String id=String.valueOf(institucion.getId());
        String res=(String)inst.getInstitucion(id).get("res");
        String nombre=institucion.getNombre();
        if(res==null){
            //eliminada correctamente//
            if(inst.updateInstitucion(id,nombre)){
                result.put("res","ok");
            }else{
                //existe pero no se puede eliminar//
                result.put("res","fail");
            }

        }else{
            //no existe//
            result.put("res","ko");
        }
        return  result;

    }




    @PostMapping("/createInstitucion")
    @ResponseBody
    public Map insertInstitucion(@RequestBody institucion institucion){
        result.clear();
        Boolean res=inst.insertInstitucion(institucion.getNombre());

        if(res){
            result.put("res","ok");
        }else{
            result.put("res","ko");
        }
        return result;
    }
}
