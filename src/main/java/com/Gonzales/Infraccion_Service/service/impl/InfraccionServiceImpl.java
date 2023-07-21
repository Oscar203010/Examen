package com.Gonzales.Infraccion_Service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.extern.slf4j.Slf4j;

import com.Gonzales.Infraccion_Service.exceptions.NoDataFoundException;
import com.Gonzales.Infraccion_Service.repository.InfraccionRepository;
import com.Gonzales.Infraccion_Service.entity.Infraccion;
import com.Gonzales.Infraccion_Service.service.InfraccionService;
import com.Gonzales.Infraccion_Service.validator.InfraccionValidator;

@Service
@Slf4j
public class InfraccionServiceImpl implements InfraccionService{
	@Autowired
	private InfraccionRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Infraccion> findAll(Pageable page){
		try {
			return repository.findAll(page).toList();
		}catch(NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(),e);
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Infraccion> findByDni(String dni, Pageable page){
		try {
			return repository.findByDniContaining(dni,page);
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public Infraccion findById(int id) {
		try {
			Infraccion registro = repository.findById(id).orElseThrow();
			return registro;
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public Infraccion save(Infraccion infraccion) {
		try {
			InfraccionValidator.save(infraccion);	
			Infraccion registro = repository.save(infraccion);
			return registro;
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public Infraccion update(Infraccion infraccion) {
		try {
			InfraccionValidator.save(infraccion);
			Infraccion registro = repository.findById(infraccion.getId()).orElseThrow();
			registro.setDni(infraccion.getDni());
			registro.setDescripcion(infraccion.getDescripcion());
			registro.setFalta(infraccion.getFalta());
			registro.setInfraccion(infraccion.getInfraccion());
			return registro;
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	public void delete(int id) {
		try {
			Infraccion registro = repository.findById(id).orElseThrow();
			repository.delete(registro);
		}catch(Exception e) {
			
		}
	}

	
}
