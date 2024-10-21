public class City
{
    //Attributes
    private String name;
    private int population;
    private LatLong location;

    //Constructor
    public City(String name, int population, LatLong location)
    {
        this.name = name;
        this.population = population;
        this.location = location;
    }

    //Getters
    public String getName()
    {
        return this.name;
    }

    public int getPopulation()
    {
        return this.population;
    }

    public LatLong getLocation()
    {
        return this.location;
    }

}
