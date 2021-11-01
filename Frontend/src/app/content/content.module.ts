import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ContentHeaderComponent} from './content-header/content-header.component';
import {NzIconModule} from "ng-zorro-antd/icon";
import {NzLayoutModule} from "ng-zorro-antd/layout";
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';
import {NzBreadCrumbModule} from "ng-zorro-antd/breadcrumb";
import {NzDividerModule} from "ng-zorro-antd/divider";


@NgModule({
  declarations: [
    ContentHeaderComponent,
    BreadcrumbComponent
  ],
  exports: [
    ContentHeaderComponent,
    BreadcrumbComponent
  ],
  imports: [
    CommonModule,
    NzIconModule,
    NzLayoutModule,
    NzBreadCrumbModule,
    NzDividerModule
  ]
})
export class ContentModule { }
