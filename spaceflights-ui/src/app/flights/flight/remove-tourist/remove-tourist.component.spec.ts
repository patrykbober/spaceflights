import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveTouristComponent } from './remove-tourist.component';

describe('RemoveFlightComponent', () => {
  let component: RemoveTouristComponent;
  let fixture: ComponentFixture<RemoveTouristComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoveTouristComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveTouristComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
