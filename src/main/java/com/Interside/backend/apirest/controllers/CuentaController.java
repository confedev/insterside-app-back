package com.Interside.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Interside.backend.apirest.models.dao.ICuentaDao;
import com.Interside.backend.apirest.models.entities.Cuenta;

@RestController
@RequestMapping("/cliente/{idCliente}/cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaDao Cuentadao;
	
	@GetMapping({"","/"})
	public List<Cuenta> listar() {
		List<Cuenta> Cuentas = Cuentadao.findAll();
		return Cuentas;
	}
	
	@GetMapping("/{id}")
	public Cuenta mostrar(@PathVariable Integer idCliente, @PathVariable Integer id) {
		return Cuentadao.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String crear(@PathVariable Integer idCliente,@RequestBody Cuenta Cuenta) {
		Cuentadao.save(Cuenta);
		return "todo ok";
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String actualizar(@PathVariable Integer idCliente,@RequestBody Cuenta Cuenta) {
		Cuentadao.save(Cuenta);
		return "todo ok";
	}
	
	@DeleteMapping("/{id}")
	public String eliminar(@PathVariable Integer idCliente,@PathVariable Integer id) {
		Cuentadao.delete(id);
		return "todo ok";
	}
}
