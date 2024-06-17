package com.example.License.License_Backend.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.License.License_Backend.Entity.License;

@Service
public class LicenseService {
	static int count=0;

	static public List<License> licenses = new ArrayList<License>();
	
	static {
		licenses.add(new License(++count,"Java",450,"A java license"));
		licenses.add(new License(++count,"Java",450,"A java license"));
		licenses.add(new License(++count,"Java",450,"A java license"));
	}
	
	
	public void addLicense(License License) {
        licenses.add(License);
    }
    
    public License getLicenseById(int id) {
        for (License License : licenses) {
            if (License.getlId() == id) {
                return License;
            }
        }
        return null; // If License with given id is not found
    }
    
    public void updateLicense(int id, String Licensename, int price, String desc) {
        for (License License : licenses) {
            if (License.getlId() == id) {
                License.setlName(Licensename);
                License.setPrice(price);
                License.setDesc(desc);
                return;
            }
        }
        // If License with given id is not found, you might handle this case accordingly
    }
    
    public void deleteLicense(int id) {
        licenses.removeIf(License -> License.getlId() == id);
    }
    public List<License> getAlllicenses(){
    	return licenses;
    }
}
