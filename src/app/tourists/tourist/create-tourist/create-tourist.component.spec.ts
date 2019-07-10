import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTouristComponent } from './create-tourist.component';

describe('CreateTouristComponent', () => {
  let component: CreateTouristComponent;
  let fixture: ComponentFixture<CreateTouristComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateTouristComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTouristComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
