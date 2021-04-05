package com.marcos.aulapoo.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcos.aulapoo.orm.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
