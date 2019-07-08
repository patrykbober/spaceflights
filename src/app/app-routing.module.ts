import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TouristsComponent } from './tourists/tourists.component';
import { FlightsComponent } from './flights/flights.component';
import { TouristComponent } from "./tourists/tourist/tourist.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'tourists', component: TouristsComponent },
  { path: 'tourists/:touristId', component: TouristComponent },
  { path: 'flights', component: FlightsComponent },
  { path: 'flights/:flightId', component: FlightComponent },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
