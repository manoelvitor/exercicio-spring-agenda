package com.agenda.api.controller;

import java.util.List;

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

import com.agenda.api.model.Contato;
import com.agenda.api.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController implements ControllerInterface<Contato> {

	@Autowired
	ContatoService service;

	@Override
	@GetMapping
	public ResponseEntity<List<Contato>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Contato _contato = service.findById(id);
		if (_contato != null)
			return ResponseEntity.ok(_contato);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Contato contato) {
		if (service.update(contato)) {
			return ResponseEntity.ok(contato);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Contato> post(@RequestBody Contato contato) {
		service.create(contato);
		return ResponseEntity.ok(contato);
	}

}
