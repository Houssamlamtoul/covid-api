import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-ajpersonne',
  templateUrl: './ajpersonne.component.html',
  styleUrls: ['./ajpersonne.component.scss'],
  template: `
  <input [formControl]="name">
`,
})
export class AjpersonneComponent implements OnInit {
  emailFormControl = new FormControl('', [Validators.required, Validators.email]);
  constructor() { }
  name = new FormControl('');
  selected = 'option2';

  ngOnInit(): void {
  }

}


