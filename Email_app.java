package Email_Application;

import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Email_app {

  private static String user_password;
  private static Random string_randomizer;
  private static boolean password_taker;
  private static Emails user_email;
  private static boolean email_app;
  private static String created_user_email;
  private static String user_name;

  public static void main(String[] args) {

    // Initialize the Scanner app
    Scanner get_input = new Scanner(System.in);

    // Initialize the Random app
    string_randomizer = new Random();

    boolean email_creator = true;
    while (email_creator) {
      System.out.println("Enter a command ( Create: Creates a new e-mail / Exit: Exits the system)");
      String command = get_input.nextLine();

      if (command.equals("Exit")) {
        email_creator = false;
      } else if (command.equals("Create")) {
        System.out.println("Enter your first name:");
        String user_first_name = get_input.nextLine();

        System.out.println("Enter your last name:");
        String user_last_name = get_input.nextLine();

        System.out.println("Enter your department: (Enter \"nan\" if the department is to be left empty)");
        String user_department = get_input.nextLine();

        System.out.println("Enter company name:");
        String user_company = get_input.nextLine();

        System.out.println("Do you confirm your selection? " + "\nName: " + user_first_name + "\nLast Name: "
            + user_last_name + "\nDepartment: " + user_department + "\nComapny: " + user_company + "\nType y or n");
        String user_selection_confirmation = get_input.nextLine();

        if (user_selection_confirmation.equals("y")) {

          String user_password = password_creator();

          user_email = new Emails(user_first_name, user_last_name, user_company, user_password);
          // Add depertmant
          user_email.departmentTaker(user_department);
          // Create the user e-mail
          created_user_email = user_email.emailCreator(user_first_name, user_last_name, user_company, user_department);
          System.out.println("Your pre-generated password is: " + user_password);

          password_taker = true;
          email_creator = false;
        } else if (user_selection_confirmation.equals("n")) {
          email_creator = true;
        } else {
          System.out.println("Either enter y or n as values for this function!");
        }
        System.out.println("Welcome to the e-mail alteration application.");
        while (password_taker) {
          System.out.println("Name: ");
          String entered_name = get_input.nextLine();

          System.out.println("Password: ");
          String entered_password = get_input.nextLine();

          user_name = user_email.getName();
          user_password = user_email.getPassword();

          if (entered_name.equals(user_name) && entered_password.equals(user_password)) {
            System.out.println("Success!");
            password_taker = false;
            email_app = true;
          } else {
            System.out.println("Your entered name or password doesn't match the credidentals provided.");
          }
          while (email_app) {
            System.out
                .println("Registered name: " + user_email.getName() + "\n" + "Registered e-mail: " + created_user_email);
            System.out.println(
                "Enter your command (Change name: changes name / Change password: changes password / Get password: prints the password / Exit: exits the system)");
            String email_app_command = get_input.nextLine();

            if (email_app_command.equals("Exit")) {
              email_app = false;
            } else if (email_app_command.equals("change password")) {
              System.out.println("Enter your current password:");
              String test_password = get_input.nextLine();

              if (test_password.equals(user_password)) {
                System.out.println("Success \n Enter your new password:");
                String new_password = get_input.nextLine();

                user_email.setPassword(new_password);
              } else {
                System.out.println("The password you provided was wrong");
              }
            } else if (email_app_command.equals("change name")) {
              System.out.println("Enter the new name:");
              String new_name = get_input.nextLine();

              user_email.setName(new_name);
            } else if (email_app_command.equals("get password")) {
              System.out.println(user_email.getPassword());
            }
          }
        }
      }
    }
  }

  public static String password_creator() {

    // Create an initial String
    String password = "";
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    int lenght = 10;

    for (int i = 0; i <= 10; i++) {
      int index = string_randomizer.nextInt(alphabet.length());
      char randomChar = alphabet.charAt(index);
      password = (password + randomChar);

    }
    return password;
  }
}
