import { Component, Input, OnInit} from '@angular/core';
import { TouristsService } from "../../../shared/services/tourists.service";
import { Flight } from "../../../shared/models/flight";

@Component({
  selector: 'app-tourist-flights',
  templateUrl: './tourist-flights.component.html',
  styleUrls: ['./tourist-flights.component.scss']
})
export class TouristFlightsComponent implements OnInit {

  @Input() private id: number;
  private touristFlights: Flight[] = [];
  displayedColumns: string[] = ['id', 'departureTime', 'arrivalTime', 'numberOfSeats', 'ticketPrice'];

  constructor(private touristService: TouristsService) { }

  ngOnInit() {
    this.getTouristFlights(this.id);
  }

  getTouristFlights(id: number) {
    this.touristService.getFlightsByTouristId(id)
        .subscribe(
        flights => {
          this.touristFlights = flights;
        },
        error => {
          alert("An error has occurred");
        });
  }

}
