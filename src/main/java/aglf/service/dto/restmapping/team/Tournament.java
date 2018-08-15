
package aglf.service.dto.restmapping.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tournament {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sport")
    @Expose
    private Sport_ sport;
    @SerializedName("category")
    @Expose
    private Category_ category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport_ getSport() {
        return sport;
    }

    public void setSport(Sport_ sport) {
        this.sport = sport;
    }

    public Category_ getCategory() {
        return category;
    }

    public void setCategory(Category_ category) {
        this.category = category;
    }

}
