import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { FlightsService } from "../../../shared/services/flights.service";
import { Flight } from "../../../shared/models/flight";

@Component({
  selector: 'app-create-flight',
  templateUrl: './create-flight.component.html',
  styleUrls: ['./create-flight.component.scss']
})
export class CreateFlightComponent implements OnInit {

  private createFlightForm: FormGroup;
  private submitted: boolean = false;
  private success: boolean = false;

  constructor(private formBuilder: FormBuilder, private flightService: FlightsService) {
    this.createFlightForm = this.formBuilder.group({
      departureTime: ['', Validators.required],
      arrivalTime: ['', Validators.required],
      numberOfSeats: [0, Validators.required],
      ticketPrice: [0, Validators.required]
    });
  }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;

    if (this.createFlightForm.invalid) {
      return;
    }

    this.success = true;

    let newFlight: Flight = this.createFlightForm.value;
    this.flightService.addFlight(newFlight).subscribe();
    this.createFlightForm.reset();
  }

}
