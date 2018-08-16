
package aglf.service.dto.restmapping.matchsummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics_ {

    @SerializedName("ball_possession")
    @Expose
    private Integer ball_possession;
    @SerializedName("throw_ins")
    @Expose
    private Integer throw_ins;
    @SerializedName("shots_off_target")
    @Expose
    private Integer shots_off_target;
    @SerializedName("fouls")
    @Expose
    private Integer fouls;
    @SerializedName("goal_kicks")
    @Expose
    private Integer goal_kicks;
    @SerializedName("free_kicks")
    @Expose
    private Integer free_kicks;
    @SerializedName("corner_kicks")
    @Expose
    private Integer corner_kicks;
    @SerializedName("offsides")
    @Expose
    private Integer offsides;
    @SerializedName("shots_on_target")
    @Expose
    private Integer shots_on_target;
    @SerializedName("shots_saved")
    @Expose
    private Integer shots_saved;
    @SerializedName("yellow_cards")
    @Expose
    private Integer yellow_cards;
    @SerializedName("injuries")
    @Expose
    private Integer injuries;

    public Integer getBall_possession() {
        return ball_possession;
    }

    public void setBall_possession(Integer ball_possession) {
        this.ball_possession = ball_possession;
    }

    public Integer getThrow_ins() {
        return throw_ins;
    }

    public void setThrow_ins(Integer throw_ins) {
        this.throw_ins = throw_ins;
    }

    public Integer getShots_off_target() {
        return shots_off_target;
    }

    public void setShots_off_target(Integer shots_off_target) {
        this.shots_off_target = shots_off_target;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getGoal_kicks() {
        return goal_kicks;
    }

    public void setGoal_kicks(Integer goal_kicks) {
        this.goal_kicks = goal_kicks;
    }

    public Integer getFree_kicks() {
        return free_kicks;
    }

    public void setFree_kicks(Integer free_kicks) {
        this.free_kicks = free_kicks;
    }

    public Integer getCorner_kicks() {
        return corner_kicks;
    }

    public void setCorner_kicks(Integer corner_kicks) {
        this.corner_kicks = corner_kicks;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public Integer getShots_on_target() {
        return shots_on_target;
    }

    public void setShots_on_target(Integer shots_on_target) {
        this.shots_on_target = shots_on_target;
    }

    public Integer getShots_saved() {
        return shots_saved;
    }

    public void setShots_saved(Integer shots_saved) {
        this.shots_saved = shots_saved;
    }

    public Integer getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(Integer yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public Integer getInjuries() {
        return injuries;
    }

    public void setInjuries(Integer injuries) {
        this.injuries = injuries;
    }

}
