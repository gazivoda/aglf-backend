
package aglf.service.dto.restmapping.tournamentschedule;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TournamentSchedule {

    @SerializedName("generated_at")
    @Expose
    private String generated_at;
    @SerializedName("tournament")
    @Expose
    private Tournament tournament;
    @SerializedName("sport_events")
    @Expose
    private List<Sport_event> sport_events = null;

    public String getGenerated_at() {
        return generated_at;
    }

    public void setGenerated_at(String generated_at) {
        this.generated_at = generated_at;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Sport_event> getSport_events() {
        return sport_events;
    }

    public void setSport_events(List<Sport_event> sport_events) {
        this.sport_events = sport_events;
    }

}
