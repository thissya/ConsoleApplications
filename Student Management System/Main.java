import java.util.;

class Student {

	static int totalStudent=0;
	private String studentName,rollNo,major;
	private int age;

	public Student(String studentName,String rollNo,String major,int age) {
		this.studentName=studentName;
		this.rollNo=rollNo;
		this.major=major;
		this.age=age;
		totalStudent++;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public String getMajor() {
		return major;
	}

	public int getAge() {
		return age;
	}

	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}

	public void setAge(int age) {
		if(age17) {
			this.age=age;
		}
		else {
			System.out.println(Invalid age.Please provide a valid age.);
		}
	}

	public void setMajor(String major) {
		this.major=major;
	}

	public void setRollNo(String rollNo) {
		this.rollNo=rollNo;
	}



	public String toString() {
		return Student [ name = +studentName+, Age = +age+, RollNo = +rollNo+, Major = +major+];
	}

}

class StudentManager {
	HashMapString,Student studMap = new HashMap();

	public boolean addStudent(Student student) {
		if(studMap.containsKey(student.getRollNo())) {
			System.out.println(nRoll Number + student.getRollNo()+ Already exist . Please Enter Your Correct Roll Number to Register.);
			return false;
		}
		studMap.put(student.getRollNo(),student);
		System.out.println(nStudent Added Successfully !!!);
		return true;
	}

	public void displayAllStudents() {
		int ind=1;
		for(Student studentstudMap.values()) {
			System.out.println(Student No  +ind);
			System.out.println(student);
			System.out.println(_________________________________________________________________________________________________________);
			ind++;
		}
	}

	public void search(String rollNo) {
	    if(studMap.containsKey(rollNo)){
		    System.out.println(studMap.get(rollNo));
	    }else{
	        System.out.println(rollNo+ doesn't Exists.);
	    }
	       
	}
	
    public void remove(String rollNo){
        if(studMap.containsKey(rollNo)){
            System.out.println(The Removed Student Details is );
            System.out.println(studMap.get(rollNo));
            studMap.remove(rollNo);
            System.out.println(Removed Successfully.);
        }else{
            System.out.println(rollNo+ doesn't Exists.);
        }
    }
}

public class Main
{
	public static final String ANSI_RESET = u001B[0m;
	public static final String ANSI_COLOR = u001B[42m;
	public static final String Yellow =u001B[33m;

	public static void main(String[] args) {
		StudentManager AIDS = new StudentManager();
		Scanner sc = new Scanner(System.in);

		System.out.println(ANSI_COLOR+Student Management Console Application.+ANSI_RESET);

		while(true) {
			System.out.println(nn);
			System.out.println(Yellow+1) Add a Student n2) Display All the Students n3) Search a Student n4) Remove a Student n5) Exit+ANSI_RESET);
			System.out.println(nSelect your option);
			int n=sc.nextInt();
			sc.nextLine ();
			switch(n) {
			case 1
				System.out.println(nEnter the Student Name );
				String name = sc.nextLine();
				System.out.println(nEnter the RollNo );
				String rollNo = sc.nextLine();
				System.out.println(nEnter the Age );
				int age = sc.nextInt();
				System.out.println(nEnter the Major );
				String major = sc.nextLine();
				sc.nextLine();
				Student student =  new Student(name,rollNo,major,age);
				AIDS.addStudent(student);
				break;
			case 2
				System.out.println(nnList of the Students);
				AIDS.displayAllStudents();
				break;
			case 3
				System.out.println(nSearch By RollNo );
				String find =sc.nextLine();
				AIDS.search(find);
				break;
			case 4
			    System.out.println(Enter the RollNo of the Student to Be Removed );
				String temp = sc.nextLine();
				AIDS.remove(temp);
				break;
			case 5
				System.exit(0);
			default
				System.out.println(Invalid Input. Choose the Correct option.);
			}
		}
	}
}