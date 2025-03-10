import { Component } from '@angular/core';



products: Product[] = [
  {
    code: 'P001',
    name: 'Cadena de transmisión',
    category: 'Transmisión',
    quantity: 45
  },
  {
    code: 'P002',
    name: 'Pastillas de freno',
    category: 'Frenos',
    quantity: 32
  },
  {
    code: 'P003',
    name: 'Filtro de aceite',
    category: 'Motor',
    quantity: 60
  },
  {
    code: 'P004',
    name: 'Bujía',
    category: 'Encendido',
    quantity: 78
  },
  {
    code: 'P005',
    name: 'Amortiguador',
    category: 'Suspensión',
    quantity: 15
  }
];
@Component({
  selector: 'app-gestion-tiendas',
  templateUrl: './gestion-tiendas.component.html',
  styleUrls: ['./gestion-tiendas.component.css']
})
export class GestionTiendasComponent {

}
