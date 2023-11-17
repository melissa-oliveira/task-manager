import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { Injectable } from '@angular/core';
import { User } from 'src/app/shared';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  BASE_URL = "http://localhost:8080/user/";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  findAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.BASE_URL, this.httpOptions);
  }

  findById(id: number): Observable<User> {
    return this.httpClient.get<User>(this.BASE_URL + id, this.httpOptions);
  }

  insert(user: User): Observable<User> {
    return this.httpClient.post<User>(this.BASE_URL, JSON.stringify(user), this.httpOptions);
  }

  delete(id: number): Observable<User> {
    return this.httpClient.delete<User>(this.BASE_URL + id, this.httpOptions);
  }

  update(user: User): Observable<User> {
    return this.httpClient.put<User>(this.BASE_URL, JSON.stringify(user), this.httpOptions);
  }
}
