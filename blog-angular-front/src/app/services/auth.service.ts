import { Injectable } from '@angular/core';
import { tokenNotExpired } from 'angular2-jwt';
import { myConfig } from './auth.config';
import { EnumUserRole } from '../model/enum-user-role';
import { User } from '../model/user';

// Avoid name not found warnings
declare var Auth0Lock: any;

@Injectable()
export class Auth {

  lock = new Auth0Lock(myConfig.clientID, myConfig.domain, {});

  constructor() {
    this.lock.on('authenticated', (authResult) => {
      this.lock.getUserInfo(authResult.accessToken, function(error, profile) {
        if (error) {
          // TODO : Handle error.
          return;
        }
        const user: User = new User(JSON.parse(localStorage.getItem('profile')).name,
          EnumUserRole[EnumUserRole[JSON.parse(localStorage.getItem('profile')).app_metadata.profile]],
          authResult.idToken);
        localStorage.setItem('user', JSON.stringify(user));
        localStorage.setItem('id_token', JSON.stringify(user.tokenId));
      });
    });
  }

  public isAdmin(): boolean {
    const user: User = JSON.parse(localStorage.getItem('user'));
    return EnumUserRole[user.role] === EnumUserRole.ADMIN;
  }

  public getUserName(): string {
    return JSON.parse(localStorage.getItem('profile')).name + ' ' + JSON.parse(localStorage.getItem('profile')).app_metadata.profile;
  }

  /**
   * Show the popup for authentication with Auth0.
   */
  public login() {
    this.lock.show();
  }

  /**
   *  Check if there's an unexpired JWT
   */
  public authenticated() {
    return tokenNotExpired('id_token');
  }

  /**
   * Just remove authentication's token from localStorage
   */
  public logout() {
    localStorage.removeItem('id_token');
  }
}
