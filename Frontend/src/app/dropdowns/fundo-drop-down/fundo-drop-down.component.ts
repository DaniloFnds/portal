import {Component, Input, OnInit} from '@angular/core';
import {SelectItem} from "../../models/select-item";
import {DropDownService} from "../drop-down.service";

@Component({
  selector: 'fundo-drop-down',
  templateUrl: './fundo-drop-down.component.html',
  styleUrls: ['./fundo-drop-down.component.scss']
})
export class FundoDropDownComponent implements OnInit {

  fundoSelecionado!: SelectItem;
  fundos!: SelectItem[]
  @Input() isObrigatorio!: boolean;

  constructor(private _dropDownService: DropDownService) {
  }

  ngOnInit(): void {
    this.fundos = this._dropDownService.getFundos();
  }

}
