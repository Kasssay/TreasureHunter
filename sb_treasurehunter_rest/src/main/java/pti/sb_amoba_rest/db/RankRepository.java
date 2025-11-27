package pti.sb_amoba_rest.db;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pti.sb_amoba_rest.model.GameRank;

@Repository
public interface RankRepository extends CrudRepository<GameRank,Integer>{

	@Query("SELECT * FROM game_ranking WHERE user_id =:userId ORDER BY score ASC , life DESC")
	public List<GameRank> getOrderedGameRankListById(
			@Param("userId") int id);
}
