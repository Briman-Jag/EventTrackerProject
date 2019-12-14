import { Injectable } from '@angular/core';
import { MusicFestival } from '../models/musicfestival';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MusicfestService {

  constructor(private http: HttpClient) { }

  // Fields
  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/musicfestivals';

  index() {
    return this.http.get<MusicFestival[]>(this.url + '?sorted=true')
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Uh Oh!');
        })
      );
  }

  public create(musicFest: MusicFestival) {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json'
      }
    };

    return this.http.post<MusicFestival>(this.url, musicFest, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('MusicFestivalService.index(): Error retrieving Music Festival.');
      })
    );
  }

  public update(musicFest: MusicFestival) {

    const httpOptions = {
      headers: {
        'Content-type': 'application/json'
      }
    };

    return this.http.put(`${this.url}/${musicFest.id}`, musicFest, httpOptions).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError('MusicFestivalService.index(): Error retrieving MusicFestival.');
      })
    );
  }

  public delete(id: number) {

    return  this.http.delete(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('MusicFestivalService.index(): Error deleting Music Festival.');
      })
    );

  }

}



