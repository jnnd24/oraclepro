package com.javaex.phone;

public class PhoneVo {
	
	//필드
	private int personId;
	private String name;
	private String hp;
	private String company;

	
	
	//생성자
	protected PhoneVo() {
		super();
	}
	
	protected PhoneVo(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	protected PhoneVo(int personId, String name, String hp, String company) {
		super();
		this.personId = personId;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	
	//gs
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	
	
	//메소드
	@Override
	public String toString() {
		return "PhoneVo [personId=" + personId + ", name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	

}
