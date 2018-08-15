
package aglf.service.dto.restmapping.team;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamProfile {

    @SerializedName("generated_at")
    @Expose
    private String generated_at;
    @SerializedName("schema")
    @Expose
    private String schema;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("jerseys")
    @Expose
    private List<Jersey> jerseys = null;
    @SerializedName("manager")
    @Expose
    private Manager manager;
    @SerializedName("players")
    @Expose
    private List<Player> players = null;
    @SerializedName("statistics")
    @Expose
    private Statistics statistics;

    public String getGenerated_at() {
        return generated_at;
    }

    public void setGenerated_at(String generated_at) {
        this.generated_at = generated_at;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Jersey> getJerseys() {
        return jerseys;
    }

    public void setJerseys(List<Jersey> jerseys) {
        this.jerseys = jerseys;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

}
