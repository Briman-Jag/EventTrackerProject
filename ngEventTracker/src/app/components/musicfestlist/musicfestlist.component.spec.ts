import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicfestlistComponent } from './musicfestlist.component';

describe('MusicfestlistComponent', () => {
  let component: MusicfestlistComponent;
  let fixture: ComponentFixture<MusicfestlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MusicfestlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicfestlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
