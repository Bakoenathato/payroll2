package za.ac.cput.domain.demography;

public class Gender {

    private String id;

    private String description;

    private Gender(){

    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
