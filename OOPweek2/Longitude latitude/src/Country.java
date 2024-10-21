public class Country
{
    //Attributes
    private String name;
    private int population;
    private City[] cities;

    //Constructor
    public Country(String name, int population, City[] cities)
    {
        this.name = name;
        this.population = population;
        this.cities = cities;
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

    public City[] getCities()
    {
        return this.cities;
    }

}

