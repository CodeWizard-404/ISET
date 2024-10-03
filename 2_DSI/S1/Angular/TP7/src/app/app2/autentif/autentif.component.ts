import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-autentif',
  templateUrl: './autentif.component.html',
  styleUrls: ['./autentif.component.css']
})
export class AutentifComponent  {
constructor(private router:Router,private authService:AuthService){}
login:string="";
pwd:string="";

toDash(){
  if(this.authService.login(this.login,this.pwd)){
    this.router.navigate(['/dashboard']);
  }
  else{
    alert("ERROR");
  }
}

}