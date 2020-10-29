package szl.springboothelloword.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dorm {

	private int id;
	private String dormnum;
	private int maxpeople;
	private int existedpeople;
	private int floor;
	private int hostel;

}
