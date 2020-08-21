package com.Interside.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Interside.backend.apirest.models.dao.IClienteDao;
import com.Interside.backend.apirest.models.entities.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteDao clientedao;
	
	@GetMapping({"","/"})
	public List<Cliente> listar() {
		List<Cliente> clientes = clientedao.findAll();
		return clientes;
	}
	
	@GetMapping("/{id}")
	public Cliente mostrar(@PathVariable Integer id) {
		return clientedao.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String crear(@RequestBody Cliente cliente) {
		clientedao.save(cliente);
		return "todo ok";
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String actualizar(@RequestBody Cliente cliente) {
		clientedao.save(cliente);
		return "todo ok";
	}
	
	@DeleteMapping("/{id}")
	public String eliminar(@PathVariable Integer id) {
		clientedao.delete(id);
		return "todo ok";
	}
}
