package szl.springboothelloword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import szl.springboothelloword.mapper.hostelMapper;
import szl.springboothelloword.pojo.hostel;

import java.util.List;

@Component
public class HostelServiceImp {

	@Autowired
	private hostelMapper hostelMapper;

	public List<hostel> queryHostelList(){
		return hostelMapper.queryHostelList();
	}

	public void updateHostel(int id){
		hostelMapper.updateHostel(id);
	}

	public void clear(int id,int num){
		hostelMapper.clear(id,num);
	}

	public void addStudent(int id){
		hostelMapper.addStudent(id);
	}


}
