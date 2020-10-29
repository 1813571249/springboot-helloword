package szl.springboothelloword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import szl.springboothelloword.service.DiaryServiceImp;
import szl.springboothelloword.service.DormServiceImp;
import szl.springboothelloword.service.HostelServiceImp;
import szl.springboothelloword.service.StudentServiceImp;

@Controller
public class controller {

	@Autowired
	private HostelServiceImp hostelServiceImp;

	@Autowired
	private DormServiceImp dormServiceImp;

	@Autowired
	private StudentServiceImp studentServiceImp;

	@Autowired
	private DiaryServiceImp diaryServiceImp;


	@RequestMapping("/news.html")
	public String news(Model model){
		model.addAttribute("dorms", dormServiceImp.queryDormList());
		return "news";
	}

	@RequestMapping("/newsType.html")
	public String newsType(Model model){
		model.addAttribute("students", studentServiceImp.queryStudentList());
		return "newsType";
	}

	@RequestMapping("/product.html")
	public String product(Model model){
		model.addAttribute("hostels", hostelServiceImp.queryHostelList());
		return "product";
	}

	@RequestMapping("/live.html")
	public String live(String dorm,Model model){
		model.addAttribute("dorm",dorm);
		return "live";
	}

	@RequestMapping("/diary.html")
	public String diary(Model model){
		model.addAttribute("diarys",diaryServiceImp.queryDiaryList());
		return "diary";
	}

	@RequestMapping("/addStudent.html")
	public String message(){
		return "addStudent";
	}

	@ResponseBody
	@RequestMapping("/updateStudent")
	public String updateStudent(String studentID){

		if (studentServiceImp.queryByStudentID(studentID)!=null){
			try {
				hostelServiceImp.updateHostel(dormServiceImp.queryById(studentServiceImp.queryByStudentID(studentID).getDorm()).getId());
				dormServiceImp.updateDorm(studentServiceImp.queryByStudentID(studentID).getDorm());
				diaryServiceImp.studentlifeDiary(studentID,studentServiceImp.queryByStudentID(studentID).getDorm());
				studentServiceImp.updateByStudentID(studentID);

				return "退寝成功";
			}catch (Exception e){
				return "该学生没有宿舍，退寝失败";
			}

		}else {
			return "该学生没有宿舍，退寝失败";
		}

	}

	@ResponseBody
	@RequestMapping("/deleteStudent")
	public String deleteStudent(String studentID){
		diaryServiceImp.deleteStudentDiary(studentID);
		return studentServiceImp.deleteByStudentID(studentID);

	}

	@ResponseBody
	@RequestMapping("/addroleSubmit")
	public String addstudent(String studentID,String name,String sex){
		if (studentServiceImp.addStudent(studentID.trim(),name.trim(),sex.trim())){
			diaryServiceImp.addStudentDiary(studentID);
			return "添加成功";
		}
		else return "添加失败";
	}

	@RequestMapping("/student.html")
	public String student(String studentID,Model model){

		model.addAttribute("student",studentServiceImp.queryByStudentID(studentID.trim()));

		return "student";
	}

	@RequestMapping("/dorm.html")
	public String dorm(String dormId,Model model){

		model.addAttribute("dorm",dormServiceImp.queryById(dormId));
		model.addAttribute("students",studentServiceImp.queryBydorm(dormId));

		return "dorm";
	}

	@ResponseBody
	@RequestMapping("/studentLive")
	public String studentLive(String studentID,String dorm){

		if (dormServiceImp.studentLive(dorm).equals("ok")){
			if (studentServiceImp.studentLive(studentID,dorm)){
				dormServiceImp.addStudent(dorm);
				hostelServiceImp.addStudent(dormServiceImp.queryById(dorm).getHostel());
				diaryServiceImp.studentLiveDiary(studentID,dorm);
				return "成功入住";
			}
			else return "入住失败";
		}else return dormServiceImp.studentLive(dorm);


	}

	@ResponseBody
	@RequestMapping("/clear")
	public String clear(String dorm) {
		if (studentServiceImp.queryBydorm(dorm).size()==0){
			return "宿舍暂无人入住";
		}else {
			dormServiceImp.clear(dorm,studentServiceImp.queryBydorm(dorm).size());
			hostelServiceImp.clear(dormServiceImp.queryById(dorm).getHostel(),studentServiceImp.queryBydorm(dorm).size());
			studentServiceImp.clear(dorm);
			diaryServiceImp.clearDiary(dorm);
			return "成功清空宿舍"+dorm;
		}
	}

	@ResponseBody
	@RequestMapping("/deleteDiary")
	public String deleteDiary(){
		diaryServiceImp.deleteDiary();
		return "消息记录已清除";
	}


	@RequestMapping("/selectDiary")
	public String selectDiary(String time,Model model){
		model.addAttribute("diarys",diaryServiceImp.selectDiary(time));
		return "diary_2";
	}
}
