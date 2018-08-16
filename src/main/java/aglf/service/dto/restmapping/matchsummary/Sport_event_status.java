
package aglf.service.dto.restmapping.matchsummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sport_event_status {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("match_status")
    @Expose
    private String match_status;
    @SerializedName("home_score")
    @Expose
    private Integer home_score;
    @SerializedName("away_score")
    @Expose
    private Integer away_score;
    @SerializedName("winner_id")
    @Expose
    private String winner_id;
    @SerializedName("period_scores")
    @Expose
    private List<Period_score> period_scores = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatch_status() {
        return match_status;
    }

    public void setMatch_status(String match_status) {
        this.match_status = match_status;
    }

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

    public String getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(String winner_id) {
        this.winner_id = winner_id;
    }

    public List<Period_score> getPeriod_scores() {
        return period_scores;
    }

    public void setPeriod_scores(List<Period_score> period_scores) {
        this.period_scores = period_scores;
    }

}
