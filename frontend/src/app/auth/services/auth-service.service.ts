import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { Injectable } from '@angular/core';
import { Task, User } from 'src/app/shared';

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

  taskList!: Task[];
  currentlyUser: string = "";

  constructor(
    private httpClient: HttpClient
  ) { }

  public setCurrentlyUser(user: User): void {
    localStorage[this.currentlyUser] = JSON.stringify(user);
  }

  public getCurrentlyUser(): User {
    let user = localStorage[this.currentlyUser];
    return (user ? JSON.parse(localStorage[this.currentlyUser]) : null);
  }

  logout(): void {
    localStorage[this.currentlyUser] = "";
  }

  findAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.BASE_URL, this.httpOptions);
  }

  findById(id: number): Observable<User> {
    return this.httpClient.get<User>(this.BASE_URL + id, this.httpOptions);
  }

  findByEmail(id: number): Observable<User> {
    return this.httpClient.get<User>(this.BASE_URL + 'email/' + id, this.httpOptions);
  }

  login(email: String, password: String): Observable<User> {
    return this.httpClient.get<User>(this.BASE_URL + 'login/' + email + '/' + password, this.httpOptions);
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
