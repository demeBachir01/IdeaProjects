import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EtudiantComponent} from "./etudiant/etudiant.component";
import {EnseignantComponent} from "./enseignant/enseignant.component";
import {AppComponent} from "./app.component";

const routes: Routes = [
  {path : "etudiant", component : EtudiantComponent },
  {path : "enseignant", component : EnseignantComponent },
  {path : "accueil", component : AppComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
