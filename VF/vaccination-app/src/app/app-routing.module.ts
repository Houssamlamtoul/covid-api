import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ReservationComponent } from './reservation/reservation.component';
import { SuperadminComponent } from './superadmin/superadmin.component';
import { ValidationReservationComponent } from './validation-reservation/validation-reservation.component';
import { VaccinationCenterComponent } from './vaccination-center/vaccination-center.component';
import { MedecinComponent } from './medecin/medecin.component';
import { FiledattenteComponent } from './filedattente/filedattente.component';


const routes: Routes = [
  {path : "" , redirectTo:'/home' , pathMatch:'full' },
  {path : "home" , component: HomeComponent },
  {path : "reservation" , component: ReservationComponent },
  {path : "connexion" , component: ConnexionComponent },
  {path : "inscription" , component: InscriptionComponent },
  {path : "superadmin" , component: SuperadminComponent },
  {path : "validation" , component: ValidationReservationComponent },
  {path : "admin" , component : AdminComponent },
  {path : "vaccination" , component : VaccinationCenterComponent },
  {path : "medecin" , component : MedecinComponent },
  {path : "fildattente", component : FiledattenteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
