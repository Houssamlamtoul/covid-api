import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from 'src/app/DataService';

@Component({
  selector: 'app-ajcentre',
  templateUrl: './ajcentre.component.html',
  styleUrls: ['./ajcentre.component.scss']
})
export class AjcentreComponent {

  
  nom: string = '';  // default value
  address: string = '';  
  city: string = ''; 
  codepostal: string = '';
  constructor(private http: HttpClient) {
    
  }
  
  
  sendData() {
    const data = {
      nom: this.nom,
      address: this.address,
      city: this.city,
      codepostal: this.codepostal
      
    };

    this.http.post('http://localhost:8080/api/newcentre', data).subscribe(response => {
        console.log('Request sent successfully');
        console.log(response);
      },
      error => {
        console.error('An error occurred');
        console.error(error);
      });
  }
}
