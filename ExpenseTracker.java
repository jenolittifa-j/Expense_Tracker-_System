import java.util.ArrayList;
import java.util.Scanner;

class Expense {

    int id;
    String category;
    double amount;
    String date;
    String description;

    Expense(int id, String category, double amount, String date, String description) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
}

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> list = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n========== Expense Tracker System ==========");
            System.out.println("1. Insert Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Expense ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Category : ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount : ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Date : ");
                    String date = sc.nextLine();

                    System.out.print("Enter Description : ");
                    String description = sc.nextLine();

                    list.add(new Expense(id, category, amount, date, description));

                    System.out.println("Expense Added Successfully.");
                    break;

                case 2:

                    if (list.size() == 0) {
                        System.out.println("No Expenses Found.");
                    } else {

                        System.out.println("\n---------------------------------------------------------------");
                        System.out.printf("%-5s %-15s %-10s %-15s %-20s\n",
                                "ID", "Category", "Amount", "Date", "Description");
                        System.out.println("---------------------------------------------------------------");

                        for (int i = 0; i < list.size(); i++) {

                            Expense e = list.get(i);

                            System.out.printf("%-5d %-15s %-10.2f %-15s %-20s\n",
                                    e.id, e.category, e.amount, e.date, e.description);
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Expense ID : ");
                    id = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).id == id) {

                            Expense e = list.get(i);

                            System.out.println("\nExpense Found");
                            System.out.println("ID          : " + e.id);
                            System.out.println("Category    : " + e.category);
                            System.out.println("Amount      : " + e.amount);
                            System.out.println("Date        : " + e.date);
                            System.out.println("Description : " + e.description);

                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Expense Not Found.");

                    break;

                case 4:

                    System.out.print("Enter Expense ID : ");
                    id = sc.nextInt();
                    sc.nextLine();

                    found = false;

                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).id == id) {

                            System.out.print("Enter New Category : ");
                            list.get(i).category = sc.nextLine();

                            System.out.print("Enter New Amount : ");
                            list.get(i).amount = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Enter New Date : ");
                            list.get(i).date = sc.nextLine();

                            System.out.print("Enter New Description : ");
                            list.get(i).description = sc.nextLine();

                            System.out.println("Expense Updated Successfully.");

                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Expense Not Found.");

                    break;

                case 5:

                    System.out.print("Enter Expense ID : ");
                    id = sc.nextInt();

                    found = false;

                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).id == id) {

                            list.remove(i);

                            System.out.println("Expense Deleted Successfully.");

                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Expense Not Found.");

                    break;

                case 6:

                    System.out.println("Thank You for Using Expense Tracker System.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}