package com.marcos.aulapoo.orm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
