package io.github.euristenede.projetoathenas.service;

import io.github.euristenede.projetoathenas.model.Pessoa;
import io.github.euristenede.projetoathenas.model.dto.PessoaCadastroDTO;
import io.github.euristenede.projetoathenas.repository.PessoaRepository;
import io.github.euristenede.projetoathenas.utils.PessoaMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Euristenede Santos
 */
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa criarPessoa(PessoaCadastroDTO pessoaCadastroDTO) {
        return pessoaRepository.save(PessoaMapper.converterPessoaDTOparaPessoa(pessoaCadastroDTO));
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPorId(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        return pessoaOptional.orElse(null);
    }
    
    public Double calcularPesoIdeal(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        Pessoa pessoa = pessoaOptional.orElse(null);
        return pessoa.calcularPesoIdeal();
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

}
