import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierCentreComponent } from './modifier-centre.component';

describe('ModifierCentreComponent', () => {
  let component: ModifierCentreComponent;
  let fixture: ComponentFixture<ModifierCentreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifierCentreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifierCentreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
