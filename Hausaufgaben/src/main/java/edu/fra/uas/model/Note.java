package edu.fra.uas.model;

public class Note {

	private String modul;
	private double note;

	public Note(String modul, double note) {
		super();
		if (note < 1 || note > 6) {
			throw new IllegalArgumentException("Note muss zwischen 1 und 6 liegen.");
		}
		this.modul = modul;
		this.note = note;
	}

	public Note() {
        //TODO Auto-generated constructor stub
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
