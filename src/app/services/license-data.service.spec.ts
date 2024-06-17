import { TestBed } from '@angular/core/testing';

import { LicenseDataService } from './license-data.service';

describe('LicenseDataService', () => {
  let service: LicenseDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LicenseDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
