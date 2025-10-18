import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Hospital {
    ArrayList<Patient> patients = new ArrayList<>();
    int nextId = 1;
    private final String DATA_FILE = "patients.csv";

    public void addPatient(String name, int age, String disease, String doctor) {
        Patient p = new Patient(nextId++, name, age, disease, doctor);
        patients.add(p);
        System.out.println("✅ Patient added successfully! (ID: " + p.id + ")");
    }

    public void loadFromFile() {
        File f = new File(DATA_FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length < 5) continue;
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String disease = parts[3];
                String doctor = parts[4];
                patients.add(new Patient(id, name, age, disease, doctor));
                if (id >= nextId) nextId = id + 1;
            }
            System.out.println("Loaded " + patients.size() + " patients from " + DATA_FILE);
        } catch (Exception e) {
            System.out.println("Failed to load patients: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Patient p : patients) {
                // simple CSV, no escaping
                pw.printf("%d,%s,%d,%s,%s\n", p.id, p.name, p.age, p.disease, p.doctor);
            }
            System.out.println("Saved " + patients.size() + " patients to " + DATA_FILE);
        } catch (IOException e) {
            System.out.println("Failed to save patients: " + e.getMessage());
        }
    }

    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("⚠️ No patients found.");
            return;
        }
        System.out.println("\n--- Children's Hospital Patient List ---");
        for (Patient p : patients) {
            p.display();                                                                        
        }
    }                                                                                                                           

    public void searchPatient(int id) {
        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("\n--- Patient Details ---");
                p.display();
                return;
            }
        }
        System.out.println("⚠️ Patient not found.");
    }
}

# Java / build
out/
*.class

# IDE files
.vscode/
*.iml
.idea/

# Logs and temp
*.log
*.tmp

# OS files
Thumbs.db
.DS_Store

# Runtime data — don't commit patient data unless you want to
patients.csv

