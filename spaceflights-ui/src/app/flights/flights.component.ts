import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { FlightsService } from "../shared/services/flights.service";
import { Flight } from "../shared/models/flight";

@Component({
  selector: 'app-flights',
  templateUrl: './flights.component.html',
  styleUrls: ['./flights.component.scss']
})
export class FlightsComponent implements OnInit {

  flights: Flight[] = [];
  displayedColumns: string[] = ['id', 'departureTime', 'arrivalTime', 'numberOfSeats', 'ticketPrice'];

  constructor(private flightService: FlightsService, private router: Router) { }

  ngOnInit() {
    this.getAllFlights();
  }

  getAllFlights() : void {
    this.flightService.getAllFlights()
        .subscribe(flights => this.flights = flights,
            error => alert(error.error.message));
  }

  addFlight(newFlight: Flight) : void {
    this.flightService.addFlight(newFlight)
        .subscribe(flight => this.flights.push(newFlight),
            error => alert(error.error.message));
  }

  // method for testing purposes only
  addTheFlight() : void {
    const theFlight = {
      departureTime: "2019-12-31T22:00:00",
      arrivalTime: "2020-01-01T03:40:00",
      numberOfSeats: 120,
      ticketPrice: 470
    };

    this.flightService.addFlight(theFlight as Flight)
        .subscribe(flight => this.flights.push(theFlight as Flight),
            error => alert(error.error.message));
    this.ngOnInit();
  }

  routeToFlight(id: number) {
    this.router.navigate(['/flights/', id]);
  }

}
