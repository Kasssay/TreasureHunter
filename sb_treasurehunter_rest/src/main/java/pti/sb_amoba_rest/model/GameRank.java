package pti.sb_amoba_rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="game_ranking")
public class GameRank {

	
	@Id
	@Column(value="id")
	private int id;

	@Column(value="life")
	private int life;
	
	@Column(value="score")
	private int score;
	
	@Column(value="user_id")
	private int userId;

	public GameRank(int id, int life, int score, int userId) {
		super();
		this.id = id;
		this.life = life;
		this.score = score;
		this.userId = userId;
	}

	public GameRank() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "gameRank [id=" + id + ", life=" + life + ", score=" + score + ", userId=" + userId + "]";
	}
	
	
	
	
}
