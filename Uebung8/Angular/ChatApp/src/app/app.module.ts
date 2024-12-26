import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RoomSearchComponent } from './room-search/room-search.component';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


@NgModule({ // Dekorator, der die Klasse als Angular-Modul definiert
  declarations: [ // Array in dem Komponenten, Direktiven und Pipes deklariert, die zu diesem Modul gehören, deklariert sind
    AppComponent, RoomSearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [provideHttpClient()], //Array in dem Dienste (Services) deklariert werden, die in diesem Modul bereitgestellt werden
  bootstrap: [AppComponent] //welche Komponente beim Starten der Anwendung gebootstrapped (initialisiert) werden soll
})
export class AppModule { }
