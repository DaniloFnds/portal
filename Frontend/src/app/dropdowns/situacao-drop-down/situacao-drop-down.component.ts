import { Component, OnInit } from '@angular/core';
import {DropDownService} from "../drop-down.service";
import {SelectItem} from "../../models/select-item";

@Component({
  selector: 'situacao-drop-down',
  templateUrl: './situacao-drop-down.component.html',
  styleUrls: ['./situacao-drop-down.component.scss']
})
export class SituacaoDropDownComponent implements OnInit {
  situacaoOperacao?: number;
  situacoesOperacao: SelectItem[] = [];

  constructor(private _dropDownService: DropDownService) { }

  ngOnInit(): void {
    this.situacoesOperacao = this._dropDownService.getSituacaoOperacoes();
  }

}
