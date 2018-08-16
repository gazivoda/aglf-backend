
package aglf.service.dto.restmapping.matchsummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather_info {

    @SerializedName("pitch")
    @Expose
    private String pitch;
    @SerializedName("weather_conditions")
    @Expose
    private String weather_conditions;

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getWeather_conditions() {
        return weather_conditions;
    }

    public void setWeather_conditions(String weather_conditions) {
        this.weather_conditions = weather_conditions;
    }

}
