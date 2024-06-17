import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class LicenseDataService {

  constructor(private http:HttpClient) { }
  getLicenses(id: any) {
    return this.http.get(`http://localhost:8080/user/${id}/getLicenses`);
}

  postLicense(id: number,licenseData: any) { // Assuming licenseData is the data you want to send
    return this.http.post(`http://localhost:8080/user/${id}/license`, licenseData);
}

getUsers() {
  return this.http.get('http://localhost:8080/getUsers');
}

getUser(id: any){
  return this.http.get(`http://localhost:8080/getUser/${id}`);
}

deleteUser(id: number) {
  return this.http.delete(`http://localhost:8080/deleteUser/${id}`);
}

updateUser(id: number, updatedUser: any) {
  return this.http.put(`http://localhost:8080/updateUser/${id}`, updatedUser);
}
deleteLicense(userId: number, licenseId: number) {
  return this.http.delete(`http://localhost:8080/user/${userId}/license/${licenseId}`);
}

}
