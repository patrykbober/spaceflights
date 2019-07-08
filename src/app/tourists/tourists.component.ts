import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router} from "@angular/router";
import { TouristsService } from "../shared/services/tourists.service";
import { Tourist } from "../shared/models/tourist";

@Component({
  selector: 'app-tourists',
  templateUrl: './tourists.component.html',
  styleUrls: ['./tourists.component.scss']
})
export class TouristsComponent implements OnInit {

  tourists: Tourist[] = [];
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'dateOfBirth'];

  constructor(private touristService: TouristsService, private router: Router) { }

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
            alert("An error has occurred");
          });
  }

  addTourist(newTourist : Tourist) : void {
    this.touristService.addTourist(newTourist)
        .subscribe(
          tourist => {
            this.tourists.push(newTourist);
        },
          error => {
            alert("An error has occurred");
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
    this.ngOnInit();
  }

  routeToTourist(id: number) {
    this.router.navigate(['/tourists/', id]);
  }
}
