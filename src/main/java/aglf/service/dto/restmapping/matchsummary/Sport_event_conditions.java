
package aglf.service.dto.restmapping.matchsummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sport_event_conditions {

    @SerializedName("referee")
    @Expose
    private Referee referee;
    @SerializedName("venue")
    @Expose
    private Venue_ venue;
    @SerializedName("weather_info")
    @Expose
    private Weather_info weather_info;

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public Venue_ getVenue() {
        return venue;
    }

    public void setVenue(Venue_ venue) {
        this.venue = venue;
    }

    public Weather_info getWeather_info() {
        return weather_info;
    }

    public void setWeather_info(Weather_info weather_info) {
        this.weather_info = weather_info;
    }

}
