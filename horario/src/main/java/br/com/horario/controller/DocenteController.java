package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.horario.entity.DocenteEntity;
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
	   model.addAttribute("docentes",docenteService.findAnll());
	   model.addAttribute("setores",setorService.finAll());
	   return "docente"; //caminho real do arquivo 
   }
   
   @PostMapping("/salvar_docente")
   public ModelAndView save( 
	   ModelMap model,
	   @ModelAttribute("docenteEntity") DocenteEntity docenteEntity,
	   RedirectAttributes atributes) throws Exception
	   
   {
	   
       ModelAndView mv = new ModelAndView("redirect:/docente");
       atributes.addFlashAttribute("mensagem", docenteService.save(docenteEntity));
       return mv;
   }
   
   @GetMapping("/alterar_docente/{idDocente}")
   public ModelAndView update(ModelMap model,@PathVariable("idDocente")Long idDocente)throws Exception {
	   {
		   ModelAndView mv = new ModelAndView("alterar_docente");
			 model.addAttribute("setores", setorService.finAll());
			 model.addAttribute("idDocente", idDocente);
			 model.addAttribute("docente",docenteService.getOneByIdDocente(idDocente));
		      return mv;		   
	   }
   }
   
   
}




