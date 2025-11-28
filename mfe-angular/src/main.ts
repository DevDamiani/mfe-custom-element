import { createCustomElement } from '@angular/elements';
import { createApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';


createApplication(appConfig).then(appRef => {
  const injector = appRef.injector;

  const customElement = createCustomElement(App, { injector });


  customElements.define('mfe-angular', customElement);
});