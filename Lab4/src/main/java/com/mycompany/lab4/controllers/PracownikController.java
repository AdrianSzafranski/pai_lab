/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4.controllers;

import com.mycompany.lab4.beans.Pracownik;
import com.mycompany.lab4.dao.PracownikDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PracownikController {
    @Autowired
    PracownikDao dao; //wstrzyknięcie dao z pliku XML

    @RequestMapping("/addForm")
    public String showform(Model m){
    m.addAttribute("command", new Pracownik());
    return "addForm"; //przekiekrowanie do addForm.jsp
    }
   
    @RequestMapping(value="/save",method =
    RequestMethod.POST)
    public String save(@ModelAttribute("pr") Pracownik pr){
    dao.save(pr);
    return "redirect:/viewAll";
    //przekierowanie do endpointa o URL: /viewAll
    }
    
    @RequestMapping(value="/delete/{id}",method =RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewAll";
        //przekierowanie do endpointa o URL: /viewAll
    }
    
    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        Pracownik pracownik = dao.getPracownikById(id);
        if(pracownik == null) {
            return "redirect:/viewAll";
        }
           
        m.addAttribute("command", pracownik);
        return "editForm";
      
        //przekierowanie do endpointa o URL: /viewAll
    }
    
    @RequestMapping(value="/edit/editSave",method =RequestMethod.POST)
    public String editSave(@ModelAttribute("pr") Pracownik pr){
        dao.update(pr);
        return "redirect:/viewAll";
        //przekierowanie do endpointa o URL: /viewAll
    }
   
    @RequestMapping("/viewAll")
    public String viewAll(Model m){
        List<Pracownik> list=dao.getAll();
        m.addAttribute("list",list);
        return "viewAll"; //przejście do widoku viewAll.jsp
    }
    
    //Totalna kontrola - ustawienie danych o błędzie w modelu oraz
    //zwrócenie nazwy widoku i modelu w obiekcie ModelAndView
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req,
    Exception ex) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", ex);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error");
    return mav;
    }
} 