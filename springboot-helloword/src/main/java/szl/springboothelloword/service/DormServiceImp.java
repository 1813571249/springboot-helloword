package szl.springboothelloword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import szl.springboothelloword.mapper.dormMapper;
import szl.springboothelloword.pojo.dorm;

import java.util.List;

@Component
public class DormServiceImp {

	@Autowired
	private dormMapper dormMapper;

	public List<dorm> queryDormList(){
		return dormMapper.queryDormList();
	}

	public dorm queryById(String dormnum){
		return dormMapper.queryById(dormnum);
	}

	public void updateDorm(String dormnum){
		dormMapper.updateDorm(dormnum);
	}

	public void addStudent(String dormnum){
		dormMapper.addStudent(dormnum);
	}

	public void clear(String dormnum,int num){
		dormMapper.clear(dormnum,num);
	}

	public String studentLive(String dormnum){
		if (dormMapper.queryById(dormnum)==null){
			return "寝室不存在";
		}else if(dormMapper.queryById(dormnum).getExistedpeople()>3){
				return "寝室已满";
		}
		else return "ok";
	}


}
