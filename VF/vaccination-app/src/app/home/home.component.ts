import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../DataService';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  searchText:any;
  centers: any;

  constructor(private http: HttpClient, private router: Router, @Inject(DataService) private dataService: DataService) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/api/public/center', { params: { city: 'nancy' } }).subscribe(centers => {
      this.centers = centers;
      console.log(centers);
      
    });
  }
  centersNumber() {
    return new Array(this.centers.length);
  }

  goToReservation(){
    this.router.navigate(["/reservation"])
  }
  goToConnexion(){
    this.router.navigate(["/connexion"])
  }
  goToInscription() {
    this.router.navigate(["/inscription"])
  }
  goTooReservation(centerName: string) {
    this.dataService.setData(centerName);
  }


}
