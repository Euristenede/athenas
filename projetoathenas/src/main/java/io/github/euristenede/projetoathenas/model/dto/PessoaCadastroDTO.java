package io.github.euristenede.projetoathenas.model.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Euristenede Santos
 */
@Getter
@Setter
public class PessoaCadastroDTO {

    private Long id;
    
    private String nome;

    private Date dataNascimento;

    private String cpf;

    private char sexo;

    private Double altura;

    private Double peso;
}
