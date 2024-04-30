import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PessoaListComponent } from './components/pessoa-list/pessoa-list.component';
import { AddPessoaComponent } from './components/add-pessoa/add-pessoa.component';

const routes: Routes = [
  { path: '', redirectTo: 'tutorials', pathMatch: 'full' },
  { path: 'pessoas', component: PessoaListComponent },
  { path: 'add', component: AddPessoaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
