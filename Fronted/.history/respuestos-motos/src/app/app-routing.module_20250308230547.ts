import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GestionTiendasComponent } from './components/gestion-tiendas/gestion-tiendas.component';
import { PaginaPrincipalComponent } from './pages/pagina-principal/pagina-principal.component';
import { GestionInventariosComponent } from './components/gestion-inventarios/gestion-inventarios.component';

const routes: Routes = [
  { path: '', component: PaginaPrincipalComponent },
  { path: 'inventario', component: GestionInventariosComponent },
  { path: 'tiendas', component: GestionTiendasComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
