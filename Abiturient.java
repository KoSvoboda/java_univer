import java.util.Arrays;

public class Abiturient implements Comparable<Abiturient>{
	
	int id;
	String surname;
	String name;
	String poBatsku;
	String address;
	String phoneNumber;
	int marks[] = new int [5];
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoBatsku() {
		return poBatsku;
	}
	public void setPoBatsku(String poBatsku) {
		this.poBatsku = poBatsku;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Abiturient [id=" + id + ", surname=" + surname + ", name=" + name + ", poBatsku=" + poBatsku
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", marks=" + Arrays.toString(marks) + "]";
	}
	public Abiturient(int id, String surname, String name, String poBatsku, String address, String phoneNumber,
			int[] marks) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.poBatsku = poBatsku;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.marks = marks;
	}
	
	public static void listBadAbitur(Abiturient m[]) {
		int n = m.length;
		System.out.println("Абитура с плохими оценками");
		for (int i = 0; i<n; i++) {
			boolean check = true;
			int a = m[i].marks.length;
			for (int j = 0; j<a; j++) {
				if (m[i].marks[j]<=4) check = false;
			}
			if (check==false) System.out.println(m[i].toString());
		}
	}
	
	public static void listGoodAbitur(Abiturient m[], double needM) {
		int n = m.length;
		System.out.println("Абитура со средним баллом выше " + needM + " :");
		for (int i = 0; i<n; i++) {
			double srb = 0;
			int a = m[i].marks.length;
			for (int j = 0; j<a; j++) {
				srb+=m[i].marks[j];
			}
			srb/=a;
			if (srb>=needM) System.out.println(m[i].toString());
		}
	}
	
	public static void listProhodAbitur(Abiturient m[], int pr) {
		int n = m.length;
		System.out.println("Абитура которая проходит:");
		Arrays.sort(m);
		for (int i = 0; i<n; i++) {
			if (pr<=0) break;
			System.out.println(m[i].toString());
			pr--;
		}
	}
	@Override
	public int compareTo(Abiturient second) { // this < second -> <0
		int n = this.marks.length;
		double sr1 = 0;
		double sr2 = 0; 
		for (int i = 0; i<n; i++) {
			sr1 += this.marks[i];
			sr2 += second.marks[i];
		}
		sr1 /= n;
		sr2 /= n;
		if (sr1>sr2) return -1;
		else if (sr1<sr2) return 1;
		else return 0;
	}
}