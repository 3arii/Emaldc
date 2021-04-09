package Email_Application;

public class Emails {

  private static String user_first_name;
  private static String user_last_name;
  private static String user_department;
  private static String user_company_name;
  private static String user_password;

  public Emails(String first_name, String last_name, String company_name, String password) {
    user_first_name = first_name;
    user_last_name = last_name;
    user_company_name = company_name;
    user_password = password;
  }

  public static void departmentTaker(String department) {
    if (department.equals("nan")) {
      user_department = "";
    } else {
      user_department = department;
    }
  }

  public static String emailCreator(String first_name, String last_name, String company_name, String department) {

    String user_email = (first_name + "." + last_name + "@" + department + "." + company_name + ".com");
    return user_email;

  }

  // Getter methods

  public String getName() {
    return user_first_name;
  }

  public String getSurname() {
    return user_last_name;
  }

  public String getCompanyName() {
    return user_company_name;
  }

  public String getDepartment() {
    return user_department;
  }

  public String getPassword() {
    return user_password;
  }

  // Setter Methods

  public static void setName(String name) {
    user_first_name = name;
  }

  public static void setSurname(String surname) {
    user_last_name = surname;
  }

  public static void setCompanyName(String company_name) {
    user_company_name = company_name;
  }

  public static void setDepertmant(String depertmant) {
    user_department = depertmant;
  }

  public static void setPassword(String password) {
    user_password = password;
  }

}
