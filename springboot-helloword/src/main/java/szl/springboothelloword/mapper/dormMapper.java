package szl.springboothelloword.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import szl.springboothelloword.pojo.dorm;

import java.util.List;

@Mapper
@Repository
public interface dormMapper {

	List<dorm> queryDormList();

	void updateDorm(String dormnum);

	dorm queryById(String dormnum);

	void addStudent(String dormnum);

	void clear(String dormnum,int num);



}
