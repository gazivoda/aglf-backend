
package aglf.service.dto.restmapping.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Season {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("statistics")
    @Expose
    private Statistics_ statistics;
    @SerializedName("tournament")
    @Expose
    private Tournament tournament;
    @SerializedName("form")
    @Expose
    private Form form;

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

    public Statistics_ getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics_ statistics) {
        this.statistics = statistics;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

}
