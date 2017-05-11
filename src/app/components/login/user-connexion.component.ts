import { Component, OnInit } from '@angular/core';
import { MdDialog,MdDialogRef } from '@angular/material';
import { UserConnexionDialog } from './dialog/user-connexion-dialog.component';

import { UserFormService } from '../../services/client/user.form.service';
import { User } from '../../model/user';
import { EnumUserRole } from '../../model/enum-user-role';

@Component( {
    selector: 'user-connexion',
    templateUrl: './user-connexion.component.html',
    styleUrls: ['./user-connexion.component.css']
} )
export class UserConnexion implements OnInit{

  private user : User;

  constructor(public dialog: MdDialog,
              private userFormService : UserFormService) {
    userFormService.userConnexionEvent$.subscribe(user => this.user = user);
    userFormService.userDisconnexionEvent$.subscribe(none => this.user = null);
  }

  ngOnInit(): void {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if(currentUser != null)
    {
      this.user = new User(currentUser.login, currentUser.password,EnumUserRole[EnumUserRole[currentUser.role]]); 
    }
  }

  openDialog() {
    let dialogRef = this.dialog.open(UserConnexionDialog);
  }

  deconnexion():void {
    this.userFormService.disconnect();
  }
}

