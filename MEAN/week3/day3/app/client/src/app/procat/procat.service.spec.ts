import { TestBed, inject } from '@angular/core/testing';

import { ProcatService } from './procat.service';

describe('ProcatService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProcatService]
    });
  });

  it('should be created', inject([ProcatService], (service: ProcatService) => {
    expect(service).toBeTruthy();
  }));
});
