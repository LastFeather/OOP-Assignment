//name	: mikhaya josheba rumondang hutagalung
//nim	: 2201742343
//class	: LJ01

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Assignment {
	Scanner scan = new Scanner(System.in);
	ArrayList<Patient> arrPatient = new ArrayList<>();
	Vector<UrgentPatient> vecPatient = new Vector<>();
	
	public Assignment() {
		int menu = 0;
		
		do {
//			if(vecPatient.size() == 0 && arrPatient.size() == 0){
			if(vecPatient.isEmpty() && arrPatient.isEmpty()){  // bisa pake ini juga untuk gantiin yang diatas
//				size -> untuk mendapatkan jumlah object yang tersimpan
//						dapat digunakan pada vector dan arraylist
//				isEmpty -> kalau ngga ada isinya
				System.out.println("There is no patient queued.");
				System.out.println();
//				println -> untuk mengeluarkan output berupa kalimat dan
//							langsung di enter atau lanjut ke baris
//							berikutnya
			}
			else{
				System.out.println();
				ViewData();
			}
			
			System.out.println("=================");
			System.out.println("| Mika Hospital |");
			System.out.println("=================");
			System.out.println("1. Add patient data");
			System.out.println("2. Add urgent patient data");
			System.out.println("3. Serve patient");
			System.out.println("4. Serve all patient");
			
			do {
				System.out.print(">> ");
//				print -> untuk mengeluarkan output berupa kalimat tanpa
//							diberi enter atau tidak lanjut ke baris
//							berikutnya
				
				try {
					menu = scan.nextInt(); scan.nextLine();
//					nextInt -> untuk scan Integer
//					scan.nextLine -> untuk mengambil enter setelah input angka
				} catch (Exception e) {
					menu = -1;
				}
			} while (menu < 1 || menu > 4);
			
			switch(menu){
			case 1 :
				AddPatientData();
				break;
			case 2 :
				AddUrgentPatientData();
				break;
			case 3 :
				ServePatient();
				break;
			case 4 :
				ServeAllPatient();
				break;
			}
		} while (menu != 4);
		
		System.out.println();
		System.out.println("Thank you for using this program.");
	}

	public void ViewData() {
		int length = vecPatient.size();
		for(int i = 0 ; i < length ; i++){
			System.out.println(i+1 + ". " + vecPatient.get(i).getName() +
					", " + vecPatient.get(i).getAge() + " y.o, " +
					vecPatient.get(i).getWeight() + " Kg, Blood Type: " +
					vecPatient.get(i).getBlood_type());
//			get -> untuk mengambil apa yang telah tersimpan
//					dapat digunakan oleh vector dan arraylist
		}
		
		length = arrPatient.size();
		for(int i = 0 ; i < length ; i++){
			System.out.println(i+1+vecPatient.size() + ". " + arrPatient.get(i).getName() +
					", " + arrPatient.get(i).getAge() + " y.o, " +
					arrPatient.get(i).getWeight() + " Kg, Blood Type: " +
					arrPatient.get(i).getBlood_type());
		}
	}
	
	public void AddPatientData() {
		String name = null, blood_type = null, newName = null;
		int age = 0, weight = 0;
		
		int check = 1;
		do {
			do {
				System.out.print("Input name: ");
				name = scan.nextLine();

				int length = name.length();
				for (int i = 0; i < length; i++) {
					if (!Character.isLetter(name.charAt(i))) {
//						isLetter -> untuk melakukan pemastian apakah itu
//									adalah huruf atau bukan
						check = -1;
						break;
					}
				}
			} while (check == -1);
			
			if(name.charAt(0) >= 97 && name.charAt(0) <= 122){
//				charAt -> untuk mengarahkan pada index yang ke berapa
				newName = Character.toUpperCase(name.charAt(0)) +
						name.substring(1);
//				toUpperCase -> untuk mengubah huruf kecil menjadi huruf
//								besar, atau dari lowercase jadi uppercase
				name = String.valueOf(newName);
				name = Character.toUpperCase(name.charAt(0)) + name.substring(1); //mungkin ini bisa juga?
//				valueOf -> untuk mendapatkan kalimat yang ada pada
//							variabel tersebut
			}
		} while (name.length() < 5 || name.length() > 10);
//		length -> untuk mendapatkan panjang dari kalimat di dalam variabel 
		
		do {
			System.out.print("Input age: ");
			try {
				age = scan.nextInt();
			} catch (Exception e) {
				age = -1;
			}
			scan.nextLine();
		} while (age < 0);
		
		do {
			System.out.print("Input weight: ");
			try {
				weight = scan.nextInt();
			} catch (Exception e) {
				weight = -1;
			} 
			scan.nextLine();
		} while (weight < 0);
		
		do {
			System.out.print("Input blood type: ");
			blood_type = scan.nextLine();
//			nextLine -> untuk scan String
		} while (blood_type.equals("A") == false && blood_type.equals("B") ==
				false && blood_type.equals("AB") == false &&
				blood_type.equals("O") == false);
//		equals -> untuk menentukan apakah sama dengan atau tidak
		
		arrPatient.add(new Patient(name, age, weight, blood_type));
//		add -> untuk memasukan object
//				dapat digunakan oleh vector dan arraylist
		
		System.out.println("Input data success!");
	}
	
	public void AddUrgentPatientData() {
		String name = null, blood_type = null;
		int age = 0, weight = 0;
		
		int check = 1;
		do{
			do {
				System.out.print("Input name: ");
				name = scan.nextLine();
				
				int length = check = name.length();
				for (int i = 0 ; i < length ; i++) {
					if (!Character.isLetter(name.charAt(i))){
						check = -1;
						break;
					}
				} 
			} while (check == -1);
			
			if(name.charAt(0) >= 97 && name.charAt(0) <= 122){
				String newName = Character.toUpperCase(name.charAt(0)) +
						name.substring(1);
				name = String.valueOf(newName);
			}
		} while(name.length() < 5 || name.length() > 10);
		
		do {
			System.out.print("Input age: ");
			try {
				age = scan.nextInt();
			} catch (Exception e) {
				age = -1;
			}
			scan.nextLine();
		} while (age < 0);
		
		do {
			System.out.print("Input weight: ");
			try {
				weight = scan.nextInt();
			} catch (Exception e) {
				weight = -1;
			} 
			scan.nextLine();
		} while (weight < 0);
		
		do {
			System.out.print("Input blood type: ");
			blood_type = scan.nextLine();
		} while (blood_type.equals("A") == false && blood_type.equals("B")
				== false && blood_type.equals("AB") == false &&
				blood_type.equals("O") == false);
		
		vecPatient.add(new UrgentPatient(name, age, weight, blood_type));
		
		System.out.println("Input data success!");
	}
	
	public void ServePatient() {
		if(vecPatient.size() != 0){
			vecPatient.removeElementAt(0);
//			removeElementAt -> menghapus object berdasarkan index pada
//								vector dan membuat object-object di atasnya
//								turun 1
		}
		else{
			arrPatient.remove(0);
//			remove -> menghapus object berdasarkan index pada arraylist dan
//						membuat object-object di kanannya bergeser ke kiri
		}
		
		System.out.println("Patient served!");
	}
	
	public void ServeAllPatient() {
		vecPatient.removeAllElements();
//		removeAllElements() -> untuk menghapus semua object yang terdapat
//								pada vector
		arrPatient.clear();
//		clear -> untuk menghapus semua object yang terdapat pada arraylist
		System.out.println("All patients served!");
	}
	
	public static void main(String[] args) {
		new Assignment();
	}

}
