/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class Prof extends Observable{
	private String name;
	private Date midtermDate;
	//private ArrayList<Student> students;
	private TeachingAssistant ta;
	private Student std;

	public Prof(String aName) {
		this.name = aName;
		//this.students = new ArrayList<Student>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		//for(Student s: this.students){
		//	s.study(date);
		//}
		//ta.proctor(date);
		setChanged();
		notifyObservers(true);
		
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		//for(Student s: this.students){
		//	s.party(date);
		///}
		//ta.postpone(date);
		setChanged();
		notifyObservers(false);
		
	}
	
	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		//this.students.add(s);
		this.std = s;
	}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer", p);
		Student s2 = new Student("Bart", p);
		TeachingAssistant ta = new TeachingAssistant("Michael", p);
	
		p.addObserver(ta);
		p.addObserver(s);
		p.addObserver(s2);
		//p.addStudent(s);
		//p.addStudent(s2);
		//p.setTA(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
