public class Patient {
    public int id;
    public String name;
    public int age;
    public String disease;
    public String doctor;

    public Patient(int id, String name, int age, String disease, String doctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = doctor;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Disease: " + disease + " | Doctor: " + doctor);
    }

}
