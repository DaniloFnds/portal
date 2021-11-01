import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LiquidacaoRoutingModule} from "./liquidacao.routing.module";
import {ConsultaLiquidacaoComponent} from "./consulta/consulta-liquidacao/consulta-liquidacao.component";
import {DropdownModule} from "../dropdowns/dropdown.module";
import {NzDatePickerModule} from "ng-zorro-antd/date-picker";
import {FormsModule} from "@angular/forms";
import {NzFormModule} from "ng-zorro-antd/form";
import {NzButtonModule} from "ng-zorro-antd/button";
import {NzTableModule} from "ng-zorro-antd/table";
import {NzDividerModule} from "ng-zorro-antd/divider";
import {ContentModule} from "../content/content.module";
import {NzIconModule} from "ng-zorro-antd/icon";
import {AprovarLiquidacaoComponent} from "./aprovar-liquidacao/aprovar-liquidacao.component";


@NgModule({
  declarations: [
    ConsultaLiquidacaoComponent,
    AprovarLiquidacaoComponent
  ],
  imports: [
    CommonModule,
    LiquidacaoRoutingModule,
    DropdownModule,
    NzDatePickerModule,
    FormsModule,
    NzFormModule,
    NzButtonModule,
    NzTableModule,
    NzDividerModule,
    ContentModule,
    NzIconModule
  ]
})
export class LiquidacaoModule {
}
