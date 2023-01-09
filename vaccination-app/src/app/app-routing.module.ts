import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ReservationComponent } from './reservation/reservation.component';

const routes: Routes = [
  {path : "home" , component : HomeComponent},
  {path : "reservation" , component : ReservationComponent},
  {path : "inscription" , component : InscriptionComponent},
  {path : "connexion" , component : ConnexionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
