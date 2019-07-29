import { Component, OnInit } from '@angular/core';
import {UserService} from './user.service'
import { User } from './user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  providers: [ UserService ],
  styleUrls: ['./user.component.less']
})
export class UserComponent implements OnInit {
  users: User[];
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }
  getUsers(){
    this.userService.getUsers()
        .subscribe(users => this.users = users);

  }
}
