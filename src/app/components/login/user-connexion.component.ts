import { Component } from '@angular/core';
import { Auth } from '../../services/client/auth.service';

@Component( {
    selector: 'user-connexion',
    templateUrl: './user-connexion.component.html',
    styleUrls: ['./user-connexion.component.css']
} )
export class UserConnexion{

  constructor(private auth : Auth) {}

}
