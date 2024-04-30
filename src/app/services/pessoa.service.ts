import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pessoa } from '../models/pessoa.model';

const baseUrl = 'http://localhost:9090/api/pessoa/';

@Injectable({
  providedIn: 'root',
})
export class PessoaService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(baseUrl);
  }

  get(id: any): Observable<Pessoa> {
    return this.http.get<Pessoa>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    console.log(data);
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  deleteById(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}${id}`);
  }

  findById(id: any): Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(`${baseUrl}?id=${id}`);
  }

  findPesoByIdPessoa(id: any): Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(`${baseUrl}peso/${id}`);
  }
}
