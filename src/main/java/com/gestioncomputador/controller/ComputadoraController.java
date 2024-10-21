package com.gestioncomputador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestioncomputador.entity.Computadora;
import com.gestioncomputador.repository.CursoRepository;

@Controller
public class ComputadoraController {
	@Autowired
	private CursoRepository cursoRepository;
	@GetMapping
	public String home() {
		return "redirect:/computadora";
	}
	@GetMapping("/computadora")
	
	public String listarComputadora(Model model) {
		List<Computadora> computadora = cursoRepository.findAll();
		computadora = cursoRepository.findAll();
		model.addAttribute("computadora", computadora);
		return "computadora";
	}
	@GetMapping("/computadora/nuevo")
	public String agregarComputadora(Model model) {
	    Computadora computadora = new Computadora();
	    model.addAttribute("computadora", computadora);
	    model.addAttribute("pageTitle", "Nueva Computadora");
	    return "computadora_form";
	}

	@PostMapping("/computadora/save")
	public String guardarComputadora(Computadora computadora, RedirectAttributes redirectAttributes) {
	    try {
	        cursoRepository.save(computadora);
	        redirectAttributes.addFlashAttribute("message", "El computador ha sido guardado con éxito");
	    } catch (Exception e) {
	        redirectAttributes.addAttribute("message", e.getMessage());
	    }
	    return "redirect:/computadora";
	}
	
	

}
