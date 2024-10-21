import java.util.Objects;

public class LatLong
{
    // Attributes of the LatLong class
    private double latitude;
    private double longitude;

    // Constructor
    public LatLong(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter for latitude
    public double getLatitude()
    {
        return this.latitude;
    }

    // Getter for longitude
    public double getLongitude()
    {
        return this.longitude;
    }

    // Setter for latitude
    public void setLatitude(double value)
    {
        if((value <= 90) && (value >= -90))
        {
            this.latitude = value;
        }
        else
        {
            throw new IllegalArgumentException("Latitude must be between +90 and -90 degrees.");
        }
    }

    // Setter for longitude
    public void setLongitude(double value)
    {
        if ((value <= 180) && (value >= -180))
        {
            this.longitude = value;
        }
        else
        {
            throw new IllegalArgumentException("Longitude must be between +180 and -180 degrees.");
        }
    }

    // Method for converting to string
    @Override
    public String toString()
    {
        String latLetter = (this.latitude >= 0) ? "N" : "S";
        String longLetter = (this.longitude >= 0) ? "E" : "W";
        return String.format("%.2f%s %.2f%s", Math.abs(this.latitude), latLetter, Math.abs(this.longitude), longLetter);
    }

    // Method to check equality
    @Override
    public boolean equals(Object object)
    {f
        if (object instanceof LatLong)
        {
            LatLong other = (LatLong) object;
            return this.latitude == latitude && this.longitude == other.longitude;
        }
        else
        {
            return false;
        }
    }


}
