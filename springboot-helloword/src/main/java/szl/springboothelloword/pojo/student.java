package szl.springboothelloword.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {

	private int id;
	private String studentnumber;
	private String name;
	private String sex;
	private String dorm;


}
