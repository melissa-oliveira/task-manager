import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { Task } from 'src/app/shared';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  BASE_URL = "http://localhost:8080/task/";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  findAll(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.BASE_URL, this.httpOptions);
  }

  findById(id: number): Observable<Task> {
    return this.httpClient.get<Task>(this.BASE_URL + id, this.httpOptions);
  }

  insert(task: Task): Observable<Task> {
    return this.httpClient.post<Task>(this.BASE_URL, JSON.stringify(task), this.httpOptions);
  }

  delete(id: number): Observable<Task> {
    return this.httpClient.delete<Task>(this.BASE_URL + id, this.httpOptions);
  }

  update(task: Task): Observable<Task> {
    return this.httpClient.put<Task>(this.BASE_URL, JSON.stringify(task), this.httpOptions);
  }
}
