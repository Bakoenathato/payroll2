package za.ac.cput.domain.demography;

public class Nationality {

    private String id;

    private String description;

    public Nationality() {
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
