import { TestBed } from '@angular/core/testing';

import { MusicfestService } from './musicfest.service';

describe('MusicfestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MusicfestService = TestBed.get(MusicfestService);
    expect(service).toBeTruthy();
  });
});
