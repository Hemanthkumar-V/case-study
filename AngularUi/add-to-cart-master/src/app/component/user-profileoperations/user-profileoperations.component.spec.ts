import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserProfileoperationsComponent } from './user-profileoperations.component';

describe('UserProfileoperationsComponent', () => {
  let component: UserProfileoperationsComponent;
  let fixture: ComponentFixture<UserProfileoperationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserProfileoperationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserProfileoperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
