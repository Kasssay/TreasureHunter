package pti.sb_amoba_rest.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_amoba_rest.db.RankRepository;
import pti.sb_amoba_rest.db.UserRepository;
import pti.sb_amoba_rest.dto.RankDto;
import pti.sb_amoba_rest.dto.UserDto;
import pti.sb_amoba_rest.model.GameRank;
import pti.sb_amoba_rest.model.User;

@Service
public class AppService {

	private UserRepository userRepository;
	private RankRepository rankRepository;
	
	
	@Autowired
	public AppService(UserRepository userRepository, RankRepository rankRepository) {
		super();
		this.userRepository = userRepository;
		this.rankRepository = rankRepository;
	}
	
	
	
	
	public UserDto examUserLogin(String name, String password) {
		
		UserDto userDto = null;
		
		Optional<User> userOpt = userRepository.getUserByNameAndPassword(password, name);
		
		if(userOpt.isEmpty() == false) {
			
			Integer score = 500;
			Integer life = 0;
			User user = userOpt.get();
			
			List<GameRank> gameRankList =  rankRepository.getOrderedGameRankListById(user.getId());
			
			if(gameRankList.size() > 0) {
				
				score = gameRankList.get(0).getScore();
				life = gameRankList.get(0).getLife();
	
			}
			
			userDto = new UserDto(
					user.getId(),
					user.getName(),
					score,
					life);
			
			
		}
		

		return userDto;
	}

	public void saveNewRank(RankDto rankDto) {
		
		GameRank gameRank = new GameRank();
		gameRank.setLife(rankDto.getLife());
		gameRank.setScore(rankDto.getScore());
		gameRank.setUserId(rankDto.getUserId());
		rankRepository.save(gameRank);
		
	}



	
	
}
