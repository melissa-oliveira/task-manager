import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StateColumnComponent } from './state-column.component';

describe('StateColumnComponent', () => {
  let component: StateColumnComponent;
  let fixture: ComponentFixture<StateColumnComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StateColumnComponent]
    });
    fixture = TestBed.createComponent(StateColumnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
