package cn.chenshiwu121.linkList;

public class Hero {
	
	private String name;
	private int age;
	private String occupation;
	
	public Hero() {
		super();
	}

	public Hero(String name, int age, String occupation) {
		super();
		this.name = name;
		this.age = age;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", age=" + age + ", occupation=" + occupation + "]";
	}
	
}
