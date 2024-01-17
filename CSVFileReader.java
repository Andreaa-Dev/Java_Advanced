import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileReader {

    public static void main(String[] args) {
        // Replace "your_file_path.csv" with the path to your CSV file
        String filePath = "your_file_path.csv";

        try {
            List<Person> personList = readCSV(filePath);

            // Print the original data
            System.out.println("Original Data:");
            personList.forEach(System.out::println);

            // Example: Sorting by age
            System.out.println("\nSorted by Age:");
            List<Person> sortedByAge = personList.stream()
                    .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                    .collect(Collectors.toList());
            sortedByAge.forEach(System.out::println);

            // Example: Filtering by city
            System.out.println("\nFiltered by City (e.g., 'New York'):");
            List<Person> filteredByCity = personList.stream()
                    .filter(p -> p.getCity().equals("New York"))
                    .collect(Collectors.toList());
            filteredByCity.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Person> readCSV(String filePath) throws IOException {
        List<Person> personList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());
                String city = data[2].trim();

                Person person = new Person(name, age, city);
                personList.add(person);
            }
        }

        return personList;
    }
}

class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}

