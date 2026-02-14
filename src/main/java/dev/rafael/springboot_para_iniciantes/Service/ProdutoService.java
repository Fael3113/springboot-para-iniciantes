package dev.rafael.springboot_para_iniciantes.Service;

import dev.rafael.springboot_para_iniciantes.Exceptions.RecursoNaoEncontradoException;
import dev.rafael.springboot_para_iniciantes.Model.Produto;
import dev.rafael.springboot_para_iniciantes.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Long id){
		return produtoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado"));
	}

	public Produto salvarProduto(Produto produto){
		return produtoRepository.save(produto);
	}

	public void deletarProduto(Long id){
		if (!produtoRepository.existsById(id)){
			throw  new RecursoNaoEncontradoException(("Produto com id "+id+" não encontrado"));
		}
		produtoRepository.deleteById(id);
	}
}
