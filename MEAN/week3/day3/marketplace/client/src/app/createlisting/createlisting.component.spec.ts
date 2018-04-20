import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatelistingComponent } from './createlisting.component';

describe('CreatelistingComponent', () => {
  let component: CreatelistingComponent;
  let fixture: ComponentFixture<CreatelistingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatelistingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatelistingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
