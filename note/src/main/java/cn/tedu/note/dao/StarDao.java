package cn.tedu.note.dao;

import cn.tedu.note.entity.Stars;

public interface StarDao {
	Stars findStarsByUseId(String userId);
	Integer insertStars(Stars stars);
	Integer updateStars(Stars stars);

}
