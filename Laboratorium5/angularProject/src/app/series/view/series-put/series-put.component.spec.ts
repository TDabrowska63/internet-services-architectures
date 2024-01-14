import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeriesPutComponent } from './series-put.component';

describe('SeriesPutComponent', () => {
  let component: SeriesPutComponent;
  let fixture: ComponentFixture<SeriesPutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SeriesPutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SeriesPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
