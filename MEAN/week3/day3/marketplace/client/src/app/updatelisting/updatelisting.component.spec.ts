import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatelistingComponent } from './updatelisting.component';

describe('UpdatelistingComponent', () => {
  let component: UpdatelistingComponent;
  let fixture: ComponentFixture<UpdatelistingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatelistingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatelistingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
