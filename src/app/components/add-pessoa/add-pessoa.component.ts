import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../../models/pessoa.model';
import { PessoaService } from '../../services/pessoa.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-pessoa',
  templateUrl: './add-pessoa.component.html',
  styleUrl: './add-pessoa.component.css'
})
export class AddPessoaComponent implements OnInit{
  pessoa: Pessoa = {
    nome: '',
    cpf: '',
    dataNascimento: '',
    sexo: '',
    peso: null,
    altura: null
  };
  submitted = false;

  constructor(private route: ActivatedRoute, private pessoaService: PessoaService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.pessoa = {
        id: params['id'],
        nome: params['nome'],
        cpf: params['cpf'],
        dataNascimento: params['dataNascimento'],
        sexo: params['sexo'],
        peso: params['peso'],
        altura: params['altura']
      };
    });
  }

  savePessoa(): void {
    const data = {
      id: this.pessoa.id,
      nome: this.pessoa.nome,
      cpf: this.pessoa.cpf,
      dataNascimento: this.pessoa.dataNascimento,
      sexo: this.pessoa.sexo,
      peso: this.pessoa.peso,
      altura: this.pessoa.altura
    };

    this.pessoaService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
  }

  newPessoa(): void {
    this.submitted = false;
    this.pessoa = {
      nome: '',
      cpf: '',
      dataNascimento: '',
      sexo: '',
      peso: null,
      altura: null
    };
  }
}
