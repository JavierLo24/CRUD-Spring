package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Controller 
@RequestMapping("/categorias_view")
public class CategoriaViewController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Categoria> categorias = categoriaRepository.findAll();
		model.addAttribute("categorias", categorias);
		return "index";
	}
	
	@GetMapping("/new")
    public String newUser(Model model) {
		Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        return "formularioCategoria";
    }

    @PostMapping("")
    public String create(@ModelAttribute("categoria") Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "/new";
        }
        categoriaRepository.save(categoria);
        return "redirect:/categorias_view/listar";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
    	Optional<Categoria> categoria = categoriaRepository.findById(id);
        model.addAttribute("categoria", categoria);
        return "formularioCategoria";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "formularioCategoria";
        }
        categoriaRepository.save(categoria);
        return "redirect:/categorias_view/listar";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
    	categoriaRepository.deleteById(id);
        return "redirect:/categorias_view/listar";
    }
	
}
