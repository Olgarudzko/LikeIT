package by.rudzko.likeit.dao;

public class Constant {// это общемировые константы, что класс так называешь?
    public static final String FIND_USER_REQUEST = "SELECT * FROM Profiles WHERE Login='%s' and Password='%s';";
    public static final String ADD_USER_REQUEST = "INSERT INTO Profiles (Login, Password, FK_Role) values('%s', '%s', '%d');";
    public static final String SHOW_USERS_REQUEST = "SELECT * FROM Profiles;";
    public static final String DEFINE_ROLE_REQUEST = "SELECT * FROM Roles WHERE ID='%d';";
    public static final String RATING = "Rating";
    public static final String FK_ROLE = "FK_Role";
    public static final String ROLE = "Role";
    public static final String MEMBER = "member";
    public static final String LOGIN = "login";
    public static final int NULL_RATING = 0;
    public static final int USER_ROLE = 2;

    private Constant() {
    }
}
