import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategotyMenuComponent } from './categoty-menu.component';

describe('CategotyMenuComponent', () => {
  let component: CategotyMenuComponent;
  let fixture: ComponentFixture<CategotyMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CategotyMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CategotyMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
