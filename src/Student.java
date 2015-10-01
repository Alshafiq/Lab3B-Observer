/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */
import java.util.Observable;
import java.util.Observer;
import java.util.Date;

public class Student implements Observer {
	private String name;
	private Date midterm;
	private Prof prof;

	public Student(String aName, Prof p) {
		this.name = aName;
		this.prof = p;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}
	
	@Override
	public void update(Observable prof, Object obj) {
		// TODO Auto-generated method stub
		if (prof.equals(this.prof))
		{
			boolean study = (boolean) obj;
			Date  mid = this.prof.getMidterm();
			
			if (study)
			{
				study(mid);
			}
			else if (!study)
			{
				party(mid);
			}
		}
	}
}
