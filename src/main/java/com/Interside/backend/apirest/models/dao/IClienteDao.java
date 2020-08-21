package com.Interside.backend.apirest.models.dao;

import java.util.List;

import com.Interside.backend.apirest.models.entities.Cliente;

public interface IClienteDao {
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public void delete(Integer id);
	public Cliente findById(Integer id);
}
