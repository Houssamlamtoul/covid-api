import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { ReservationComponent } from './reservation/reservation.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { SuperadminComponent } from './superadmin/superadmin.component';
import {MatTabsModule} from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import {MatTableModule} from '@angular/material/table';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { FormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatDialogModule} from '@angular/material/dialog';
import { AjcentreComponent } from './ajouter/ajcentre/ajcentre.component';
import { AjpersonneComponent } from './ajouter/ajpersonne/ajpersonne.component';
import { ValidationReservationComponent } from './validation-reservation/validation-reservation.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSelectModule} from '@angular/material/select';
import { ModifierPersonneComponent } from './modifier/modifier-personne/modifier-personne.component';
import { ModifierCentreComponent } from './modifier/modifier-centre/modifier-centre.component';
import { VaccinationCenterComponent } from './vaccination-center/vaccination-center.component';
import { AdminComponent } from './admin/admin.component';
import { MedecinComponent } from './medecin/medecin.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FiledattenteComponent } from './filedattente/filedattente.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    InscriptionComponent,
    ConnexionComponent,
    ReservationComponent,
    SuperadminComponent,
    AjcentreComponent,
    AjpersonneComponent,
    ValidationReservationComponent,
    ModifierPersonneComponent,
    ModifierCentreComponent,
    VaccinationCenterComponent,
    AdminComponent,
    MedecinComponent,
    FiledattenteComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatTabsModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatTableModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    FormsModule,
    MatInputModule,
    MatCardModule,
    MatDialogModule,
    MatDatepickerModule,
    MatSelectModule,
    Ng2SearchPipeModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
