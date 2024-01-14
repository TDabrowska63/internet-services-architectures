import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterPutComponent } from './character-put.component';

describe('CharacterPutComponent', () => {
  let component: CharacterPutComponent;
  let fixture: ComponentFixture<CharacterPutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CharacterPutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CharacterPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
