import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-modifier-personne',
  templateUrl: './modifier-personne.component.html',
  styleUrls: ['./modifier-personne.component.scss']
})
export class ModifierPersonneComponent implements OnInit {
  name = new FormControl('');
  selected = 'option2';
  data= {
    id: 1,
    nom: "LAMTOUL",
    role: "Superadmin",
    prenom: "Houssam",
    city: "Narbonne"
  };
  constructor() { }

  ngOnInit(): void {
  }

}
