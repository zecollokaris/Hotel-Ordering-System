import { TestBed } from '@angular/core/testing';

import { SparkService } from './spark.service';

describe('SparkService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SparkService = TestBed.get(SparkService);
    expect(service).toBeTruthy();
  });
});
