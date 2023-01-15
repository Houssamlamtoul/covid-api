import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FiledattenteComponent } from './filedattente.component';

describe('FiledattenteComponent', () => {
  let component: FiledattenteComponent;
  let fixture: ComponentFixture<FiledattenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FiledattenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FiledattenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
