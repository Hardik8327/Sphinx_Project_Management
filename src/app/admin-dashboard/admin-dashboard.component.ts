import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { LicenseDataService } from '../services/license-data.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  users:any;
  userrs: any[] = [];
  userId: number=1;
  constructor(private licenseData: LicenseDataService, private route: ActivatedRoute, private router: Router){}
  ngOnInit(): void {
    this.licenseData.getUsers().subscribe((data)=>{
      console.warn("data",data);
      this.users=data;
    });
  }

  deleteUser(id: number) {
    this.licenseData.deleteUser(id).subscribe(() => {
      this.userrs = this.userrs.filter(user => user.id !== id);
      window.location.reload(); // Reload the page
    });
  }
  navigateToUserDetails(id: number) {
    this.router.navigate([ id,'user-details']); // Assuming route is '/user-details/:id'
  }

}
