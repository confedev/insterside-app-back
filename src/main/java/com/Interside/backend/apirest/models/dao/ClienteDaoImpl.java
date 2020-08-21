package com.Interside.backend.apirest.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Interside.backend.apirest.models.entities.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		if(cliente.getId()==null || cliente.getId()==0) {
			em.persist(cliente);			
		}else {
			em.merge(cliente);
		}
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Cliente c = findById(id);
		if(c!=null) {
			em.remove(c);
		}
		
	}

	@Override
	public Cliente findById(Integer id) {
		List<Cliente> clientes = findAll();
		for(Cliente c: clientes){
			if(c.getId()==id) {
				return c;
			}
		}
		return null;
	}

}
