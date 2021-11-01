import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.scss']
})
export class MainMenuComponent implements OnInit {
  menus = [
    {
      level: 1,
      title: 'Liquidação',
      icon: 'bank',
      open: true,
      selected: false,
      disabled: false,
      children: [
        {
          level: 2,
          title: 'Aprovar Liquidação',
          icon: null,
          open: false,
          selected: false,
          disabled: false,
          url:'/liquidacao'
        },
      ]
    },
    {
      level: 1,
      title: 'Cadastros',
      icon: 'profile',
      open: false,
      selected: false,
      disabled: false,
      children: [
        {
          level: 2,
          title: 'Cedente',
          icon: null,
          selected: false,
          disabled: false,
          url:'/cedente'
        },
        {
          level: 2,
          title: 'Sacado',
          icon: null,
          selected: false,
          disabled: false,
          url:'/sacado'
        }
      ]
    }
  ];

  constructor() {

  }

  ngOnInit(): void {

  }

}
