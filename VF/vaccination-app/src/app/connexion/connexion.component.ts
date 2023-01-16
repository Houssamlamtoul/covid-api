import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss'],
})
export class ConnexionComponent implements OnInit {
  login! : string;
  mdp! : string;

  constructor(private http: HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.login="";
    this.mdp="";
  }
  goToInscriptionpage(){
    this.router.navigate(["/inscription"])
  }

  connexion(){
    let data = {
      login : this.login,
      password : this.mdp
    }
    this.http.post('http://localhost:8080/user/login', data ).subscribe(response => {
        console.log('Request sent successfully');
        localStorage.setItem('token', window.btoa(this.login+':'+this.mdp))
        this.router.navigate(["/superadmin"])
        console.log(response);
      })
  }
}
