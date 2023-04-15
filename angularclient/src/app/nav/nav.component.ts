import { Component } from '@angular/core';
import {CustomerService} from "../services/customer.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  model: any = {};
  loggedIn = false;

  constructor(private customerService: CustomerService) {
  }

  login() {
    this.customerService.login(this.model).subscribe({
      next: response => {
        console.log(response);
        this.loggedIn = true;
      },
      error: error => console.log(error)
    })
  }
}
