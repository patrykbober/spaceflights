import { Component, Input, OnInit } from '@angular/core';
import { FlightsService } from "../../../shared/services/flights.service";
import { Tourist } from "../../../shared/models/tourist";
import {Router} from "@angular/router";

@Component({
  selector: 'app-flight-tourists',
  templateUrl: './flight-tourists.component.html',
  styleUrls: ['./flight-tourists.component.scss']
})
export class FlightTouristsComponent implements OnInit {

  @Input() private id: number;
  private flightTourists: Tourist[] = [];
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'dateOfBirth'];

  constructor(private flightService: FlightsService, private router: Router) { }

  ngOnInit() {
    if (!isNaN(this.id)) {
      this.getFlightTourists(this.id);
    }
  }

  getFlightTourists(id: number) {
    this.flightService.getTouristsByFlightId(id)
        .subscribe(tourists => this.flightTourists = tourists,
            error => alert(error.error.message));
  }

  routeToTourist(id: number) {
    this.router.navigate(['/tourists/', id]);
  }

}
