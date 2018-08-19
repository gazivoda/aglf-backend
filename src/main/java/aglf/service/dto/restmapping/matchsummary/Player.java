
package aglf.service.dto.restmapping.matchsummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("substituted_in")
    @Expose
    private Integer substituted_in;
    @SerializedName("substituted_out")
    @Expose
    private Integer substituted_out;
    @SerializedName("goals_scored")
    @Expose
    private Integer goals_scored;
    @SerializedName("goals_conceded")
    @Expose
    private Integer assists;
    @SerializedName("own_goals")
    @Expose
    private Integer own_goals;
    @SerializedName("yellow_cards")
    @Expose
    private Integer yellow_cards;
    @SerializedName("yellow_red_cards")
    @Expose
    private Integer yellow_red_cards;
    @SerializedName("red_cards")
    @Expose
    private Integer red_cards;
    @SerializedName("penalty_goals_scored")
    @Expose
    private Integer penalty_goals_scored;

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

    public Integer getSubstituted_in() {
        return substituted_in;
    }

    public void setSubstituted_in(Integer substituted_in) {
        this.substituted_in = substituted_in;
    }

    public Integer getSubstituted_out() {
        return substituted_out;
    }

    public void setSubstituted_out(Integer substituted_out) {
        this.substituted_out = substituted_out;
    }

    public Integer getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(Integer goals_scored) {
        this.goals_scored = goals_scored;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getOwn_goals() {
        return own_goals;
    }

    public void setOwn_goals(Integer own_goals) {
        this.own_goals = own_goals;
    }

    public Integer getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(Integer yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public Integer getYellow_red_cards() {
        return yellow_red_cards;
    }

    public void setYellow_red_cards(Integer yellow_red_cards) {
        this.yellow_red_cards = yellow_red_cards;
    }

    public Integer getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(Integer red_cards) {
        this.red_cards = red_cards;
    }

    public Integer getPenalty_goals_scored() {
        return penalty_goals_scored;
    }

    public void setPenalty_goals_scored(Integer penalty_goals_scored) {
        this.penalty_goals_scored = penalty_goals_scored;
    }

}
