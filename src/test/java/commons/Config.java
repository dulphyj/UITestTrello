package commons;

public class Config {
    Config(){}
    public static String getEmail(){ return System.getProperty("email");}
    public static String getPassword(){ return System.getProperty("password");}
    public static String getUrl(){ return  System.getProperty("webUrl");}
}
