import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GestionInventariosComponent } from './components/gestion-inventarios/gestion-inventarios.component';
import { GestionTiendasComponent } from './components/gestion-tiendas/gestion-tiendas.component';
import { PaginaPrincipalComponent } from './pages/pagina-principal/pagina-principal.component';

import { TableModule } from 'primeng/table';


@NgModule({
  declarations: [
    AppComponent,
    GestionInventariosComponent,
    GestionTiendasComponent,
    PaginaPrincipalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
