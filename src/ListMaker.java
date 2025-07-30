import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        // Pseudocode:
        // CREATE scanner
        // CREATE ArrayList of String
        // LOOP until user chooses to quit
        //     DISPLAY current list
        //     DISPLAY menu
        //     GET user command
        //     EXECUTE command based on choice

        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String cmd;

        do {
            displayList(list);
            displayMenu();

            cmd = SafeInput.getRegExString(in,
                    "Choose [A]dd, [D]elete, [I]nsert, [P]rint, or [Q]uit ",
                    "[AaDdIiPpQq]").toUpperCase();

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
                        cmd = "X"; // cancel quit
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

    // Display the current list with line numbers
    private static void displayList(ArrayList<String> list) {
        // Pseudocode:
        // DISPLAY each item in list with its number
        // IF list is empty, say so

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
        // PROMPT for item
        // ADD to end of list

        String item = SafeInput.getNonZeroLenString(in, "Enter item to add ");
        list.add(item);
    }

    // Delete an item by number
    private static void deleteItem(ArrayList<String> list, Scanner in) {
        // Pseudocode:
        // IF list is empty, return
        // DISPLAY list
        // PROMPT for item number to delete (1 to list.size())
        // REMOVE item at (index - 1)

        if (list.size() == 0) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        displayList(list);

        int choice = SafeInput.getRangedInt(in,
                "Enter the number of the item to delete",
                1, list.size());

        String removed = list.remove(choice - 1);
        System.out.printf("\"%s\" has been removed.\n", removed);
    }

    // Insert an item at a specific position
    private static void insertItem(ArrayList<String> list, Scanner in) {
        // Pseudocode:
        // PROMPT for insert position (1 to list.size() + 1)
        // PROMPT for item
        // INSERT item at position (index - 1)

        int position = SafeInput.getRangedInt(in,
                "Enter the position to insert the new item (1 to " + (list.size() + 1) + "):",
                1, list.size() + 1);

        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert ");
        list.add(position - 1, item);
    }
}