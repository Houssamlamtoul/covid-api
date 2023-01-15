import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjcentreComponent } from './ajcentre.component';

describe('AjcentreComponent', () => {
  let component: AjcentreComponent;
  let fixture: ComponentFixture<AjcentreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjcentreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjcentreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
