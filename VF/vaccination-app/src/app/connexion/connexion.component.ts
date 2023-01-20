import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';

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

    console.log("Hello " + this.login)


   
    this.authenticate(this.login, this.mdp).subscribe(

      data => {
        this.router.navigate(['/superadmin'])
           sessionStorage.setItem('username',this.login);
         let authString = 'Basic ' + btoa(this.login + ':' + this.mdp);
         sessionStorage.setItem('basicauth', authString);
      },
      error  => {
        console.log(this.login + " " + this.mdp )
        console.log("Bad credentials")
      }
    )
  }



  authenticate(user: string, password:string) {
        let data = {
      login : this.login,
      password : this.mdp
    }
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa((user + ':' + password)) })
    headers.set('Content-Type', 'application/json')
    return this.http.post('http://localhost:8080/user/login',data);
  }
}
