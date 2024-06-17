import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LicenseDataService } from 'src/app/services/license-data.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  licenses:any;
  userId!: number;
  name!: string;
  constructor(private licenseData: LicenseDataService, private route: ActivatedRoute){  
  }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId = +params['id']; // Convert the ID to a number
      // Fetch licenses for the specific user ID
      this.licenseData.getLicenses(this.userId).subscribe((data) => {
        console.warn("data", data);
        this.licenses = data;
        console.log(this.licenses);
      });
    });
  }
  
 
  // licenses = [
  //   { id: 1, lname: 'sfsds', price: '5000' },
  //   { id: 2, lname: 'asdaan', price: '1000' }
  // ];

  selectedOption: string | undefined; // Property to store the selected option
  options = [ // Array of options with labels and corresponding prices
    { label: 'Project 1', value: 'option1', price: 100000, desc:'ABC project' },
    { label: 'Project 2', value: 'option2', price: 500000, desc:'DEF project' },
    { label: 'Project 3', value: 'option3', price: 102000,desc:'GHI project' },
    { label: 'Project 4', value: 'option4', price: 300000, desc:'JKL project' },
    { label: 'Project 5', value: 'option5', price: 850000, desc:'MNO project' },
    { label: 'Project 6', value: 'option6', price: 299000,desc:'PQR project' }
  ];

  getPrice(): number | string {
    // Find the selected option object
    const selected = this.options.find(option => option.value === this.selectedOption);
    // Return the price if an option is selected, otherwise return an empty string
    return selected ? selected.price : '';
  }
  getDesc(): string {
    // Find the selected option object
    const selected = this.options.find(option => option.value === this.selectedOption);
    // Return the price if an option is selected, otherwise return an empty string
    return selected ? selected.desc : '';
  }

  buyLicense() {
    // Find the selected option object
    const selected = this.options.find(option => option.value === this.selectedOption);
    if (selected) {
      // Create the data payload for the license
      const data = {
        lName: selected.label, // Include the license name
        price: selected.price,
        desc: selected.desc,
        user_id:this.userId
      };
      // Post the license for the specific user ID
      this.licenseData.postLicense(this.userId, data).subscribe(
        response => {
          // Handle success response
          console.log('License bought successfully:', response);
          window.location.reload(); // Reload the page
        },
        error => {
          // Handle error response
          console.error('Error buying license:', error);
        }
      );
    } else {
      console.error('No option selected.');
    }
  }
  


}
