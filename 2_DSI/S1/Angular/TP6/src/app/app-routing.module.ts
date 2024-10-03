import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent } from './application/contact/contact.component';
import { ListproductsComponent } from './application/listproducts/listproducts.component';
import { HomeComponent } from './application/home/home.component';
import { Error404Component } from './application/error404/error404.component';

const routes: Routes = [
  {path:'acceuil',title:'Acceuil',component:HomeComponent},
  {path:'listproducts',title:'Liste des produit',component:ListproductsComponent},
  {path:'contact',title:'Contact',component:ContactComponent},
  {path:'',redirectTo:'acceuil',pathMatch:'full'},
  {path:'**',title:'ERROR',component:Error404Component},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
