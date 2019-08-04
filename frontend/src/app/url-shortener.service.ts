import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UrlShortenerService {

  private baseUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getShortUrlList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getShortUrlDetails(code: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${code}/statistics`);
  }

}
