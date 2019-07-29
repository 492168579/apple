import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { User } from './user';
import { HttpErrorHandler, HandleError } from '../http-error-handler.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {
  heroesUrl = 'http://localhost:8088/list';  // URL to web api
  private handleError: HandleError;
   constructor(
     private http: HttpClient,
     private httpErrorHandler: HttpErrorHandler
    ) {
      this.handleError = httpErrorHandler.createHandleError('UserService');
     }

  getUsers (): Observable<User[]> {
    return this.http.get<User[]>(this.heroesUrl,httpOptions)
      .pipe(
        catchError(this.handleError('getUsers', []))
      );
  }
}
