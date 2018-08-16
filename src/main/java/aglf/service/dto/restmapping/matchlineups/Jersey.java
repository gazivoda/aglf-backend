
package aglf.service.dto.restmapping.matchlineups;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jersey {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("sleeve")
    @Expose
    private String sleeve;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("squares")
    @Expose
    private Boolean squares;
    @SerializedName("stripes")
    @Expose
    private Boolean stripes;
    @SerializedName("horizontal_stripes")
    @Expose
    private Boolean horizontal_stripes;
    @SerializedName("split")
    @Expose
    private Boolean split;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getSquares() {
        return squares;
    }

    public void setSquares(Boolean squares) {
        this.squares = squares;
    }

    public Boolean getStripes() {
        return stripes;
    }

    public void setStripes(Boolean stripes) {
        this.stripes = stripes;
    }

    public Boolean getHorizontal_stripes() {
        return horizontal_stripes;
    }

    public void setHorizontal_stripes(Boolean horizontal_stripes) {
        this.horizontal_stripes = horizontal_stripes;
    }

    public Boolean getSplit() {
        return split;
    }

    public void setSplit(Boolean split) {
        this.split = split;
    }

}
