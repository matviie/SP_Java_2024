import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {

        // Ініціалізація масиву студентів
        Student[] students = {
                new Student("John",     "Doe",       LocalDate.of(2001, 6,  15), "CS-101"),
                new Student("Emily",    "Smith",     LocalDate.of(2002, 3,  22), "CS-102"),
                new Student("Michael",  "Johnson",   LocalDate.of(2000, 11, 8),  "CS-103"),
                new Student("Sarah",    "Williams",  LocalDate.of(2001, 7,  30), "CS-104"),
                new Student("John",     "Brown",     LocalDate.of(1999, 9,  25), "CS-105"),
                new Student("Emma",     "Jones",     LocalDate.of(2002, 5,  12), "CS-106"),
                new Student("John",     "Garcia",    LocalDate.of(2000, 1,  19), "CS-107"),
                new Student("Olivia",   "Martinez",  LocalDate.of(2001, 8,  3),  "CS-108"),
                new Student("John",     "Rodriguez", LocalDate.of(1998, 12, 18), "CS-109"),
                new Student("Sophia",   "Hernandez", LocalDate.of(2002, 4,  10), "CS-110")
        };

        // Виведення інформації про студентів
        for (Student student : students) {
            System.out.println(student);
        }


        System.out.println("---------сортування---------");
        // Сортування студентів: спочатку за ім'ям, потім за прізвищем (у зворотному порядку)
        Arrays.sort(students, Comparator.comparing(Student::getName)
                .thenComparing(Comparator.comparing(Student::getSurname).reversed()));

        // Виведення відсортованого списку студентів
        for (Student student : students) {
            System.out.println(student.getId() + ". " + student.getName() + " " + student.getSurname());
        }

        // Пошук конкретного студента у списку
        //Student targetStudent = new Student("Alice", "Smith", LocalDate.of(1999, 2, 2), "CS-102");
        Student targetStudent = new Student("Emma",     "Jones",     LocalDate.of(2002, 5,  12), "CS-106");

        System.out.println("--------пошук студента--------");
        boolean found = false;
        for (Student student : students) {
            if (student.equals(targetStudent)) {
                System.out.println("Знайдено: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Студента не знайдено.");
        }
    }
}