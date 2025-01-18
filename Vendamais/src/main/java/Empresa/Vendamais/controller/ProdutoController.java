package Empresa.Vendamais.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Empresa.Vendamais.entity.Produto;
import Empresa.Vendamais.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> findall(){
        List<Produto> produtos = produtoService.findall();
        return ResponseEntity.ok().body(produtos);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto  = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Produto> insertNew(@RequestBody Produto produto){
        Produto produtoInserido = produtoService.insertNew(produto);
        return ResponseEntity.ok().body(produtoInserido);
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produtoAlterado ){
        Produto produto = produtoService.update(id, produtoAlterado);
        return ResponseEntity.ok().body(produto);
    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = produtoService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
