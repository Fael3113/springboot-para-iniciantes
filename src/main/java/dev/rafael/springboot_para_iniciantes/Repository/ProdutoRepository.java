package dev.rafael.springboot_para_iniciantes.Repository;

import dev.rafael.springboot_para_iniciantes.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
