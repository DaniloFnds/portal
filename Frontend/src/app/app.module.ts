import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {MenuModule} from "./menu/menu.module";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from "./app-routing.module";
import {NZ_I18N, pt_BR} from 'ng-zorro-antd/i18n';
import {registerLocaleData} from '@angular/common';
import pt from '@angular/common/locales/pt';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {IconsProviderModule} from './icons-provider.module';
import {NzLayoutModule} from 'ng-zorro-antd/layout';
import {NzMenuModule} from 'ng-zorro-antd/menu';
import {ContentModule} from "./content/content.module";
import {DropdownModule} from "./dropdowns/dropdown.module";

registerLocaleData(pt);

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    IconsProviderModule,
    NzLayoutModule,
    NzMenuModule,
    MenuModule,
    ContentModule,
    DropdownModule
  ],
  providers: [{ provide: NZ_I18N, useValue: pt_BR }],
  bootstrap: [AppComponent ]
})
export class AppModule { }
