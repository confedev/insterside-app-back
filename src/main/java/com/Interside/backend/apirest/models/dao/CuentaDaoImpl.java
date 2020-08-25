package com.Interside.backend.apirest.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Interside.backend.apirest.models.entities.Cuenta;

@Repository
public class CuentaDaoImpl implements ICuentaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> findAll() {
		return em.createQuery("from Cuenta").getResultList();
	}
	
	@Override
	@Transactional
	public void save(Cuenta Cuenta) {
		if(Cuenta.getId()==null || Cuenta.getId()==0) {
			em.persist(Cuenta);			
		}else {
			em.merge(Cuenta);
		}
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Cuenta c = findById(id);
		if(c!=null) {
			em.remove(c);
		}
		
	}

	@Override
	public Cuenta findById(Integer id) {
		List<Cuenta> Cuentas = findAll();
		for(Cuenta c: Cuentas){
			if(c.getId()==id) {
				return c;
			}
		}
		return null;
	}

}
