import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { Injectable } from '@angular/core';
import { TaskCategory } from 'src/app/shared';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  BASE_URL = "http://localhost:8080/taskCategory/";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  findAll(): Observable<TaskCategory[]> {
    return this.httpClient.get<TaskCategory[]>(this.BASE_URL, this.httpOptions);
  }

  findById(id: number): Observable<TaskCategory> {
    return this.httpClient.get<TaskCategory>(this.BASE_URL + id, this.httpOptions);
  }

  insert(taskCateTaskCategory: TaskCategory): Observable<TaskCategory> {
    return this.httpClient.post<TaskCategory>(this.BASE_URL, JSON.stringify(taskCateTaskCategory), this.httpOptions);
  }

  delete(id: number): Observable<TaskCategory> {
    return this.httpClient.delete<TaskCategory>(this.BASE_URL + id, this.httpOptions);
  }

  update(taskCateTaskCategory: TaskCategory): Observable<TaskCategory> {
    return this.httpClient.put<TaskCategory>(this.BASE_URL, JSON.stringify(taskCateTaskCategory), this.httpOptions);
  }
}
