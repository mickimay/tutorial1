import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    locale = new Locale(language, country);
    this.name = name;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + name;
  }

  public static void main(String[] args) {
    String language = args[0];
    String country = args[1];
    String name = args[2];
    if((language.length()!=2)||(country.length()!=2)) {
      throw new IllegalArgumentException("Error: arg0 (language) and arg1 (country) must each be exactly two characters long");
    }
    else {
      Greeter greeter = new Greeter(language, country, name);
      System.out.println(greeter.sayHello());
    }
  }
}
