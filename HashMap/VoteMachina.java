import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VoteMachina {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Person> personArrayList = new ArrayList<>(5);
        HashMap<String, Integer> personHashMap = new HashMap<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("Name and Message for candidate:");

            String name = in.nextLine();
            String message = in.nextLine();

            personArrayList.add(new Person(name, message));
            personHashMap.put(name, 0); // person's name and his initial value of votes

        }

        while (true) {
            System.out.println("'close' for exit.\nInput the candidate's name:");
            String name = in.nextLine();

            if (name.equalsIgnoreCase("CLOSE"))
                break;

            if (personHashMap.containsKey(name))
                personHashMap.put(name, personHashMap.get(name) + 1);
            else
                System.out.println("Enter a valid name");
        }

        System.out.println("Name | Votes");

        for (Person person : personArrayList) {
            System.out.println(person.Name_Surname + " : " + personHashMap.get(person.Name_Surname));
        }

    }
}
