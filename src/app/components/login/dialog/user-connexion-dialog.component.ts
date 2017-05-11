import { Component } from '@angular/core';
import { MdDialogRef } from '@angular/material';
import { User } from '../../../model/user';

import { UserService } from '../../../services/server/user.service';
import { UserFormService } from '../../../services/client/user.form.service';

@Component({
  selector: 'user-connexion-dialog',
  templateUrl: './user-connexion-dialog.component.html'
})
export class UserConnexionDialog {

  private login : string;
  private password : string;
  private errorMessage: string = "";

   constructor(public dialogRef: MdDialogRef<UserConnexionDialog>, private userService: UserService, private userFormService: UserFormService) {}

   authenticate():void{
      this.userService.authenticate(this.login, this.password).subscribe(
          user => {
            this.userFormService.connect(user);
            this.dialogRef.close();
          },
          error => this.showErrorMessage(error));
   }

   showErrorMessage(reason : any):void{
     this.errorMessage = reason;
   }

}
