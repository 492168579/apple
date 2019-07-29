import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Login} from './login';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loginUrl = 'assets/config.json';
  
  constructor(private http: HttpClient) { 

  }

}
