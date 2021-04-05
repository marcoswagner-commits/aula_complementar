package com.marcos.aulapoo.orm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	

}
