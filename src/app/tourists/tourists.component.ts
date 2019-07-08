import { Component, OnInit } from '@angular/core';
import { TouristsService } from "../shared/services/tourists.service";
import { Tourist } from "../shared/models/tourist";

@Component({
  selector: 'app-tourists',
  templateUrl: './tourists.component.html',
  styleUrls: ['./tourists.component.scss']
})
export class TouristsComponent implements OnInit {

  tourists;

  constructor(private touristService: TouristsService) { }

  ngOnInit() {
    this.getAllTourists();
  }

  getAllTourists() : void {
    this.touristService.getAllTourists()
        .subscribe(
          tourists => {
            this.tourists = tourists;
          },
          error => {
            alert("An error has occured");
          });
  }

  addTourist(newTourist : Tourist) : void {
    this.touristService.addTourist(newTourist)
        .subscribe(
          tourist => {
            this.tourists.push(newTourist);
        },
          error => {
            alert("An error has occured");
          });
  }

  addTheTourist() : void {
    const theTourist = {
      firstName: "Gary",
      lastName: "Cooper",
      gender: "MALE",
      country: "New Zealand",
      remarks: "in love with traveling",
      dateOfBirth: "1994-11-02"
    };

    this.touristService.addTourist(theTourist)
        .subscribe(tourist => this.tourists.push());
  }

}
