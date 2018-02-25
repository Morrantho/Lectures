import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LotdComponent } from './lotd.component';

describe('LotdComponent', () => {
  let component: LotdComponent;
  let fixture: ComponentFixture<LotdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LotdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LotdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
