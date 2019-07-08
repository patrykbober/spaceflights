import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import { TouristsService } from "../../shared/services/tourists.service";
import { Tourist } from "../../shared/models/tourist";

@Component({
  selector: 'app-tourist',
  templateUrl: './tourist.component.html',
  styleUrls: ['./tourist.component.scss']
})
export class TouristComponent implements OnInit {

  private id: number;
  private tourist: Tourist;

  constructor(private route: ActivatedRoute, private router: Router,
              private touristService: TouristsService) {
    this.router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
    };

    this.router.events.subscribe((evt) => {
      if (evt instanceof NavigationEnd) {
        this.router.navigated = false;
        window.scrollTo(0, 0);
      }
    });
  }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('touristId'));
    this.getTourist();
  }

  getTourist() {
    this.touristService.getTouristById(this.id)
        .subscribe(
          tourist => {
          this.tourist = tourist;
        },
          error1 => {
          alert("An error has occurred");
          });
  }

  onSubmit() {
    this.touristService.deleteTouristById(this.id).subscribe();
    this.router.navigate(['/tourists']);
  }

}
