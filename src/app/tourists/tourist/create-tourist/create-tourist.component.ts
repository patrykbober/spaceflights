import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { TouristsService } from "../../../shared/services/tourists.service";
import { Tourist } from "../../../shared/models/tourist";

@Component({
  selector: 'app-add',
  templateUrl: './create-tourist.component.html',
  styleUrls: ['./create-tourist.component.scss']
})
export class CreateTouristComponent implements OnInit {

  createTouristForm: FormGroup;
  private submitted: boolean = false;
  private success: boolean = false;

  constructor(private formBuilder: FormBuilder, private touristService: TouristsService) {
    this.createTouristForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: ['', Validators.required],
      country: ['', Validators.required],
      remarks: [''],
      dateOfBirth: ['YYYY-MM-DD', Validators.required]
    });
  }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;

    if (this.createTouristForm.invalid) {
      return;
    }

    this.success = true;

    let newTourist: Tourist = this.createTouristForm.value;
    this.touristService.addTourist(newTourist)
        .subscribe(tourist => console.log(tourist),
            error => alert(error.error.message));
    this.createTouristForm.reset();
  }

}
