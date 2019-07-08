import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TouristsComponent } from './tourists/tourists.component';
import { FlightsComponent } from './flights/flights.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'tourists', component: TouristsComponent },
  { path: 'flights', component: FlightsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
