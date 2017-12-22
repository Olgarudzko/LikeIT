package by.rudzko.likeit.dao;

public class LikeItConstant {
    public static final String FIND_USER_REQUEST = "SELECT Profiles.id, login, password, Roles.role, rating FROM Profiles INNER JOIN Roles on Profiles.fk_role=Roles.id WHERE login='%s' and password='%s';";
    public static final String ADD_USER_REQUEST = "INSERT INTO Profiles (Login, Password, FK_Role) values('%s', '%s', '%d');";
    public static final String SHOW_USERS_REQUEST = "SELECT Profiles.id, login, password, Roles.role, rating FROM Profiles INNER JOIN Roles on Profiles.fk_role=Roles.id;";
    public static final String RATING = "Rating";
    public static final String FK_ROLE = "FK_Role";
    public static final String ROLE = "Role";
    public static final String MEMBER = "member";
    public static final String LOGIN = "login";
    public static final int NULL_RATING = 0;

    private LikeItConstant() {
    }
}
