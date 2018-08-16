
package aglf.service.dto.restmapping.matchlineups;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchLineups {

    @SerializedName("generated_at")
    @Expose
    private String generated_at;
    @SerializedName("schema")
    @Expose
    private String schema;
    @SerializedName("sport_event")
    @Expose
    private Sport_event sport_event;
    @SerializedName("lineups")
    @Expose
    private List<Lineup> lineups = null;

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

    public Sport_event getSport_event() {
        return sport_event;
    }

    public void setSport_event(Sport_event sport_event) {
        this.sport_event = sport_event;
    }

    public List<Lineup> getLineups() {
        return lineups;
    }

    public void setLineups(List<Lineup> lineups) {
        this.lineups = lineups;
    }

}
