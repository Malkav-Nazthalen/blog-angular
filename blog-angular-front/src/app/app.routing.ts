import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthAdminGuard } from './guards/auth-admin.guards';

import { PanelHomeComponent } from './components/panels/home/panel-home.component';
import { PanelContactComponent } from './components/panels/contact/panel-contact.component';
import { PanelItemsComponent } from './components/panels/items/panel-items.component';
import { AbstractPanelItemComponent } from './components/panels/items/item/panel-abstract-item.component';
import { AbstractPanelEditItemComponent } from './components/panels/items/item/panel-abstract-edit-item.component';
import { PanelAdminComponent } from './components/panels/admin/panel-admin.component';

const appRoutes: Routes = [
  { path: '', component: PanelHomeComponent },
  { path: 'home', component: PanelHomeComponent },
  { path: 'show/:code', component: PanelItemsComponent },
  { path: 'get/:id', component: AbstractPanelItemComponent },
  { path: 'edit/:id', component: AbstractPanelEditItemComponent },
  { path: 'contact', component: PanelContactComponent },
  { path: 'admin', component: PanelAdminComponent, canActivate: [AuthAdminGuard] },
  { path: '**', redirectTo: 'home' }
];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
