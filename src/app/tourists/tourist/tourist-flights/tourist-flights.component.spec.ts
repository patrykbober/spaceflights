import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TouristFlightsComponent } from './tourist-flights.component';

describe('TouristFlightsComponent', () => {
  let component: TouristFlightsComponent;
  let fixture: ComponentFixture<TouristFlightsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TouristFlightsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TouristFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
