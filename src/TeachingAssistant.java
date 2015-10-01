/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TeachingAssistant implements Observer {
	private String name;
	private Date midterm;
	private Prof prof;

	public TeachingAssistant(String aName, Prof p) {
		this.name = aName;
		this.prof = p;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}

	@Override
	public void update(Observable prof, Object obj) {
		// TODO Auto-generated method stub
		if (prof.equals(this.prof))
		{
			boolean study = (boolean) obj;
			Date  mid = this.prof.getMidterm();
			//System.out.println(study);
			//System.out.println(mid);
			if (study)
			{
				proctor(mid);
			}
			else if (!study)
			{
				postpone(mid);
			}
		}
	}
	
}
