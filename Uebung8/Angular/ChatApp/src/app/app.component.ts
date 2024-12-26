import { Component } from '@angular/core';

@Component({
  selector: 'app-root', //Tag <app-root></app-root> in HTML verwendet
  templateUrl: './app.component.html', //Pfad zur HTML-Vorlage
  standalone: false, // Komponente ist Teil eines Moduls 
  styleUrl: './app.component.css' //Pfad zur CSS-Datei
})
export class AppComponent {
  title = 'ChatApp';
}
