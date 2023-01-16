import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/DataService';

@Component({
  selector: 'app-modifier-centre',
  templateUrl: './modifier-centre.component.html',
  styleUrls: ['./modifier-centre.component.scss']
})
export class ModifierCentreComponent {
  id = 0;
  address = '';
  city = '';
  name = '';
  postalCode = '';

  constructor(private http: HttpClient,private dataService:DataService) {
    this.id = this.dataService.getData();
  }

  updateVaccinationCentre() {
    const data = {
      id: this.id,
      name: this.name,
      city: this.city,
      address: this.address,
      postalCode: this.postalCode
    };
    console.log(data);
    this.http.put('http://localhost:8080/vaccinationcentre', data, {headers: {'Content-Type': 'application/json'}}).subscribe(res => {
      console.log(res);
    });
  }
  deleteVaccinationCentre() {
    this.http.delete('http://localhost:8080/vaccinationcentre/' + this.id).subscribe(res => {
      console.log(res);
    });
  }
}