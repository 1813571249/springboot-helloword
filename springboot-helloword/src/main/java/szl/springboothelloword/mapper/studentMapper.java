package szl.springboothelloword.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import szl.springboothelloword.pojo.student;

import java.util.List;

@Mapper
@Repository
public interface studentMapper {

	List<student> queryStudentList();
	void updateByStudentID(String studentID);
	void deleteByStudentID(String studentID);
	void addStudent(String studentID,String name,String sex);
	student queryByStudentID(String studentID);
	List<student> queryBydorm(String dorm);
	void studentLive(String studentID,String dorm);
}
