
package aglf.service.dto.restmapping.matchsummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchSummary {

    @SerializedName("generated_at")
    @Expose
    private String generated_at;
    @SerializedName("schema")
    @Expose
    private String schema;
    @SerializedName("sport_event")
    @Expose
    private Sport_event sport_event;
    @SerializedName("sport_event_conditions")
    @Expose
    private Sport_event_conditions sport_event_conditions;
    @SerializedName("sport_event_status")
    @Expose
    private Sport_event_status sport_event_status;
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

    public Sport_event getSport_event() {
        return sport_event;
    }

    public void setSport_event(Sport_event sport_event) {
        this.sport_event = sport_event;
    }

    public Sport_event_conditions getSport_event_conditions() {
        return sport_event_conditions;
    }

    public void setSport_event_conditions(Sport_event_conditions sport_event_conditions) {
        this.sport_event_conditions = sport_event_conditions;
    }

    public Sport_event_status getSport_event_status() {
        return sport_event_status;
    }

    public void setSport_event_status(Sport_event_status sport_event_status) {
        this.sport_event_status = sport_event_status;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

}
