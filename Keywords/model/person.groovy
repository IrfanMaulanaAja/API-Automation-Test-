package model

public class person {
	Integer id
	String name
	String gender
	String birthday

	person(Map data) {
		this.id = data.id
		this.name = data.name
		this.gender = data.gender
		this.birthday = data.birthday
	}
}
