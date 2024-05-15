package za.ac.cput.domain.demography;

public class Race {

    private String id;

    private String description;

    public Race() {
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
