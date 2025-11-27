package pti.sb_amoba_rest.dto;

public class RankDto {
	
	
	private int life;
	private int score;
	private int userId;
	
	public RankDto(int life, int score, int userId) {
		super();
		this.life = life;
		this.score = score;
		this.userId = userId;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
