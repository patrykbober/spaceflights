import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { TouristsService } from "../../../shared/services/tourists.service";
import { Tourist } from "../../../shared/models/tourist";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  addTouristForm: FormGroup;
  private submitted: boolean = false;
  private success: boolean = false;

  constructor(private formBuilder: FormBuilder, private touristService: TouristsService) {
    this.addTouristForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: ['', Validators.required],
      country: ['', Validators.required],
      remarks: [''],
      dateOfBirth: ['', Validators.required]
    })
  }

  onSubmit() {
    this.submitted = true;

    if (this.addTouristForm.invalid) {
      return;
    }

    this.success = true;

    console.log(this.addTouristForm.value);
    let newTourist: Tourist = this.addTouristForm.value;
    console.log(newTourist);
    this.touristService.addTourist(newTourist).subscribe();
    //this.addTouristForm.reset();
  }

  ngOnInit() {
  }

}
