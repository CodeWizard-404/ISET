export class Product {
    private id!: number;
    private libelle!: String;
    private prix!: number;

    constructor(id: number, libelle: String,prix:number){
        this.id = id;
        this.libelle= libelle;
        this.prix=prix;
    }
}
