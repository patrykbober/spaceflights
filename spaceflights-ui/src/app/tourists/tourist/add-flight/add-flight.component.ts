import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TouristsService} from "../../../shared/services/tourists.service";
import {FlightsService} from "../../../shared/services/flights.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Flight} from "../../../shared/models/flight";

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.scss']
})
export class AddFlightComponent implements OnInit {

  private touristId: number;
  private addFlightForm: FormGroup;
  private submitted: boolean = false;
  private success: boolean = false;
  private flights: Flight[] = [];

  constructor(private formBuilder: FormBuilder, private touristService: TouristsService,
              private flightService: FlightsService, private route: ActivatedRoute,
              private router: Router) {
    this.addFlightForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.touristId = Number(this.route.snapshot.paramMap.get('touristId'));
    this.getAllFlights();
  }

  onSubmit() {
    this.submitted = true;

    if (this.addFlightForm.invalid) {
      return;
    }

    this.success = true;

    this.touristService.addFlightToTourist(this.touristId, this.addFlightForm.value)
        .subscribe(tourist => console.log(tourist),
            error => alert(error.error.message));
    this.addFlightForm.reset();
    this.router.navigate(['/tourists', this.touristId]);
  }

  getAllFlights() : void {
    this.flightService.getAllFlights()
        .subscribe(flights => this.flights = flights,
            error => alert(error.error.message));
  }

}
