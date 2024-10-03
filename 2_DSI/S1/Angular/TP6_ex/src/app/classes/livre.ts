export class Livre {
    public id!:number;
    public titre!:string;
    public auteur!:string;
    public categorie!:string;
    public prix!:number;
    public nouveau!:boolean;

    constructor(id:number, titre:string, auteur:string, categorie:string, prix:number,nouveau:boolean){
        this.id = id;
        this.titre = titre;
        this.auteur =auteur;
        this.categorie=categorie;
        this.prix=prix;
        this.nouveau=nouveau;
    }

}
