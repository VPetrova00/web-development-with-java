import {ComponentFixture, TestBed} from "@angular/core/testing";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterTestingModule} from "@angular/router/testing";
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {RegistrationFormComponent} from "./registration-form.component";

describe('LoginFormComponent', () => {
  let component: RegistrationFormComponent;
  let fixtureInfo: ComponentFixture<RegistrationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrationFormComponent ],
      imports: [ ReactiveFormsModule, RouterTestingModule, HttpClientTestingModule ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixtureInfo = TestBed.createComponent(RegistrationFormComponent);
    component = fixtureInfo.componentInstance;
    fixtureInfo.detectChanges();
  });

  it('component is created', () => {
    expect(component).toBeTruthy();
  });
});
