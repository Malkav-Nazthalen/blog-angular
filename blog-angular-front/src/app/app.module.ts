import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { Auth } from './services/auth.service';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from '@angular/material';

import { routing, appRoutingProviders } from './app.routing';
import { AuthAdminGuard } from './guards/auth-admin.guards';

import { AppComponent } from './app.component';

import { BandeauComponent } from './components/bandeau/bandeau.component';
import { UserConnexionComponent } from './components/login/user-connexion.component';
import { MenuComponent } from './components/menu/menu.component';
import { TextEditorComponent } from './components/text-editor/text-editor.component';
import { PanelHomeComponent } from './components/panels/home/panel-home.component';
import { PanelContactComponent } from './components/panels/contact/panel-contact.component';

import { PanelItemsComponent } from './components/panels/items/panel-items.component';
import { AbstractPanelItemComponent } from './components/panels/items/item/panel-abstract-item.component';
import { AbstractPanelEditItemComponent } from './components/panels/items/item/panel-abstract-edit-item.component';
import { PanelAdminComponent } from './components/panels/admin/panel-admin.component';
import { AdminCategoriesComponent } from './components/panels/admin/categories/admin-categories.component';

import { ItemService } from './services/item.service';
import { CategoryService } from './services/category.service';

@NgModule({
  declarations: [
    AppComponent,
    BandeauComponent,
    UserConnexionComponent,
    MenuComponent,
    TextEditorComponent,
    PanelHomeComponent,
    PanelContactComponent,
    PanelAdminComponent,
    AdminCategoriesComponent,
    PanelItemsComponent,
    AbstractPanelItemComponent,
    AbstractPanelEditItemComponent
  ],
  entryComponents: [],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    ReactiveFormsModule,
    MaterialModule,
    appRoutingProviders,
    routing
  ],
  providers: [AuthAdminGuard, ItemService, CategoryService, appRoutingProviders, Auth],
  bootstrap: [AppComponent]
})
export class AppModule {
}
