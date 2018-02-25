import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcatComponent } from './procat.component';

describe('ProcatComponent', () => {
  let component: ProcatComponent;
  let fixture: ComponentFixture<ProcatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
