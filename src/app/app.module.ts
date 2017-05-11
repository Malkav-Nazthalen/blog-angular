import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
// import {AUTH_PROVIDERS} from 'angular2-jwt';
import {Auth} from './services/client/auth.service';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule, JsonpModule} from '@angular/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from '@angular/material';

import {routing,appRoutingProviders} from './app.routing';
import {AuthGuard} from './guards/auth.guards';

import {AppComponent} from './app.component';

import {Bandeau} from './components/bandeau/bandeau.component';
import {UserConnexion} from './components/login/user-connexion.component';
import {Menu} from './components/menu/menu.component';
import {TextEditor} from './components/text-editor/text-editor.component';
import {PanelHome} from './components/panels/home/panel-home.component';
import {PanelContact} from './components/panels/contact/panel-contact.component';

import {PanelItems} from './components/panels/items/panel-items.component';
import {AbstractPanelItem} from './components/panels/items/item/panel-abstract-item.component';
import {AbstractPanelEditItem} from './components/panels/items/item/panel-abstract-edit-item.component';
import {PanelAdmin} from './components/panels/admin/panel-admin.component';

import {UserService} from './services/server/user.service';
import {ItemService} from './services/server/item.service';
import {CategoryService} from './services/server/category.service';
import {UserFormService} from './services/client/user.form.service';

@NgModule({
  declarations: [
    AppComponent,
    Bandeau,
    UserConnexion,
    Menu,
    TextEditor,
    PanelHome,
    PanelContact,
    PanelAdmin,
    PanelItems,
    AbstractPanelItem,
    AbstractPanelEditItem
  ],
  entryComponents:[],
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
  providers: [AuthGuard,UserService,UserFormService,ItemService,CategoryService,appRoutingProviders,Auth],
  bootstrap: [AppComponent]
})
export class AppModule {
}
