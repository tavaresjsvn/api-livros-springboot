package com.projeto.livros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.livros.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	List<Livro> findByAutor(String autor);
	List<Livro> findByTituloContaining(String trecho);
}
