import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FundoDropDownComponent} from "./fundo-drop-down/fundo-drop-down.component";
import {NzSelectModule} from "ng-zorro-antd/select";
import {FormsModule} from "@angular/forms";
import { SituacaoDropDownComponent } from './situacao-drop-down/situacao-drop-down.component';


@NgModule({
  declarations: [
    FundoDropDownComponent,
    SituacaoDropDownComponent
  ],
  exports: [
    FundoDropDownComponent,
    SituacaoDropDownComponent
  ],
  imports: [
    CommonModule,
    NzSelectModule,
    FormsModule
  ]
})
export class DropdownModule {
}
