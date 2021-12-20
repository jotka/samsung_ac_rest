package pl.finsys.acrest.samsung.in;

import com.google.gson.annotations.SerializedName;

public class Switch {
    @SerializedName("switch")
    private FanMode fanMode;

    private String value;

    public FanMode getSwitch() {
        return fanMode;
    }

    public void setSwitch(FanMode value) {
        this.fanMode = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
