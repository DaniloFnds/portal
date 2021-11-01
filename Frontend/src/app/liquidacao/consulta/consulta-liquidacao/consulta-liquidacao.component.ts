import {Component, OnChanges, OnInit} from '@angular/core';
import {OperacaoRecebivelDto} from "../../../models/operacao-recebivel-dto";
import { v4 as uuidv4 } from 'uuid';
import {LiquidacaoService} from "../../liquidacao.service";

@Component({
  selector: 'consulta-liquidacao',
  templateUrl: './consulta-liquidacao.component.html',
  styleUrls: ['./consulta-liquidacao.component.scss']
})
export class ConsultaLiquidacaoComponent implements OnInit, OnChanges {
  dtFormat: string = 'dd/MM/yyyy'
  dataSelecionada!: Date

  breadcrumb = [
    {
      name: 'Liquidacao'
    },
    {
      name: 'Aprovar Liquidação'
    }
  ]

  operacoes: OperacaoRecebivelDto[] = [];

  constructor(private _liquidacaoService: LiquidacaoService) { }

  ngOnInit(): void {
    this.dataSelecionada = new Date(Date.now())
    this._liquidacaoService.encontraTodasOperacoes().subscribe(console.log)

  }

  ngOnChanges(): void {

    console.log(this.dataSelecionada)
  }

  submitForm($event: any) {
    console.log(this.dataSelecionada)
  }
}
