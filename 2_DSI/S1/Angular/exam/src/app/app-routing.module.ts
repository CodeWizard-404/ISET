import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErreurComponent } from './components/erreur/erreur.component';
import { HomeComponent } from './components/home/home.component';
import { DashpaysComponent } from './components/dashpays/dashpays.component'; 
import { ContactComponent } from './components/contact/contact.component';
import { ListpaysComponent } from './components/listpays/listpays.component'; 
import { ModifpaysComponent } from './components/modifpays/modifpays.component';
import { SelectedpaysComponent } from './components/selectedpays/selectedpays.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {path: 'countries',
    component: DashpaysComponent,
    children: [
      { path: 'all', component: ListpaysComponent }, 
      { path: 'update', component: ModifpaysComponent }, 
      { path: 'selectedpays', component: SelectedpaysComponent },
      { path: '', redirectTo: 'all', pathMatch: 'full' }, 
    ]
  },
  { path: 'contact', component: ContactComponent },
  { path: 'selectedpays', component: SelectedpaysComponent },

  { path: 'erreur', component: ErreurComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/erreur' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
