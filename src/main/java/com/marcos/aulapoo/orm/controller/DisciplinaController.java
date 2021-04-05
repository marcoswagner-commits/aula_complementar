package com.marcos.aulapoo.orm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/disciplinas")
public class DisciplinaController {
	
	@GetMapping
	public String listar(){
		  return "Mensagem em disciplinas";	
	}

}
