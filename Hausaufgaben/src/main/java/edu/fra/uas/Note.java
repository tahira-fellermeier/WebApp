package edu.fra.uas;

//@component
public class Note {

	public String modul;
	public double note;

	public Note(String modul, double note) {
		super();
		this.modul = modul;
		this.note = note;
	}

	@Override
	public String toString() {
		return this.modul + ": " + this.note;
	}

	public String getModul() {
		return modul;
	}

	public void setModul(String modul) {
		this.modul = modul;
		System.out.println("Module changed to: " + this.modul);
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
		System.out.println("Note changed to: " + this.note);
	}

}
