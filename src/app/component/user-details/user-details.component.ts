import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LicenseDataService } from 'src/app/services/license-data.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {
  user: any;
  userId!:number;
  userrs: any[] = [];
  constructor(private licenseData: LicenseDataService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // Get the user ID from the route parameters
    this.route.params.subscribe(params => {
      this.userId = +params['id']; // Convert the ID to a number
      // Fetch the user details for the specific user ID
      this.licenseData.getUser(this.userId).subscribe((data) => {
        console.warn("User data:", data);
        this.user = data;
      });
    });
    this.user = {
      name: 'Initial Name',
      username: 'Initial Username',
      password: 'Initial Password',
      licenses: [] // Assuming licenses is an array
    };
  }

  deleteLicense(licenseId:number){
    this.licenseData.deleteLicense(this.userId,licenseId).subscribe(() => {
      this.userrs = this.userrs.filter(license => license.id !== licenseId);
      window.location.reload(); // Reload the page
    });
  }

  // updateaUser(id: number, updatedUserData: any) {
  //   this.licenseData.updateUser(id, updatedUserData).subscribe(() => {
  //     // Optionally, you can handle success response here
  //     console.log('User updated successfully');
  //   }, error => {
  //     // Optionally, you can handle error response here
  //     console.error('Failed to update user', error);
  //   });
  // }
  
  updateaUser() {
    this.licenseData.updateUser(this.user.id, this.user).subscribe(() => {
      console.log('User updated successfully');
    }, error => {
      console.error('Failed to update user', error);
    });
  }
}
