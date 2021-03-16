package com.agenda.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
	ResponseEntity<List<T>> getAll();
	
	ResponseEntity<?> get(Long id);
	ResponseEntity<?> put(T obj);
	ResponseEntity<?> delete(Long id);
	ResponseEntity<T> post(T obj);

}
