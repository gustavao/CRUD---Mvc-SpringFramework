/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.Conexion;
import Entidad.Persona;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gustavo Espindola
 */
@Controller
public class Controlador {
    
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        
        String sql = "select * from persona";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping(value="agregar.htm", method=RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Persona());
        mav.setViewName("agregar");
        return mav;
    }
    
    @RequestMapping(value="agregar.htm", method=RequestMethod.POST)
    public ModelAndView Agregar(Persona p){
        String sql = "insert into persona (Nombres, Correo, Nacionalidad) values (?,?,?)";
        this.jdbcTemplate.update(sql,p.getNom(),p.getCorreo(),p.getNacio());
        return new ModelAndView("redirect:/index.htm");
    }
    
    @RequestMapping(value="editar.htm", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql = "select * from persona where id="+id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("editar");
        return mav;     
    }
    
   @RequestMapping(value="editar.htm", method=RequestMethod.POST) 
    public ModelAndView Editar(Persona p){
        String sql = "update persona set Nombres=? ,Correo=? ,Nacionalidad=? where id=?";
        this.jdbcTemplate.update(sql,p.getNom(),p.getCorreo(),p.getNacio(),id);
        return new ModelAndView("redirect:/index.htm");
    }
    
    @RequestMapping(value="borrar.htm") 
    public ModelAndView Borrar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id")); 
        String sql = "delete from persona where id=?";
        this.jdbcTemplate.update(sql,id);
        return new ModelAndView("redirect:/index.htm");
    }   
    
}
