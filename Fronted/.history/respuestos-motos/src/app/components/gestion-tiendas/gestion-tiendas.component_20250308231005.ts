import { Component } from '@angular/core';

@Component({
  selector: 'app-gestion-tiendas',
  templateUrl: './gestion-tiendas.component.html',
  styleUrls: ['./gestion-tiendas.component.css']
})


interface Product {
  code: string;
  name: string;
  category: string;
  quantity: number;
}


export class GestionTiendasComponent {

}
