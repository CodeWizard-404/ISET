import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PresenationComponent } from './component/presenation/presenation.component';
import { ErrorComponent } from './component/error/error.component';
import { AboutusComponent } from './component/aboutus/aboutus.component';
import { ListlivreComponent } from './component/listlivre/listlivre.component';
import { SelectdLivreComponent } from './component/selectd-livre/selectd-livre.component';

const routes: Routes = [
  {path:'presenation',title:'Presentation',component:PresenationComponent},
  {path:'aboutus',title:'A propos de Nous',component:AboutusComponent},
  {path:'listlivre',title:'Liste des livres',component:ListlivreComponent},
  {path:'selected-livre',title:'s',component:SelectdLivreComponent},
  {path:'',redirectTo:'presenation',pathMatch:'full'},
  {path:'**',title:'ERROR',component:ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
