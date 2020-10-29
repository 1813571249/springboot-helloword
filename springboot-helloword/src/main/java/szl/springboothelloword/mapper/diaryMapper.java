package szl.springboothelloword.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import szl.springboothelloword.pojo.diary;

import java.util.List;

@Mapper
@Repository
public interface diaryMapper {

	List<diary> queryDiaryList();
	void addDiary(String time, String details);
	void deleteDiary();
}
