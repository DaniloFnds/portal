import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OperacaoRecebivelDto} from "../models/operacao-recebivel-dto";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LiquidacaoService {

  private readonly API_BASE = 'http://localhost:8080/liquidacao';

  constructor(private http: HttpClient) {
  }

  encontraTodasOperacoes(): Observable<OperacaoRecebivelDto[]> {
    return this.http.get<OperacaoRecebivelDto[]>(this.API_BASE);
  }
}
