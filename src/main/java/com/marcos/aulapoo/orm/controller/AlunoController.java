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

import com.marcos.aulapoo.orm.model.Aluno;
import com.marcos.aulapoo.orm.repository.AlunoRepository;

@RestController
@RequestMapping(value="/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public List<Aluno> listar(){
		List<Aluno> list = repository.findAll();
		return list;	
	}
	
	@GetMapping(value="/{id}")
	public Aluno listarUm (@PathVariable Integer id){
		Optional<Aluno> obj = repository.findById(id);
		return obj.orElse(null);	
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir (@RequestBody Aluno obj) {
		obj = repository.save(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("{}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Aluno obj, @PathVariable Integer id) {
		Optional<Aluno> objF = repository.findById(id);
		objF.get().setNome(obj.getNome());
		objF.get().setEmail(obj.getEmail());
		objF.get().setMatricula(obj.getMatricula());
		objF.get().setCurso(obj.getCurso());
		obj = repository.save(objF.get());
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

}
