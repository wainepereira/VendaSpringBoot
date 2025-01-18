package Empresa.Vendamais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Empresa.Vendamais.entity.Produto;
import Empresa.Vendamais.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findall(){
        return produtoRepository.findAll();
    }
    //Mostrar um produto pelo ID

    public Produto findById(long id){
        return produtoRepository.findById(id).orElse(null);
    }

    //cadastrar novo produto
    public Produto insertNew(Produto produdo){
        return produtoRepository.save(produdo);
    }
    //altera um produto
    public Produto update(long id, Produto produtoAlerado){
        Produto produtoAtual = findById(id);
        produtoAtual.setNome(produtoAlerado.getNome());
        produtoAtual.setQuantidade(produtoAlerado.getQuantidade());
        produtoAtual.setDescricao(produtoAlerado.getDescricao());
        return produtoRepository.save(produtoAtual);
    }
    //Deletar Produto do  cadastro
    public  Boolean deleteById(long id){
        Produto produto = findById(id);
        if (produto == null) {
            return false;
            
        } else{

            produtoRepository.deleteById(id);
            return true;
        }
    }
}
