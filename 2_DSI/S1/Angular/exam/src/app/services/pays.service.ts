import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Continent } from '../entities/continent';
import { Pays } from '../entities/pays';


@Injectable({
  providedIn: 'root',
})
export class PaysService {
  private apiUrl = 'http://localhost:3000/pays';
  constructor(private http: HttpClient) {}

  getPays(): Observable<Pays[]> {
    return this.http.get<Pays[]>(this.apiUrl);
  }

  getPaysByContinent(continent: Continent): Observable<Pays[]> {
    return this.http.get<Pays[]>(`${this.apiUrl}?continent=${continent}`);
  }

  updatePays(id: number, pays: Pays): Observable<Pays> {

    return this.http.put<Pays>(`${this.apiUrl}/${id}`, pays);
  }

  getPaysById(id: number): Observable<Pays> {

    return this.http.get<Pays>(`${this.apiUrl}/${id}`);
  }
}



  

