package dev.rafael.springboot_para_iniciantes.Controller;

import dev.rafael.springboot_para_iniciantes.Exceptions.RecursoNaoEncontradoException;
import dev.rafael.springboot_para_iniciantes.Model.Produto;
import dev.rafael.springboot_para_iniciantes.Service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public List<Produto> listarProdutos(){
		return produtoService.listarProdutos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProduto(@PathVariable Long id){
		Produto produto = produtoService.buscarPorId(id);
		return ResponseEntity.ok(produto);

	}

	@PostMapping
	public Produto criarProduto (@RequestBody Produto produto){
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarProduto(@PathVariable Long id){
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
}
