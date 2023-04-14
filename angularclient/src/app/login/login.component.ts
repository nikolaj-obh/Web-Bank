import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    const credentials = { username: this.username, password: this.password };
    this.http.post('/api/login', credentials).subscribe((result: any) => {
      localStorage.setItem('token', result.token);
      this.router.navigate(['/dashboard']);
    });
  }

}
