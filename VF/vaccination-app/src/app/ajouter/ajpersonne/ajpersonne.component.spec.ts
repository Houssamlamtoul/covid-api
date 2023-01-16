import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjpersonneComponent } from './ajpersonne.component';

describe('AjpersonneComponent', () => {
  let component: AjpersonneComponent;
  let fixture: ComponentFixture<AjpersonneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjpersonneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjpersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
