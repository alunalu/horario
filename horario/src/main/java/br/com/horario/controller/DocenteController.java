package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.horario.service.DocenteService;
import br.com.horario.service.SetorService;

@Controller
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService;
	@Autowired
	private SetorService setorService;
	
   @GetMapping("/docente") // nome que eu quiser colocar
   public String docente (ModelMap model)
   {
	   model.addAttribute("docente",docenteService.findAnll());
	   model.addAttribute("setores",setorService.finAll());
	   return "docente"; //caminho real do arquivo 
   }
}




