package com.Interside.backend.apirest.models.dao;

import java.util.List;

import com.Interside.backend.apirest.models.entities.Cuenta;

public interface ICuentaDao {
	public List<Cuenta> findAll();
	public void save(Cuenta Cuenta);
	public void delete(Integer id);
	public Cuenta findById(Integer id);
}
