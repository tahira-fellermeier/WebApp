package edu.fra.uas.model;

public class Grade {

	private int id;
	private String modulName;
	private double grade;
	private int cp;

	public Grade(int id, String modulName, double grade, int cp) {
		super();
		if (grade < 1 || grade > 6) {
			throw new IllegalArgumentException("Note muss zwischen 1 und 6 liegen.");
		}
		this.id++;
		this.modulName = modulName;
		this.grade = grade;
		this.cp = cp;
	}

	public Grade() {
	}

	@Override
	public String toString() {
		return this.id + ". " + this.modulName + ": " + this.grade + " (" + this.cp + " cp)";
	}

	public String getModulName() {
		return modulName;
	}

	public void setModulName(String modulName) {
		this.modulName = modulName;
		System.out.println("Module changed to: " + this.modulName);
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
		System.out.println("Note changed to: " + this.grade);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	

}
