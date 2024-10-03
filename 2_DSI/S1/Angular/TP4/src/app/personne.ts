export class Personne {
    public nom: string="nom";
    public age: number=0;
    public isEtudiant: boolean = false;

    constructor(nom: string, age: number,isEtudiant: boolean = false) {
        this.nom = nom;
        this.age = age;
        this.isEtudiant = isEtudiant;
    }
}
