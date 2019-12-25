package sample.Login;

public enum LoginEnum {
    Owner,Manager,Cashier;

    private LoginEnum(){}
    public String value()
    {
        return name();
    }
    public static LoginEnum fromvalue(String v)
    {
        return valueOf(v);
    }

}



