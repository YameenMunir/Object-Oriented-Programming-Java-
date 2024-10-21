public class MyProgram
{
    public static void main(String[] args)
    {
        // Create some LatLong objects
        LatLong londonCoords = new LatLong(51.505, -0.09);
        LatLong parisCoords = new LatLong(48.8566, 2.3522);
        LatLong californiaCoords = new LatLong(49.8566, 3.3522);

        // Create some City objects
        City london = new City("London", 8974432, londonCoords);
        City paris = new City("Paris", 2125246, parisCoords);

        // Create a Country object
        City[] ukCities = {london}; // Add more cities if needed
        Country uk = new Country("United Kingdom", 67886000, ukCities);

        // Test LatLong methods
        System.out.println("London coordinates: " + londonCoords); // Should print formatted coordinates

        try
        {
            londonCoords.setLatitude(100); // Should throw an exception
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Latitude set error: " + e.getMessage()); // Verify expected exception message
        }

        // Test City methods
        System.out.println("City of " + london.getName() + " has a population of " + london.getPopulation());

        // Test Country methods
        System.out.println("The " + uk.getName() + " has a population of " + uk.getPopulation());
        System.out.println("The first city in " + uk.getName() + " is " + uk.getCities()[0].getName()); // Assuming only one city is added

        // Test LatLong equality
        if (londonCoords.equals(parisCoords)) {
            System.out.println("London and Paris have the same coordinates (should not print)");
        } else {
            System.out.println("London and Paris have different coordinates (expected)");
        }



    }
}
