import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectCollabsComponent } from './select-collabs.component';

describe('SelectCollabsComponent', () => {
  let component: SelectCollabsComponent;
  let fixture: ComponentFixture<SelectCollabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectCollabsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelectCollabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
