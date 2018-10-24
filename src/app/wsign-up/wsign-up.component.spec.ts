import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WSignUpComponent } from './wsign-up.component';

describe('WSignUpComponent', () => {
  let component: WSignUpComponent;
  let fixture: ComponentFixture<WSignUpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WSignUpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WSignUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
