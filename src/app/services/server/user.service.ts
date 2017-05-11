import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions } from '@angular/http';
import { User } from '../../model/user';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

    private usersUrl = 'http://localhost:8080/api/user';

    constructor( private http: Http ) { }

    authenticate(login:string, password:string): Observable<User> {
        return this.http.post(this.usersUrl,JSON.stringify({username: login, password: password})).map(
                    (res) => res.json().data as User,
                    (error) => this.handleError
                    );
    }

    private handleError( error: any ): Promise<any> {
        console.error( 'Une erreur est survenue', error );
        return Promise.reject( error.message || error );
    }
}