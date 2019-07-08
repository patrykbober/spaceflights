import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { MatTableModule } from "@angular/material/table";
import { MatSortModule } from "@angular/material/sort";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { TouristsComponent } from './tourists/tourists.component';
import { FlightsComponent } from './flights/flights.component';

import { TouristsService } from "./shared/services/tourists.service";
import { FlightsService } from "./flights/flights.service";
import { TouristComponent } from './tourists/tourist/tourist.component';
import { FlightComponent } from './flights/flight/flight.component';
import { AddComponent } from './tourists/tourist/add/add.component';
import { TouristFlightsComponent } from './tourists/tourist/tourist-flights/tourist-flights.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    TouristsComponent,
    FlightsComponent,
    TouristComponent,
    FlightComponent,
    AddComponent,
    TouristFlightsComponent
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    MatSortModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [TouristsService, FlightsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
