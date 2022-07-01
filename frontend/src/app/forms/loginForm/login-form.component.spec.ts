import {LoginFormComponent} from "./login-form.component";
import {ComponentFixture, TestBed} from "@angular/core/testing";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterTestingModule} from "@angular/router/testing";
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('LoginFormComponent', () => {
  let component: LoginFormComponent;
  let fixtureInfo: ComponentFixture<LoginFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginFormComponent ],
      imports: [ ReactiveFormsModule, RouterTestingModule, HttpClientTestingModule ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixtureInfo = TestBed.createComponent(LoginFormComponent);
    component = fixtureInfo.componentInstance;
    fixtureInfo.detectChanges();
  });

  it('component is created', () => {
    expect(component).toBeTruthy();
  });
});
