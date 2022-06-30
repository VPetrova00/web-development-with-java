import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoggedInNavBarComponent } from './logged-in-nav-bar.component';

describe('LoggedInNavBarComponent', () => {
  let component: LoggedInNavBarComponent;
  let fixture: ComponentFixture<LoggedInNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoggedInNavBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoggedInNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
