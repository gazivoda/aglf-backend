
package aglf.service.dto.restmapping.matchlineups;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lineup {

    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("manager")
    @Expose
    private Manager manager;
    @SerializedName("jersey")
    @Expose
    private Jersey jersey;
    @SerializedName("starting_lineup")
    @Expose
    private List<Starting_lineup> starting_lineup = null;
    @SerializedName("substitutes")
    @Expose
    private List<Substitute> substitutes = null;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Jersey getJersey() {
        return jersey;
    }

    public void setJersey(Jersey jersey) {
        this.jersey = jersey;
    }

    public List<Starting_lineup> getStarting_lineup() {
        return starting_lineup;
    }

    public void setStarting_lineup(List<Starting_lineup> starting_lineup) {
        this.starting_lineup = starting_lineup;
    }

    public List<Substitute> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(List<Substitute> substitutes) {
        this.substitutes = substitutes;
    }

}
