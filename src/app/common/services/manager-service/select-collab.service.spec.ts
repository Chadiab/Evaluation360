import { TestBed } from '@angular/core/testing';

import { SelectCollabService } from './select-collab.service';

describe('SelectCollabService', () => {
  let service: SelectCollabService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SelectCollabService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
