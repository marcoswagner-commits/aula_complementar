package com.marcos.aulapoo.orm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcos.aulapoo.orm.model.Disciplina;
import com.marcos.aulapoo.orm.repository.DisciplinaRepository;

@SpringBootApplication
public class AulaOrmApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AulaOrmApplication.class, args);
	}

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Disciplina d1 = new Disciplina(null, "Programação Orientada a Objetos",64);
		Disciplina d2 = new Disciplina(null, "Estrutura de Dados",64);
		Disciplina d3 = new Disciplina(null, "Engenharia de Software",64);
		
		disciplinaRepository.saveAll(Arrays.asList(d1,d2,d3));
		
	}

}
