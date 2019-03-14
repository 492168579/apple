import { Injectable } from '@angular/core';
import { Observable, of, throwError, from } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Login } from './login' ;
import { environment } from "@app/env";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const loginUrl = environment.API_URL+"/auth/apple-auth/auth/login/login";
@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  constructor(private http: HttpClient) { }
  /**
   * 根据用户的用户名和密码验证码进行登录
   */
  login (login): Observable<Login> {
    return this.http.post<Login>(loginUrl
      , login, httpOptions).pipe(
      tap((login: Login) => console.log(``)),
      catchError(this.handleError<Login>('login'))
    );
  }
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); 
      return of(result as T);
    };
  }
}



