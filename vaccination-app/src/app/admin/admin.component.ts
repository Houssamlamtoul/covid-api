import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable, Observer } from 'rxjs';
import { AjcentreComponent } from '../ajouter/ajcentre/ajcentre.component';
import { AjpersonneComponent } from '../ajouter/ajpersonne/ajpersonne.component';
import { ModifierCentreComponent } from '../modifier/modifier-centre/modifier-centre.component';
import { ModifierPersonneComponent } from '../modifier/modifier-personne/modifier-personne.component';
import { ExampleTab } from '../superadmin/superadmin.component';
import { VaccinationCenterComponent } from '../vaccination-center/vaccination-center.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  applyFilter(arg0: any) {
    throw new Error('Method not implemented.');
    }
    longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog
    from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was
    originally bred for hunting.`;
      // Table :Centres / Config
      asyncTabs: Observable<ExampleTab[]>;
    displayedColumns: any;
    
      constructor(public dialog: MatDialog) {
        this.asyncTabs = new Observable((observer: Observer<ExampleTab[]>) => {
          setTimeout(() => {
            observer.next([
              {label: 'Centres', content: 'Content 1'},
              {label: 'Configu.', content: 'Content 2'},
            ]);
          }, 1000);
        }
    
     
        
        );
  
  }
  ngOnInit(): void {
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
    btnstate: boolean=false;

    disableFunc(){
      this.btnstate = true;
    }
}