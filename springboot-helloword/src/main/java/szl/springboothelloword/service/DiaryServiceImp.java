package szl.springboothelloword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import szl.springboothelloword.mapper.diaryMapper;
import szl.springboothelloword.pojo.diary;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DiaryServiceImp {

	@Autowired
	private diaryMapper diaryMapper;

	public List<diary> queryDiaryList(){
		return diaryMapper.queryDiaryList();
	}

	public void addDiary(String time, String details){
		diaryMapper.addDiary(time,details);
	}

	public void deleteDiary(){
		diaryMapper.deleteDiary();
	}



	//增加一个学生的日志信息
	public void addStudentDiary(String studentID){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String str="成功添加一名学号为"+studentID+"的学生";
		addDiary(LocalDateTime.now().format(df),str);
	}

	//删除一个学生的日志信息
	public void deleteStudentDiary(String studentID){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String str="成功删除一名学号为"+studentID+"的学生";
		addDiary(LocalDateTime.now().format(df),str);
	}

	//学生入住日志信息
	public void studentLiveDiary(String studentID,String dorm){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String str="学号"+studentID+"的学生成功入住寝室"+dorm;
		addDiary(LocalDateTime.now().format(df),str);
	}

	//学生退寝日志信息
	public void studentlifeDiary(String studentID,String dorm){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String str="学号"+studentID+"的学生成功退出寝室"+dorm;
		addDiary(LocalDateTime.now().format(df),str);
	}

	//清空宿舍日志
	public void clearDiary(String dorm){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String str="成功清空寝室"+dorm;
		addDiary(LocalDateTime.now().format(df),str);
	}

	//通过时间搜索日志
	public List<diary> selectDiary(String time){
		String[] str=time.split("/");
		List<diary> list = queryDiaryList();
		List<diary> diarys=new ArrayList<>();
		if (list.size()==0){
			return diarys;
		}
		for (diary diary:list){
			String[] str2=diary.getTime().substring(0,10).split("-");
			if (str[0].equals(str2[2])&&str[1].equals(str2[1])&&str[2].equals(str2[0])){
				diarys.add(diary);
			}
		}
		return diarys;
	}

}
