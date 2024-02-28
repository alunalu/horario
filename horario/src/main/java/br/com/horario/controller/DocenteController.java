package br.com.horario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocenteController {
   @GetMapping("/docente") // nome que eu quiser colocar
   public String docente ()
   {
	   return "docente"; //caminho real do arquivo 
   }
}




