import { TestBed, inject } from '@angular/core/testing';

import { ProductcategoryService } from './productcategory.service';

describe('ProductcategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProductcategoryService]
    });
  });

  it('should be created', inject([ProductcategoryService], (service: ProductcategoryService) => {
    expect(service).toBeTruthy();
  }));
});
