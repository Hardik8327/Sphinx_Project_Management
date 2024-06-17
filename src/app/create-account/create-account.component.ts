import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent  implements OnInit {
  userData = {
    name: '',
    username: '',
    password: ''
  };

    constructor(private router: Router, private http: HttpClient) { }
  
    ngOnInit(): void {
      throw new Error('Method not implemented.');
    }
  
    createNewUser(){
      this.router.navigate(['create-user']);
      console.log("clicked")
    }

    onSubmit() {
      this.http.post<any>('http://localhost:8080/user', this.userData)
        .subscribe(response => {
          console.log(this.userData)
          console.log('Server response:', response);
          // Handle success or any additional logic
          this.router.navigate(['login'])
        }, error => {
          console.error('Error occurred:', error);
          // Handle error
        });
    }
}
