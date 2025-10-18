import java.util.*;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    Hospital hospital = new Hospital();
    hospital.loadFromFile();
        int choice;

        System.out.println("🏥 Welcome to Children's Hospital Management System 🏥");

        do {
            System.out.println("\n1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            while (true) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                try {
                    choice = Integer.parseInt(line);
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Please enter a number for your choice: ");
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    int age = -1;
                    while (age < 0) {
                        System.out.print("Enter age: ");
                        String aLine = sc.nextLine().trim();
                        try {
                            age = Integer.parseInt(aLine);
                            if (age < 0) System.out.println("Age must be non-negative.");
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid integer for age.");
                        }
                    }
                    System.out.print("Enter disease: ");
                    String disease = sc.nextLine().trim();
                    System.out.print("Enter doctor name: ");
                    String doctor = sc.nextLine().trim();
                    hospital.addPatient(name, age, disease, doctor);
                    break;

                case 2:
                    hospital.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter patient ID: ");
                    int id = sc.nextInt();
                    hospital.searchPatient(id);
                    break;

                case 4:
                    System.out.println("👋 Thank you for using the Hospital Management System!");
                    hospital.saveToFile();
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}   
    


