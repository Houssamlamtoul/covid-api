import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from 'src/app/DataService';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent {

  nom: string = '';  // default value
  prenom: string = ''; 
  email: string = ''; 
  date: string = ''; 
  centerName:string;
  constructor(private http: HttpClient,private dataService:DataService) {
    this.centerName = this.dataService.getData();
  }
  
  
  sendData() {
    const data = {
      nom: this.nom,
      prenom: this.prenom,
      email: this.email,
      date: this.date,
      centerName:this.centerName
    };

    this.http.post('http://localhost:8080/api/endpoint', data).subscribe(response => {
        console.log('Request sent successfully');
        console.log(response);
      },
      error => {
        console.error('An error occurred');
        console.error(error);
      });
  }
}
