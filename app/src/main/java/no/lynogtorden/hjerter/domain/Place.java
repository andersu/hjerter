package no.lynogtorden.hjerter.domain;

import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("ID")
    private long id;

    @SerializedName("Name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
