
package aglf.service.dto.restmapping.matchlineups;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Substitute {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("jersey_number")
    @Expose
    private Integer jersey_number;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getJersey_number() {
        return jersey_number;
    }

    public void setJersey_number(Integer jersey_number) {
        this.jersey_number = jersey_number;
    }

}
