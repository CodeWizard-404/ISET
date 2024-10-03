import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './app1/accueil/accueil.component';
import { VetementsComponent } from './app1/clothes/vetements/vetements.component';
import { ChaussuresComponent } from './app1/shoes/chaussures/chaussures.component';
import { ContactComponent } from './app1/contact/contact.component';
import { ErreurComponent } from './app1/erreur/erreur.component';
import { EteComponent } from './app1/clothes/ete/ete.component';
import { HiverComponent } from './app1/clothes/hiver/hiver.component';
import { BebesComponent } from './app1/shoes/bebes/bebes.component';
import { FemmesComponent } from './app1/shoes/femmes/femmes.component';
import { HommesComponent } from './app1/shoes/hommes/hommes.component';
import { AutentifComponent } from './app2/autentif/autentif.component';
import { DashboardComponent } from './app2/dashboard/dashboard.component';
import { authGuard } from './auth.guard';

const routes: Routes = [
  /*{path:'home',title:"accueil",component:AccueilComponent},
  {path:'clothes',title:"vetements",component:VetementsComponent,
  children:[
    {path:"ete",title:"Habits ete",component:EteComponent},
    {path:"hiver",title:"Habits hiver",component:HiverComponent},
    {path:"",redirectTo:"ete",pathMatch:'full'},
  ]},
  {path:'shoes',title:"chaussures",component:ChaussuresComponent,
  children:[
    {path:"baby",title:"chaussures bebes",component:BebesComponent},
    {path:"women",title:" chaussures femmes",component:FemmesComponent},
    {path:"man",title:"chaussures hommes",component:HommesComponent},
    {path:"",redirectTo:"femmes",pathMatch:'full'},
  ]},
  {path:'contact',title:"contact",component:ContactComponent},
  {path:'',redirectTo:"home",pathMatch:"full"},
  {path:'**',title:"erreur",component:ErreurComponent}
*/

{path:'login',title:"authentif",component:AutentifComponent},
{path:'dashboard',title:"dashboard",component:DashboardComponent,canActivate:[authGuard]},
{path:"",redirectTo:"login",pathMatch:'full'},
{path:'**',title:"erreur",component:ErreurComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
