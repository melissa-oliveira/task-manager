import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { Injectable } from '@angular/core';
import { TaskState } from 'src/app/shared';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  BASE_URL = "http://localhost:8080/taskState/";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  findAll(): Observable<TaskState[]> {
    return this.httpClient.get<TaskState[]>(this.BASE_URL, this.httpOptions);
  }

  findById(id: number): Observable<TaskState> {
    return this.httpClient.get<TaskState>(this.BASE_URL + id, this.httpOptions);
  }

  insert(taskCateTaskState: TaskState): Observable<TaskState> {
    return this.httpClient.post<TaskState>(this.BASE_URL, JSON.stringify(taskCateTaskState), this.httpOptions);
  }

  delete(id: number): Observable<TaskState> {
    return this.httpClient.delete<TaskState>(this.BASE_URL + id, this.httpOptions);
  }

  update(taskCateTaskState: TaskState): Observable<TaskState> {
    return this.httpClient.put<TaskState>(this.BASE_URL, JSON.stringify(taskCateTaskState), this.httpOptions);
  }
}
