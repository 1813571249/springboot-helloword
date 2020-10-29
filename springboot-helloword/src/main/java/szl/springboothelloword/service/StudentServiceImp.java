package szl.springboothelloword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import szl.springboothelloword.mapper.studentMapper;
import szl.springboothelloword.pojo.student;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StudentServiceImp {

	@Autowired
	private studentMapper studentMapper;

	//获得所有学生列表
	public List<student> queryStudentList() {
		return studentMapper.queryStudentList();
	}

	//通过寝室查找学生
	public List<student> queryBydorm(String dorm) {
		return studentMapper.queryBydorm(dorm);
	}

	//通过学号查找学生
	public student queryByStudentID(String studentID) {
		return studentMapper.queryByStudentID(studentID);
	}

	//删除学生
	public String deleteByStudentID(String studentID) {
		if (queryByStudentID(studentID) != null) {
			if (queryByStudentID(studentID).getDorm() == null) {
				studentMapper.deleteByStudentID(studentID);
				return "删除成功";
			} else {
				return "删除失败，请先退寝";
			}

		} else return "删除失败,该用户不存在";
	}

	//通过学号查找学生
	public boolean updateByStudentID(String studentID) {

		if (queryByStudentID(studentID).getDorm().equals("")) {
			return false;
		} else {
			studentMapper.updateByStudentID(studentID);
			return true;
		}
	}

	//添加学生
	public boolean addStudent(String studentID, String name, String sex) {

		String pattern = "[0-9]{6}";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(studentID);

		if (!m.matches()){
			return false;
		}

		if (!sex.equals("男") && !sex.equals("女")) {
			return false;
		}

		if (name.length() > 5 || name.length() < 2) {
			return false;
		}

		if (queryByStudentID(studentID) == null) {
			studentMapper.addStudent(studentID, name, sex);
			return true;
		} else return false;
	}

	//学生入住
	public boolean studentLive(String studentID,String dorm){
		if (studentMapper.queryByStudentID(studentID)!=null) {
			if (studentMapper.queryByStudentID(studentID).getDorm()==null) {
				studentMapper.studentLive(studentID, dorm);
				return true;
			}else return false;

		}else return false;
	}

	//清空指定宿舍的学生
	public void clear(String dorm){
		List<student> students =studentMapper.queryBydorm(dorm);
		for (student student:students){
			updateByStudentID(student.getStudentnumber());
		}
	}
}
