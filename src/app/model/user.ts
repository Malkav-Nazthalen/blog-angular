import {EnumUserRole} from './enum-user-role';

export class User {
    login: string;
    password: string;
    role:string;

    constructor(login:string, password:string, role:string)
    {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    isAdmin():boolean{
        return true;
        // return this.role == EnumUserRole.ADMIN;
    }
}