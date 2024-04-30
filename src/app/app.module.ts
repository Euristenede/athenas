import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PessoaListComponent } from './components/pessoa-list/pessoa-list.component';
import { AddPessoaComponent } from './components/add-pessoa/add-pessoa.component';

@NgModule({
  declarations: [
    AppComponent,
    PessoaListComponent,
    AddPessoaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
