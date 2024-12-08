import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    private String group;
    private boolean is_full_time = true;

    public Student(String name, String surname, LocalDate birthDate, String group) {
        this.id = idCounter++; // Автоматичне присвоєння унікального ID
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.group = group;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getGroup() { return group; }
    public boolean is_full_time() { return is_full_time; }

    @Override
    public String toString() {
        // Представлення об'єкта у вигляді рядка
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // перевірка посилань
        if (o == null || getClass() != o.getClass()) return false; // перевірка на нуль і чи належать обʼєкти одному класу
        Student student = (Student) o;
        return  Objects.equals(surname, student.surname) &&
                Objects.equals(name, student.name) &&
                Objects.equals(birthDate, student.birthDate); // Перевірка дати народження
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate); 
    }
}
