import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ActivatedRouteSnapshot, RouterState, RouterStateSnapshot } from "@angular/router";
import { LoginService } from "./login.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {
  public user: any = {};
  public error: Error;

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public loginService: LoginService
  ) {
    console.log(this.loginService);
  }
  ngOnInit() {
    let activatedRouteSnapshot: ActivatedRouteSnapshot = this.activatedRoute.snapshot;
    let routerState: RouterState = this.router.routerState;
    let routerStateSnapshot: RouterStateSnapshot = routerState.snapshot;
  }
  public doLogin(): void {
    console.log(this.user);
  }




}
