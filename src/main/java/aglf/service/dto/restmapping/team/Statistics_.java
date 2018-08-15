
package aglf.service.dto.restmapping.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics_ {

    @SerializedName("matches_played")
    @Expose
    private Integer matches_played;
    @SerializedName("matches_won")
    @Expose
    private Integer matches_won;
    @SerializedName("matches_drawn")
    @Expose
    private Integer matches_drawn;
    @SerializedName("matches_lost")
    @Expose
    private Integer matches_lost;
    @SerializedName("goals_scored")
    @Expose
    private Integer goals_scored;
    @SerializedName("goals_conceded")
    @Expose
    private Integer goals_conceded;
    @SerializedName("group_name")
    @Expose
    private String group_name;
    @SerializedName("group_position")
    @Expose
    private Integer group_position;
    @SerializedName("cup_rank")
    @Expose
    private Integer cup_rank;

    public Integer getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(Integer matches_played) {
        this.matches_played = matches_played;
    }

    public Integer getMatches_won() {
        return matches_won;
    }

    public void setMatches_won(Integer matches_won) {
        this.matches_won = matches_won;
    }

    public Integer getMatches_drawn() {
        return matches_drawn;
    }

    public void setMatches_drawn(Integer matches_drawn) {
        this.matches_drawn = matches_drawn;
    }

    public Integer getMatches_lost() {
        return matches_lost;
    }

    public void setMatches_lost(Integer matches_lost) {
        this.matches_lost = matches_lost;
    }

    public Integer getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(Integer goals_scored) {
        this.goals_scored = goals_scored;
    }

    public Integer getGoals_conceded() {
        return goals_conceded;
    }

    public void setGoals_conceded(Integer goals_conceded) {
        this.goals_conceded = goals_conceded;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Integer getGroup_position() {
        return group_position;
    }

    public void setGroup_position(Integer group_position) {
        this.group_position = group_position;
    }

    public Integer getCup_rank() {
        return cup_rank;
    }

    public void setCup_rank(Integer cup_rank) {
        this.cup_rank = cup_rank;
    }

}
