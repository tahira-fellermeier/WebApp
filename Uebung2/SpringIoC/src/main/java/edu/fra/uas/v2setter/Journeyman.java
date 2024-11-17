package edu.fra.uas.v2setter;

public class Journeyman { //Sichtbar für Klassen in der gleichen Paket
    Work work;//Instanzvariable vom Work. Da Work ein Interface ist, kann work jede Instanz einer Klasse speichern, die das Work-Interface implementiert (z.B. Drilling).

    public Journeyman setWork(Work work) { //Setter Injektion - eine Instanz einer Work-Implementierung (z.B. Drilling) injizieren.
        this.work = work; //
        return this; //gibt die aktuelle Instanz von Journeyman zurück
    }

    public void performWork() {
        work.doWork();
    }
}
