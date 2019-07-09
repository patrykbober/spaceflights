import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Tourist} from "../../../shared/models/tourist";
import {TouristsService} from "../../../shared/services/tourists.service";
import {FlightsService} from "../../../shared/services/flights.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-remove-tourist',
  templateUrl: './remove-tourist.component.html',
  styleUrls: ['./remove-tourist.component.scss']
})
export class RemoveTouristComponent implements OnInit {

  private flightId: number;
  private removeTouristForm: FormGroup;
  private submitted: boolean = false;
  private success: boolean = false;
  private tourists: Tourist[] = [];

  constructor(private formBuilder: FormBuilder, private touristService: TouristsService,
              private flightService: FlightsService, private route: ActivatedRoute) {
    this.removeTouristForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.flightId = Number(this.route.snapshot.paramMap.get('flightId'));
    this.getFlightsTourists();
  }

  onSubmit() {
    this.submitted = true;

    if (this.removeTouristForm.invalid) {
      return;
    }

    this.success = true;

    this.flightService.removeTouristFromFlight(this.flightId, this.removeTouristForm.value).subscribe();
    this.removeTouristForm.reset();
  }

  getFlightsTourists() : void {
    this.flightService.getTouristsByFlightId(this.flightId)
      .subscribe(
        tourists => {
          this.tourists = tourists;
        },
        error => {
          alert("An error has occurred");
        });
  }

}
