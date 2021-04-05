package com.marcos.aulapoo.orm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/alunos")
public class AlunoController {
	
	@GetMapping
	public String listar(){
		  return "Primeira mensagem da aplicação!";	
	}

}
