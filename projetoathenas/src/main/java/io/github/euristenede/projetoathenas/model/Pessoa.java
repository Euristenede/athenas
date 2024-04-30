package io.github.euristenede.projetoathenas.model;

import io.github.euristenede.projetoathenas.model.dto.PessoaCadastroDTO;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Euristenede Santos
 */
@Entity
@Getter
@Setter
@Table(name = "TB_PESSOA")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private Long id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private Date dataNascimento;
    
    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;
    
    @Column(name = "SEXO", length = 1, nullable = false)
    private char sexo;
    
    @Column(name = "ALTURA", nullable = false)
    private Double altura;
    
    @Column(name = "PESO", nullable = false)
    private Double peso;
    
    public void create(PessoaCadastroDTO pessoaCadastroDTO){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaCadastroDTO.getId());
        pessoa.setNome(pessoaCadastroDTO.getNome());
        pessoa.setDataNascimento(pessoaCadastroDTO.getDataNascimento());
        pessoa.setCpf(pessoaCadastroDTO.getCpf());
        pessoa.setSexo(pessoaCadastroDTO.getSexo());
        pessoa.setAltura(pessoaCadastroDTO.getAltura());
        pessoa.setPeso(pessoaCadastroDTO.getPeso());
    }
    
    public Double calcularPesoIdeal(){
        switch (this.sexo) {
            case 'M':
                return calcularPesoIdealMasculino(this.altura);
            case 'F':
                return calcularPesoIdealFeminino(this.altura);
            default:
                return 0d;
        }
    }
    
    private double calcularPesoIdealMasculino(Double altura){
        return Math.round((72.7 * altura) - 58);
    }
    
    private double calcularPesoIdealFeminino(Double altura){
        return Math.round((62.1 * altura) - 44.7);
    }
}
