import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username!: string;
  password!: string;
  errorMessage!: string;

  constructor(private http: HttpClient, private router: Router) {}

  formSubmit() {
    // Perform any additional validation if required
    const userData = {
      username: this.username,
      password: this.password
    }

    // Send login request to backend
    this.http.post<any>('http://localhost:8080/login', userData)
    .subscribe(response => {
      if (response && response.id) { // Assuming 'id' is a property in the User object
        console.log(response);
        // Login successful, navigate to the dashboard or perform any other action
        this.router.navigate([response.id,'dashboard']);
      } else {
        // Login failed, display error message
        this.errorMessage = response && response.message ? response.message : 'Unknown error occurred';
      }
    }, error => {
      console.error('Error occurred:', error);
      this.errorMessage = 'An error occurred while logging in. Please try again later.';
    });
}
}
