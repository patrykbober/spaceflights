import { Component, OnInit } from '@angular/core';
import { TouristsService } from "../../../shared/services/tourists.service";
import { Tourist } from "../../../shared/models/tourist";
import { FlightsService } from "../../../shared/services/flights.service";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-tourist',
  templateUrl: './add-tourist.component.html',
  styleUrls: ['./add-tourist.component.scss']
})
export class AddTouristComponent implements OnInit {

  private flightId: number;
  private addTouristForm: FormGroup;
  private submitted: boolean = false;
  private success: boolean = false;
  private tourists: Tourist[] = [];

  constructor(private formBuilder: FormBuilder, private touristService: TouristsService,
              private flightService: FlightsService, private route: ActivatedRoute,
              private router: Router) {
    this.addTouristForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.flightId = Number(this.route.snapshot.paramMap.get('flightId'));
    this.getAllTourists();
  }

  onSubmit() {
    this.submitted = true;

    if (this.addTouristForm.invalid) {
      return;
    }

    this.success = true;

    this.flightService.addTouristToFlight(this.flightId, this.addTouristForm.value)
        .subscribe(flight => console.log(flight),
            error => alert(error.error.message));
    this.addTouristForm.reset();
    this.router.navigate(['/flights', this.flightId]);
  }

  getAllTourists() : void {
    this.touristService.getAllTourists()
        .subscribe(tourists => this.tourists = tourists,
            error => alert(error.error.message));
  }

}
