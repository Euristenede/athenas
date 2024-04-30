package io.github.euristenede.projetoathenas.controller;

import io.github.euristenede.projetoathenas.model.Pessoa;
import io.github.euristenede.projetoathenas.model.dto.PessoaCadastroDTO;
import io.github.euristenede.projetoathenas.service.PessoaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Euristenede Santos
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaCadastroDTO pessoaCadastroDTO) {
        Pessoa pessoa = pessoaService.criarPessoa(pessoaCadastroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
        if (pessoa != null) {
            return ResponseEntity.ok().body(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/peso/{id}")
    public Double buscarPesoIdeal(@PathVariable Long id) {
        return pessoaService.calcularPesoIdeal(id);
    }
}
