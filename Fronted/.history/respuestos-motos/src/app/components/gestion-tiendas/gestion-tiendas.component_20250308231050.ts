import { Component } from '@angular/core';
interface Product {
  code: string;
  name: string;
  category: string;
  quantity: number;
}


@Component({
  selector: 'app-gestion-tiendas',
  templateUrl: './gestion-tiendas.component.html',
  styleUrls: ['./gestion-tiendas.component.css']
})
export class GestionTiendasComponent {

}
