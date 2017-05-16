import { Component } from '@angular/core';
import { Auth } from '../../services/auth.service';

@Component({
  selector: 'app-user-connexion',
  templateUrl: './user-connexion.component.html',
  styleUrls: ['./user-connexion.component.css']
})
export class UserConnexionComponent {

  constructor(protected auth: Auth) { }

  public getUserLetter(): string {
    return this.auth.getUserName().substring(0, 1).toUpperCase();
  }
}
