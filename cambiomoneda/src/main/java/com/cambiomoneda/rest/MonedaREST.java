package com.cambiomoneda.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cambiomoneda.model.Moneda;
import com.cambiomoneda.service.MonedaService;

@RestController
@RequestMapping("/api/moneda")
public class MonedaREST {

	@Autowired
	private MonedaService monedaService;
	
	//http://localhost:8080/api/moneda/consultar/	
	@GetMapping("/consultar")
	private ResponseEntity<List<Moneda>> listarTodasLasMonedas(){		
		return ResponseEntity.ok(monedaService.getAllMonedas());
	}
	
	//http://localhost:8080/api/moneda/registrar/
	@PostMapping("/registrar")
	private ResponseEntity<Moneda> guardar(@RequestBody Moneda moneda){
		Moneda temporal = monedaService.create(moneda);
		try {
			return ResponseEntity.created(new URI("/api/moneda"+temporal.getCod_moneda())).body(temporal);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
		
	//http://localhost:8080/api/moneda/eliminar/
	@DeleteMapping("/eliminar")
	private ResponseEntity<Void> eliminarMoneda (@RequestBody Moneda moneda){
		monedaService.delete(moneda);
		return ResponseEntity.ok().build();
	}

	//http://localhost:8080/api/moneda/buscar/1
	@GetMapping ("/buscar/{cod_moneda}")
	private ResponseEntity<Optional<Moneda>> listarMonedasPorID(@PathVariable ("cod_moneda") Long cod_moneda){
		return ResponseEntity.ok((monedaService).findById(cod_moneda));
	}
	
	
	//http://localhost:8080/api/moneda/actualizar/1
	@PutMapping("/actualizar/{cod_moneda}")
	public Moneda actualizar(@PathVariable(value = "cod_moneda") Long cod_moneda, @RequestBody Moneda monedaDetails) {
		 
		Moneda moneda = monedaService.findById(cod_moneda).orElse(null); 
		//moneda.setCod_moneda(monedaDetails.getCod_moneda());
		moneda.setTipocambio(monedaDetails.getTipocambio()); 
		Moneda updatedNote = monedaService.save(moneda);
        return updatedNote;
    }
	

}
