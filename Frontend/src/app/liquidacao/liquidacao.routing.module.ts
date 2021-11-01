import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ConsultaLiquidacaoComponent} from "./consulta/consulta-liquidacao/consulta-liquidacao.component";
import {AprovarLiquidacaoComponent} from "./aprovar-liquidacao/aprovar-liquidacao.component";

const routes: Routes = [
  {path: '', component: ConsultaLiquidacaoComponent},
  {path: 'aprovar/:id', component: AprovarLiquidacaoComponent}
]


@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LiquidacaoRoutingModule {
}
