package model;

public class Joululahja {
	
	private int id;
	private String lahja;
	
	public Joululahja(String lahja) {
		super();
		this.lahja = lahja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLahja() {
		return lahja;
	}

	public void setLahja(String lahja) {
		this.lahja = lahja;
	}

}
