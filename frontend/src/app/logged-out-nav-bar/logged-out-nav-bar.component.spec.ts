import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoggedOutNavBarComponent } from './logged-out-nav-bar.component';

describe('LoggedOutNavBarComponent', () => {
  let component: LoggedOutNavBarComponent;
  let fixture: ComponentFixture<LoggedOutNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoggedOutNavBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoggedOutNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
