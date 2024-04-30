import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../../models/pessoa.model';
import { PessoaService } from '../../services/pessoa.service';

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css'],
})
export class PessoaListComponent implements OnInit {
  pessoas?: Pessoa[];
  currentPessoa: Pessoa = {};
  currentIndex = -1;
  inputSearch = '';

  constructor(private pessoaService: PessoaService) {}

  ngOnInit(): void {
    this.listarPessoas();
  }

  listarPessoas(): void {
    this.pessoaService.getAll().subscribe({
      next: (data) => {
        this.pessoas = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.listarPessoas();
    this.currentPessoa = {};
    this.currentIndex = -1;
  }

  setActivePessoa(pessoa: Pessoa, index: number): void {
    this.currentPessoa = pessoa;
    this.currentIndex = index;
  }

  deleteById(id: any): void {
    this.pessoaService.deleteById(id).subscribe({
      next: (res) => {
        console.log(res);
        this.refreshList();
      },
      error: (e) => console.error(e)
    });
  }

  findPesoByIdPessoa(id: any): void {
    this.pessoaService.findPesoByIdPessoa(id).subscribe({
      next: (res) => {
        console.log(res);
        alert('Seu peso ideal é: ' + res + ' kg');
        this.refreshList();
      },
      error: (e) => console.error(e)
    });
  }

}
