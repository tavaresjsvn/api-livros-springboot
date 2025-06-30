package com.projeto.livros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.livros.model.Livro;
import com.projeto.livros.repository.LivroRepository;

import lombok.Data;

@Data
@Service
public class LivroService {

	private LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public Livro salvarLivro(Livro livro) {
		if (livro.getAutor().isBlank() || livro.getTitulo().isBlank()) {
			throw new RuntimeException("Algum dos campos essenciais como autor ou título não foram preenchidos");
		}
		
		if (livro.getId() != null && livroRepository.findById(livro.getId()).isPresent()) {
			throw new RuntimeException("Livro já cadastrado");
		}
		
		return livroRepository.save(livro);
	}
	
	public Optional<Livro> buscarLivroPorId(Long id) {
		if (!livroRepository.existsById(id)) {
		       throw new RuntimeException("Livro não encontrado com ID: " + id);
		}
		
		return livroRepository.findById(id);
	}
	
	public List<Livro> listarTodosOsLivros() {
		return livroRepository.findAll();
	}
	
	public void deletarLivro(Long id) {
		if (!livroRepository.existsById(id)) {
		       throw new RuntimeException("Livro não encontrado com ID: " + id);
		}
		 
		livroRepository.deleteById(id);
	}
	
	public List<Livro> buscarLivrosPorAutor(String autor) {
	    if (autor == null || autor.isBlank()) {
	        throw new RuntimeException("O nome do autor não pode estar em branco.");
	    }

	    return livroRepository.findByAutor(autor);
	}

	public List<Livro> buscarLivrosPorTitulo(String trecho) {
	    if (trecho == null || trecho.isBlank()) {
	        throw new RuntimeException("O título não pode estar em branco.");
	    }

	    return livroRepository.findByTituloContaining(trecho);
	}
	
	public Livro atualizarLivro(Long id, Livro livroAtualizado) {
	    Optional<Livro> livroExistente = livroRepository.findById(id);
	    
	    if (livroExistente.isEmpty()) {
	        throw new RuntimeException("Livro não encontrado com ID: " + id);
	    }
	    
	    Livro livro = livroExistente.get();
	    livro.setTitulo(livroAtualizado.getTitulo());
	    livro.setAutor(livroAtualizado.getAutor());
	    livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
	    livro.setStatus(livroAtualizado.getStatus());
	    livro.setNota(livroAtualizado.getNota());
	    
	    return livroRepository.save(livro);
	}
}
