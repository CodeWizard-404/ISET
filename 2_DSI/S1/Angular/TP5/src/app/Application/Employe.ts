export class Employe {
    public matricule:number=0;
    public nom:string="";
    public post:string="";
    constructor(matricule:number, nom:string,post:string) {
        this.matricule = matricule;
        this.nom = nom;
        this.post=post;
    }
}
