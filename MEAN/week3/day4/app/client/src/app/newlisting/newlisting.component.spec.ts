import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewlistingComponent } from './newlisting.component';

describe('NewlistingComponent', () => {
  let component: NewlistingComponent;
  let fixture: ComponentFixture<NewlistingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewlistingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewlistingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
