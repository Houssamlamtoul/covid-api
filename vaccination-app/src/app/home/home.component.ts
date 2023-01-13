import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  searchText:any;
  centres = [
  {name:"CHU Nancy", city: 'INancy'},
  {name:"CHU Narbonne", city: 'Narbonne'},
  {name:"CHU Metz", city: 'Metz'},];

  constructor(private router : Router) { }

  ngOnInit(): void {
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


}
