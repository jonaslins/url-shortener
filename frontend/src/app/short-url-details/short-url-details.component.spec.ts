import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShortUrlDetailsComponent } from './short-url-details.component';

describe('ShortUrlDetailsComponent', () => {
  let component: ShortUrlDetailsComponent;
  let fixture: ComponentFixture<ShortUrlDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShortUrlDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShortUrlDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
