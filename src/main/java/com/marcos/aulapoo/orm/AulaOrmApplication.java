package com.marcos.aulapoo.orm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcos.aulapoo.orm.model.Aluno;
import com.marcos.aulapoo.orm.model.Disciplina;
import com.marcos.aulapoo.orm.repository.AlunoRepository;
import com.marcos.aulapoo.orm.repository.DisciplinaRepository;

@SpringBootApplication
public class AulaOrmApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AulaOrmApplication.class, args);
	}

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Disciplina d1 = new Disciplina(null, "Programação Orientada a Objetos",64);
		Disciplina d2 = new Disciplina(null, "Estrutura de Dados",64);
		Disciplina d3 = new Disciplina(null, "Engenharia de Software",64);
		
		Aluno a1 = new Aluno(null,"ANTÔNIO SOARES GONZAGA NETO","antonio@gmail.com","1234","CC");
		Aluno a2 = new Aluno(null,"BRUNA MOTA BARBOSA","bruna@gmail.com","12345","CC");
		Aluno a3 = new Aluno(null,"CARLOS HENRIQUE CABRAL CARLONI","carlos@gmail.com","123456","CC");
		Aluno a4 = new Aluno(null,"DANIEL LEMES MORAES","daniel@gmail.com","456123","CC");
		Aluno a5 = new Aluno(null,"ELIAS GREGORE VIEIRA DIAS","elias@gmail.com","45123","CC");
				
						

		alunoRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5));
		disciplinaRepository.saveAll(Arrays.asList(d1,d2,d3));
		
	}

}
