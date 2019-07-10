import { Component, OnInit } from '@angular/core';
import { Flight } from "../../shared/models/flight";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {FlightsService} from "../../shared/services/flights.service";

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.scss']
})
export class FlightComponent implements OnInit {

  private id: number;
  private flight: Flight;

  constructor(private route: ActivatedRoute, private router: Router,
              private flightService: FlightsService) {
    this.router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
    };

    this.router.events.subscribe((evt) => {
      if (evt instanceof NavigationEnd) {
        this.router.navigated = false;
        window.scrollTo(0, 0);
      }
    });
  }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('flightId'));
    if (!isNaN(this.id)) {
      this.getFlight();
    }
    else {
      this.router.navigate(['/']);
    }
  }

  getFlight() {
    this.flightService.getFlightById(this.id)
        .subscribe(flight => this.flight = flight,
            error => alert(error.error.message));
  }

  onSubmit() {
    this.flightService.deleteFlightById(this.id)
        .subscribe(flight => console.log(flight),
            error => alert(error.error.message));
    this.router.navigate(['/flights']);
  }

}
