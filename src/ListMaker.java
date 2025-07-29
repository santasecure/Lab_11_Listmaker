import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // ✅ Added Scanner
        ArrayList<String> list = new ArrayList<>();
        String cmd;

        do {
            displayList(list);
            displayMenu();

            cmd = SafeInput.getRegExString(in, "Choose [A]dd, [D]elete, [I]nsert, [P]rint, or [Q]uit: ", "[AaDdIiPpQq]").toUpperCase();

            switch (cmd) {
                case "A":
                    addItem(list);
                    break;
                case "D":
                    deleteItem(list);
                    break;
                case "I":
                    insertItem(list);
                    break;
                case "P":
                    displayList(list);
                    break;
                case "Q":
                    if (!SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        cmd = "X";
                    }
                    break;
            }

        } while (!cmd.equals("Q"));
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("[A] Add an item");
        System.out.println("[D] Delete an item");
        System.out.println("[I] Insert an item");
        System.out.println("[P] Print the list");
        System.out.println("[Q] Quit");
    }

    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        if (list.size() == 0) {
            System.out.println("   (List is empty)");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d: %s\n", i + 1, list.get(i));
            }
        }
        System.out.println();  // blank line after list
    }

    // These will be filled in step by step
    private static void addItem(ArrayList<String> list) {
        // We'll write this next
    }

    private static void deleteItem(ArrayList<String> list) {
        // Coming later
    }

    private static void insertItem(ArrayList<String> list) {
        // Coming later
    }
}