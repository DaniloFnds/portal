import {Injectable} from '@angular/core';
import {SelectItem} from "../models/select-item";

@Injectable({
  providedIn: 'root'
})
export class DropDownService {

  constructor() { }


  getFundos(): SelectItem[] {
    return [
      new SelectItem(1, "FUNDO ssssssssssssssssssssssssssss1"),
      new SelectItem(2, "FUNDO 2"),
      new SelectItem(3, "FUNDO 3"),
    ];
  }


  getSituacaoOperacoes(): SelectItem[] {
    return [
      new SelectItem('PO', 'Aguardando Aprovação da Consultoria'),
      new SelectItem('PG', 'Aguardando Aprovação do Gestor'),
      new SelectItem('TE', 'Transferencia eletronica efetivada')
    ]
  }
}
