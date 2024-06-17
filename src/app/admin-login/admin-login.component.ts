import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
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
    this.http.post<any>('http://localhost:8080/Adminlogin', userData)
    .subscribe(response => {
      if (response.success) {
        // Login successful, obtain the user ID from the response

        // Redirect to the dashboard page with the user ID as a parameter
        this.router.navigate(['admin-dashboard']);
      } else {
        // Login failed, display error message
        this.errorMessage = response.message;
      }
    }, error => {
      console.error('Error occurred:', error);
      this.errorMessage = 'An error occurred while logging in. Please try again later.';
    });
  }

}
