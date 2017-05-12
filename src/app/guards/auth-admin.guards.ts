import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import {Auth} from '../services/auth.service';

@Injectable()
export class AuthAdminGuard implements CanActivate {

    constructor(private router: Router,
                private auth: Auth) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (this.auth.authenticated() && this.auth.isAdmin()) {
            return true;
        }
        this.router.navigate(['/home'], { queryParams: { returnUrl: state.url }});
        return false;
    }
}