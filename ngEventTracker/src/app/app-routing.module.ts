import { MusicfestlistComponent } from './components/musicfestlist/musicfestlist.component';
import { AboutComponent } from './components/about/about.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';


const routes: Routes = [
  {path : '', pathMatch: 'full', redirectTo: 'home'},
  {path : 'home', component: HomeComponent},
  {path : 'about', component: AboutComponent},
  {path : 'musicfestivals', component: MusicfestlistComponent},
  {path : 'musicfestivals/:id', component: MusicfestlistComponent},
  {path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
