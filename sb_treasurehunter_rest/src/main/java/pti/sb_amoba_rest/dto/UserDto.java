package pti.sb_amoba_rest.dto;

public class UserDto {
	
	private int id;
	private String name;
	
	private int score;
	private int life;
	
	
	public UserDto(int id, String name, int score, int life) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.life = life;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", score=" + score + ", life=" + life + "]";
	}
	
	
	
	
	
	
}	
	
