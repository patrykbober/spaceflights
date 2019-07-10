import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightTouristsComponent } from './flight-tourists.component';

describe('FlightTouristsComponent', () => {
  let component: FlightTouristsComponent;
  let fixture: ComponentFixture<FlightTouristsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightTouristsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightTouristsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
