import { Injectable } from '@angular/core';
import { Subject }    from 'rxjs/Subject';

import { User } from '../../model/user';

@Injectable()
export class UserFormService {

    private userConnexion = new Subject<User>();
    private userDisconnexion = new Subject<void>();

    userConnexionEvent$ = this.userConnexion.asObservable();
    userDisconnexionEvent$ = this.userDisconnexion.asObservable();

    connect(user: User) {
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.userConnexion.next(user);
    }

    disconnect() {
        localStorage.removeItem('currentUser');
        this.userDisconnexion.next();
    }
}