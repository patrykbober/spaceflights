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
        .subscribe(tourists => this.tourists = tourists,
            error => alert(error.error.message));
  }

  addTourist(newTourist: Tourist) : void {
    this.touristService.addTourist(newTourist)
        .subscribe(tourist => this.tourists.push(newTourist),
            error => alert(error.error.message));
  }

  // method for testing purposes only
  addTheTourist() : void {
    const theTourist = {
      firstName: "Gary",
      lastName: "Cooper",
      gender: "MALE",
      country: "New Zealand",
      remarks: "in love with traveling",
      dateOfBirth: "1994-11-02"
    };

    this.touristService.addTourist(theTourist as Tourist)
        .subscribe(tourist => this.tourists.push(theTourist as Tourist),
            error => alert(error.error.message));
    this.ngOnInit();
  }

  routeToTourist(id: number) {
    this.router.navigate(['/tourists/', id]);
  }
}
