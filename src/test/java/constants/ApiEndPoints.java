package constants;

public class ApiEndPoints {

    public static final String CROCODILES = "my/crocodiles/";
    public static String SINGLE_CROCODILE(String id) {return CROCODILES + id + "/";}
    public static final String PUBLIC_CROCODILE = "public/crocodiles/";
    public static final String LOGIN = "auth/token/login/";
}
