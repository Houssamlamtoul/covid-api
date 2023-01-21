import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import {Observable, Observer} from 'rxjs';
import {MatTable} from '@angular/material/table';
import { MatSnackBar } from '@angular/material/snack-bar';
import {FormControl} from '@angular/forms';
import {map, startWith} from 'rxjs/operators';
import {FormBuilder} from '@angular/forms';
import {MatDialog} from '@angular/material/dialog';
import { AjcentreComponent } from '../ajouter/ajcentre/ajcentre.component';
import { AjpersonneComponent } from '../ajouter/ajpersonne/ajpersonne.component';
import { ModifierPersonneComponent } from '../modifier/modifier-personne/modifier-personne.component';
import { ModifierCentreComponent } from '../modifier/modifier-centre/modifier-centre.component';
import { VaccinationCenterComponent } from '../vaccination-center/vaccination-center.component';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../DataService';


export interface ExampleTab {
  label: string;
  content: string;
  
}


@Component({
  selector: 'app-superadmin',
  templateUrl: './superadmin.component.html',
  styleUrls: ['./superadmin.component.scss']
})


export class SuperadminComponent implements OnInit {
  searchText:any;
  centers: any;


  
applyFilter(arg0: any) {
throw new Error('Method not implemented.');
}


  
  // Table :Centres / Config
  asyncTabs: Observable<ExampleTab[]>;
displayedColumns: any;

  constructor(private _snackBar: MatSnackBar, public dialog: MatDialog, private http: HttpClient, private router: Router, @Inject(DataService) private dataService: DataService) {
    this.asyncTabs = new Observable((observer: Observer<ExampleTab[]>) => {
      setTimeout(() => {
        observer.next([
          {label: 'Centres', content: 'Content 1'},
          {label: 'Configu.', content: 'Content 2'},
        ]);
      }, 1000);
    }

 
    
    );
    
// end Table :Centres / Config

  }
  ngOnInit() {
    this.http.get('http://localhost:8080/api/public/center', { params: { city: 'nancy' } }).subscribe(centers => {
      this.centers = centers;
      console.log(centers);
      
    });
  }

    openDialog1() {
      const dialogRef = this.dialog.open(AjcentreComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
    }
  
    openDialog2() {
      const dialogRef = this.dialog.open(AjpersonneComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
    }
    openDialog3() {
      const dialogRef = this.dialog.open(ModifierCentreComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
    }
    openDialog4() {
      const dialogRef = this.dialog.open(ModifierPersonneComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
    }
    openDialog5() {
      const dialogRef = this.dialog.open(VaccinationCenterComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
    }
    goTooReservation(centerName: string) {
      this.dataService.setData(centerName);
    }
    centersNumber() {
      return new Array(this.centers.length);
    }
    deconnexion(){
      this.router.navigate(["/connexion"])
    }
}
