import { Component, Input, OnInit} from '@angular/core';
import { TouristsService } from "../../../shared/services/tourists.service";
import { Flight } from "../../../shared/models/flight";
import {Router} from "@angular/router";

@Component({
  selector: 'app-tourist-flights',
  templateUrl: './tourist-flights.component.html',
  styleUrls: ['./tourist-flights.component.scss']
})
export class TouristFlightsComponent implements OnInit {

  @Input() private id: number;
  private touristFlights: Flight[] = [];
  displayedColumns: string[] = ['id', 'departureTime', 'arrivalTime', 'numberOfSeats', 'ticketPrice'];

  constructor(private touristService: TouristsService, private router: Router) { }

  ngOnInit() {
    if (!isNaN(this.id)) {
      this.getTouristFlights(this.id);
    }
  }

  getTouristFlights(id: number) {
    this.touristService.getFlightsByTouristId(id)
        .subscribe(flights => this.touristFlights = flights,
            error => alert(error.error.message));
  }
  routeToFlight(id: number) {
    this.router.navigate(['/flights/', id]);
  }

}
