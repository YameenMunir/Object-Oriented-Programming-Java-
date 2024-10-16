package Battleships;

public class Ship
{
    //Attributes of the Ship Class
    private final String name;
    private final String code;

    //Constructor of the Ship Class
    public Ship(String name, String code)
    {
        this.name = name;
        this.code = code;
    }

    //Getter method of retrieving the Name of the Ship
    public String getName() {
        return name;
    }

    //Getter method of retrieving the Code of the Ship
    public String getCode() {
        return code;
    }
}
