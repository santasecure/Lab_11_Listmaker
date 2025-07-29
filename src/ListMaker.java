import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        // Declare variables
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String cmd;

        // Main menu loop
        do {
            // Display current list
            displayList(list);

            // Display menu options
            displayMenu();

            // Get user command [A, D, I, P, Q]
            cmd = SafeInput.getRegExString(in,
                    "Choose [A]dd, [D]elete, [I]nsert, [P]rint, or [Q]uit: ",
                    "[AaDdIiPpQq]").toUpperCase();

            // Process command
            switch (cmd) {
                case "A":
                    addItem(list, in);
                    break;
                case "D":
                    deleteItem(list, in);
                    break;
                case "I":
                    insertItem(list, in);
                    break;
                case "P":
                    displayList(list);
                    break;
                case "Q":
                    if (!SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        cmd = "X"; // cancel quit if user says no
                    }
                    break;
            }

        } while (!cmd.equals("Q"));
    }

    // Display the command menu
    private static void displayMenu() {
        // Pseudocode:
        // DISPLAY menu options
        System.out.println("\nMenu Options:");
        System.out.println("[A] Add an item");
        System.out.println("[D] Delete an item");
        System.out.println("[I] Insert an item");
        System.out.println("[P] Print the list");
        System.out.println("[Q] Quit");
    }

    // Display the current list
    private static void displayList(ArrayList<String> list) {
        // Pseudocode:
        // DISPLAY numbered list or "List is empty"
        System.out.println("\nCurrent List:");
        if (list.size() == 0) {
            System.out.println("   (List is empty)");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d: %s\n", i + 1, list.get(i));
            }
        }
        System.out.println();
    }

    // Add an item to the end of the list
    private static void addItem(ArrayList<String> list, Scanner in) {
        // Pseudocode:
        // PROMPT user for item text
        // ADD item to end of list
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add: ");
        list.add(item);
    }

    // Delete and Insert methods will come next
    private static void deleteItem(ArrayList<String> list, Scanner in) {
        // Placeholder
    }

    private static void insertItem(ArrayList<String> list, Scanner in) {
        // Placeholder
    }
}