import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDaleteComponent } from './update-dalete.component';

describe('UpdateDaleteComponent', () => {
  let component: UpdateDaleteComponent;
  let fixture: ComponentFixture<UpdateDaleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateDaleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDaleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
