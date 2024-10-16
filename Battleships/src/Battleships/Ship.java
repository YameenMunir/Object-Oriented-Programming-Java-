package Battleships;

public class Ship
{
    private final String name;
    private final String code;

    public Ship(String name, String code)
    {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
