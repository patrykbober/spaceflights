import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Flight} from "../../../shared/models/flight";
import {FlightsService} from "../../../shared/services/flights.service";
import {TouristsService} from "../../../shared/services/tourists.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-remove-tourist',
  templateUrl: './remove-flight.component.html',
  styleUrls: ['./remove-flight.component.scss']
})
export class RemoveFlightComponent implements OnInit {

  private touristId: number;
  private removeFlightForm: FormGroup;
  private submitted: boolean = false;
  private success: boolean = false;
  private flights: Flight[] = [];

  constructor(private formBuilder: FormBuilder, private flightService: FlightsService,
              private touristService: TouristsService, private route: ActivatedRoute) {
    this.removeFlightForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.touristId = Number(this.route.snapshot.paramMap.get('touristId'));
    this.getTouristsFlights();
  }

  onSubmit() {
    this.submitted = true;

    if (this.removeFlightForm.invalid) {
      return;
    }

    this.success = true;

    this.touristService.removeFlightFromTourist(this.touristId, this.removeFlightForm.value).subscribe();
    this.removeFlightForm.reset();
  }

  getTouristsFlights() : void {
    this.touristService.getFlightsByTouristId(this.touristId)
      .subscribe(
        flights => {
          this.flights = flights;
        },
        error => {
          alert("An error has occurred");
        });
  }

}
