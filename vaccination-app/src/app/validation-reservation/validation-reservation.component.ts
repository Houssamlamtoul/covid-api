import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-validation-reservation',
  templateUrl: './validation-reservation.component.html',
  styleUrls: ['./validation-reservation.component.scss']
})
export class ValidationReservationComponent implements OnInit {
  longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog
  from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was
  originally bred for hunting.`;
  searchText:any;
  centres = [
  {name:"Houssam LAMTOUL",},
  {name:"Marwane QUADDAM",},
  {name:"Achraf HDADI",},

];
  constructor() { }

  ngOnInit(): void {
  }
  btnstate: boolean=false;

  disableFunc(){
    this.btnstate = true;
  }
}
