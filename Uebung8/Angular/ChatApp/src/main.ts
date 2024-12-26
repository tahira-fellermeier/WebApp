import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';

platformBrowserDynamic().bootstrapModule(AppModule, { // erzeugt eine sogenannte Plattform, 
// die die Ausführung von Angular im Browser möglich macht
  ngZoneEventCoalescing: true,
})
  .catch(err => console.error(err));
