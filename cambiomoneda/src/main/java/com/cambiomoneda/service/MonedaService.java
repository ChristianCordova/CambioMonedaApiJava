package com.cambiomoneda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cambiomoneda.model.Moneda;
import com.cambiomoneda.repository.MonedaRepository;

@Service
public class MonedaService {

	@Autowired
	private MonedaRepository monedaRepository;
	
	public Moneda create (Moneda moneda) {
		return monedaRepository.save(moneda);
	}
	
	public List<Moneda> getAllMonedas(){
		return monedaRepository.findAll();
	}
	
	public void delete (Moneda moneda) {
		monedaRepository.delete(moneda);
	}
	
	public Optional<Moneda> findById (Long cod_moneda) {
		return monedaRepository.findById(cod_moneda);
	}

	public Moneda save(Moneda moneda) {
		// TODO Auto-generated method stub
		return monedaRepository.save(moneda);
	}

	
}
