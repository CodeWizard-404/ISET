export class Tableau {
  public name: string = "";
  public picture: string = "";
  public painter: string = "";
  public price: number = 0;
  public genre: string = "";
  constructor(
    name: string,
    picture: string,
    painter: string,
    price: number,
    genre: string
  ) {
    this.name = name;
    this.picture = picture;
    this.painter = painter;
    this.price = price;
    this.genre = genre;
  }
}
