package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categoria;

@RestController //con esta anotacion lo exponemos pa mostrarlo
@RequestMapping("/categorias")//como quiero que el navegador conecte a esta clase
public class Categoriacontroller {
	
	@GetMapping("/status") //se mapea por el metodo get y en este caso se llama a este metodo
	public String status() {
		return "pong";
	}
	@GetMapping
	public String allCategorias() {
		return "listar categorias";
	}
	@GetMapping("/{id}") 
	public String categoriaById(@PathVariable String id) {
		return "show categoria "+id;
	}
	@PostMapping("/{id}") 
	public String addCategorias(@RequestBody Categoria categoria) {
		return "post categorias";
	}
	@PutMapping("/{id}") 
	public String updateCategorias(@PathVariable String id, @RequestBody Categoria categoria) {
		return "put categorias "+id;
	}
	@DeleteMapping("/{id}") 
	public String deleteCategorias(@PathVariable String id) {
		return "delete categorias "+id;
	}
}
//hacerle CRUD se usan estos metodos arriba