
package aglf.service.dto.restmapping.matchsummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Period_score {

    @SerializedName("home_score")
    @Expose
    private Integer home_score;
    @SerializedName("away_score")
    @Expose
    private Integer away_score;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("number")
    @Expose
    private Integer number;

    public Integer getHome_score() {
        return home_score;
    }

    public void setHome_score(Integer home_score) {
        this.home_score = home_score;
    }

    public Integer getAway_score() {
        return away_score;
    }

    public void setAway_score(Integer away_score) {
        this.away_score = away_score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
