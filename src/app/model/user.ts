import {EnumUserRole} from './enum-user-role';

export class User {
    name: string;
    role: string;
    tokenId: string;

    constructor(name:string, role:string, tokenId:string)
    {
        this.name = name;
        this.role = role;
        this.tokenId = tokenId;
    }

    public isAdmin() : boolean {
        return EnumUserRole[this.role] == EnumUserRole.ADMIN;
    }
}