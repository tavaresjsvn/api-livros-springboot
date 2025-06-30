package com.projeto.livros.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.livros.model.Livro;
import com.projeto.livros.service.LivroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

	private final LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
		Livro livroSalvo = livroService.salvarLivro(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
	}
	
	@GetMapping
	public  ResponseEntity<List<Livro>> listarTodosOsLivros() {
		List<Livro> livros = livroService.listarTodosOsLivros();
		return ResponseEntity.ok(livros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
	    return livroService.buscarLivroPorId(id)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
	    Livro atualizado = livroService.atualizarLivro(id, livroAtualizado);
	    return ResponseEntity.ok(atualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> deletarLivro(@PathVariable Long id) {
		livroService.deletarLivro(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/autor/{autor}")
	public ResponseEntity<List<Livro>> buscarLivrosPorAutor(@PathVariable String autor) {
		List<Livro> livrosAutor = livroService.buscarLivrosPorAutor(autor);
		
		if (livrosAutor.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(livrosAutor);
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Livro>> buscarLivrosPorTitulo(@PathVariable String titulo) {
		List<Livro> livrosTitulo = livroService.buscarLivrosPorTitulo(titulo);
		
		if (livrosTitulo.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(livrosTitulo);
	}
}
