
package aglf.service.dto.restmapping.matchlineups;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sport_event {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("scheduled")
    @Expose
    private String scheduled;
    @SerializedName("start_time_tbd")
    @Expose
    private Boolean start_time_tbd;
    @SerializedName("tournament_round")
    @Expose
    private Tournament_round tournament_round;
    @SerializedName("season")
    @Expose
    private Season season;
    @SerializedName("tournament")
    @Expose
    private Tournament tournament;
    @SerializedName("competitors")
    @Expose
    private List<Competitor> competitors = null;
    @SerializedName("venue")
    @Expose
    private Venue venue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public Boolean getStart_time_tbd() {
        return start_time_tbd;
    }

    public void setStart_time_tbd(Boolean start_time_tbd) {
        this.start_time_tbd = start_time_tbd;
    }

    public Tournament_round getTournament_round() {
        return tournament_round;
    }

    public void setTournament_round(Tournament_round tournament_round) {
        this.tournament_round = tournament_round;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

}
