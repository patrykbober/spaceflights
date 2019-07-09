import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TouristsComponent } from './tourists/tourists.component';
import { TouristComponent } from "./tourists/tourist/tourist.component";
import { FlightsComponent } from './flights/flights.component';
import { FlightComponent } from "./flights/flight/flight.component";
import { CreateTouristComponent } from "./tourists/tourist/create-tourist/create-tourist.component";
import { CreateFlightComponent } from "./flights/flight/create-flight/create-flight.component";
import { AddFlightComponent } from "./tourists/tourist/add-flight/add-flight.component";
import { AddTouristComponent } from "./flights/flight/add-tourist/add-tourist.component";
import { RemoveTouristComponent } from "./flights/flight/remove-tourist/remove-tourist.component";
import { RemoveFlightComponent } from "./tourists/tourist/remove-flight/remove-flight.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'tourists', component: TouristsComponent },
  { path: 'tourists/add', component: CreateTouristComponent },
  { path: 'tourists/:touristId', component: TouristComponent },
  { path: 'tourists/:touristId/add', component: AddFlightComponent },
  { path: 'tourists/:touristId/remove', component: RemoveFlightComponent },
  { path: 'flights', component: FlightsComponent },
  { path: 'flights/add', component: CreateFlightComponent },
  { path: 'flights/:flightId', component: FlightComponent },
  { path: 'flights/:flightId/add', component: AddTouristComponent },
  { path: 'flights/:flightId/remove', component: RemoveTouristComponent },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
