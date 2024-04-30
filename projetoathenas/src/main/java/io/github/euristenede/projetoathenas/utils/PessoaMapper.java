package io.github.euristenede.projetoathenas.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.euristenede.projetoathenas.model.Pessoa;
import io.github.euristenede.projetoathenas.model.dto.PessoaCadastroDTO;

/**
 *
 * @author Euristenede Santos
 */
public class PessoaMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Pessoa converterPessoaDTOparaPessoa(PessoaCadastroDTO pessoaCadastroDTO) {
        return objectMapper.convertValue(pessoaCadastroDTO, Pessoa.class);
    }
}
