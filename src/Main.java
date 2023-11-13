import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                ArrayList<String> arrList = new ArrayList<>();
                String menuPrompt = " A : Add \n D : Delete\n P : Print\n Q : Quit\n Select From Menu Option";
                String cmd = ""; //a d p or q

                boolean done = false;
                do {

                    cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdPpQq]");
                    switch (cmd) {
                        case "A":
                        case "a":
                            addToList(in, arrList);

                            break;
                        case "D":
                        case "d":
                            deleteFromList(in,arrList);
                            break;
                        case "P":
                        case "p":
                            printList(arrList);

                            break;

                        case "Q":
                        case "q":
                            if (SafeInput.getYNConfirm(in, "Are you sure")) {
                                done= true;
                            }
                            else
                            {
                                System.out.println(" \nBack to Menu Options ");
                            }
                            break;
                    }

                } while (!done);
            }
            public static void addToList(Scanner in, ArrayList arrList) {
                String addItem = "";
                addItem = SafeInput.getNonZeroLenString(in, "Which do you like to add to the list?");
                arrList.add(addItem);
            }
            public static void deleteFromList(Scanner in, ArrayList arrList) {
                int deleteItem;
                deleteItem = SafeInput.getRangedInt(in, "Which item do you want to delete?", 1, arrList.size());
                arrList.remove(deleteItem - 1);
            }
            public static void printList(ArrayList arrList) {
                if (arrList.isEmpty()) {
                    System.out.println("No list Found!.");
                } else {
                    System.out.println("Your List:");
                    for (int i = 0; i < arrList.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1,arrList.get(i));
                    }
                }
            }

        }

