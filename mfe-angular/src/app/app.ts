import { Component, inject, Input, OnChanges, signal, SimpleChanges } from '@angular/core';
import { HelloLiferay } from './hello-liferay/hello-liferay';

@Component({
  selector: 'app-root',
  template: `<app-hello-liferay></app-hello-liferay>`,
   imports: [HelloLiferay],
  standalone: true,
})
export class App  {
 
}

