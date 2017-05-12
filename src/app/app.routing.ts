import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {AuthAdminGuard} from './guards/auth-admin.guards';

import {PanelHome} from './components/panels/home/panel-home.component';
import {PanelContact} from './components/panels/contact/panel-contact.component';
import {PanelItems} from './components/panels/items/panel-items.component';
import {AbstractPanelItem} from './components/panels/items/item/panel-abstract-item.component';
import {AbstractPanelEditItem} from './components/panels/items/item/panel-abstract-edit-item.component';
import {PanelAdmin} from './components/panels/admin/panel-admin.component';

const appRoutes : Routes = [
      { path: '', component: PanelHome },
      { path: 'home', component: PanelHome },
      { path: 'show/:code', component: PanelItems },
      { path: 'get/:id', component: AbstractPanelItem },
      { path: 'edit/:id', component: AbstractPanelEditItem },
      { path: 'contact', component: PanelContact },
      { path: 'admin', component: PanelAdmin, canActivate:[AuthAdminGuard] },
      { path: '**', redirectTo: 'home'}
    ];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
