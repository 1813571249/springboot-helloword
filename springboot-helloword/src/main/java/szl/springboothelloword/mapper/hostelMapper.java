package szl.springboothelloword.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import szl.springboothelloword.pojo.hostel;

import java.util.List;

@Mapper
@Repository
public interface hostelMapper {

	List<hostel> queryHostelList();

	void updateHostel(int id);

	void addStudent(int id);

	void clear(int id,int num);

}
