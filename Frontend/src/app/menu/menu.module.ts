import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from "@angular/platform-browser";
import {MainMenuComponent} from './main-menu/main-menu.component';
import {ProfileMenuComponent} from './profile-menu/profile-menu.component';
import {ProfileMenuAcoesComponent} from './profile-menu/profile-menu-acoes/profile-menu-acoes.component';
import {NzMenuModule} from "ng-zorro-antd/menu";
import {MainMenuHeaderComponent} from './main-menu-header/main-menu-header.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzIconModule} from "ng-zorro-antd/icon";
import {AppRoutingModule} from "../app-routing.module";


@NgModule({
  declarations: [
    MainMenuComponent,
    ProfileMenuComponent,
    ProfileMenuAcoesComponent,
    MainMenuHeaderComponent
  ],
  exports: [
    MainMenuComponent,
    ProfileMenuComponent,
    MainMenuHeaderComponent,
  ],
    imports: [
        CommonModule,
        BrowserModule,
        NzMenuModule,
        NzLayoutModule,
        NzIconModule,
        AppRoutingModule,

    ]
})
export class MenuModule { }
