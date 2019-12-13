package com.formation.LeonNettoyage.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.LeonNettoyage.exception.AlreadyExistException;
import com.formation.LeonNettoyage.exception.NotAuthorizedException;
import com.formation.LeonNettoyage.persistence.entities.Cleaner;
import com.formation.LeonNettoyage.persistence.entities.Client;
import com.formation.LeonNettoyage.persistence.repositories.ICleanerRepository;
import com.formation.LeonNettoyage.services.ICleanerService;
import com.formation.LeonNettoyage.services.common.AbstractService;

@Service
@Transactional
public class CleanerService extends AbstractService<Cleaner> implements ICleanerService{
	
	@Autowired
	private ICleanerRepository repo;
	
	public JpaRepository<Cleaner, Long> getRepo() {
		return repo;
	}
	@Override
	public Cleaner findByName(String username) {
		return repo.findByName(username);
	}
	@Override
	public Cleaner save(Cleaner t) {
		
		try {
			t = super.save(t);
		} catch (Exception e) {
			throw new AlreadyExistException("impossible d'utiliser ces credentials");
		}
		
		return t;
	}
	
	
}
