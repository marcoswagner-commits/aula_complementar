package com.marcos.aulapoo.orm.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcos.aulapoo.orm.model.Disciplina;
import com.marcos.aulapoo.orm.repository.DisciplinaRepository;

@RestController
@RequestMapping(value="/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository repository;
	
	@GetMapping
	public List<Disciplina> listar(){
		List<Disciplina> list = repository.findAll();
		return list;	
	}
	
	@GetMapping(value="/{id}")
	public Disciplina listarUm (@PathVariable Integer id){
		Optional<Disciplina> obj = repository.findById(id);
		return obj.orElse(null);	
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir (@RequestBody Disciplina obj) {
		obj = repository.save(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("{}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Disciplina obj, @PathVariable Integer id) {
		Optional<Disciplina> objF = repository.findById(id);
		objF.get().setNome(obj.getNome());
		objF.get().setCarga_horaria(obj.getCarga_horaria());
		obj = repository.save(objF.get());
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
