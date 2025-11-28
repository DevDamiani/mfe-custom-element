import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloLiferay } from './hello-liferay';

describe('HelloLiferay', () => {
  let component: HelloLiferay;
  let fixture: ComponentFixture<HelloLiferay>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HelloLiferay]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HelloLiferay);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
