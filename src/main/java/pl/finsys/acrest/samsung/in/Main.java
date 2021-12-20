package pl.finsys.acrest.samsung.in;

import com.google.gson.annotations.SerializedName;

public class Main {
    private AirConditionerMode airConditionerMode;

    @SerializedName("custom.airConditionerOptionalMode")
    private CustomAirConditionerOptionalMode customAirConditionerOptionalMode;

    @SerializedName("switch")
    private Switch mainSwitch;

    private AirConditionerFanMode airConditionerFanMode;
    private FanOscillationMode fanOscillationMode;
    private TemperatureMeasurement temperatureMeasurement;
    private ThermostatCoolingSetpoint thermostatCoolingSetpoint;
    private AudioVolume audioVolume;

    public AirConditionerMode getAirConditionerMode() {
        return airConditionerMode;
    }

    public void setAirConditionerMode(AirConditionerMode value) {
        this.airConditionerMode = value;
    }


    public CustomAirConditionerOptionalMode getCustomAirConditionerOptionalMode() {
        return customAirConditionerOptionalMode;
    }

    public void setCustomAirConditionerOptionalMode(CustomAirConditionerOptionalMode value) {
        this.customAirConditionerOptionalMode = value;
    }

    public Switch getSwitch() {
        return mainSwitch;
    }

    public void setSwitch(Switch value) {
        this.mainSwitch = value;
    }

    public AirConditionerFanMode getAirConditionerFanMode() {
        return airConditionerFanMode;
    }

    public void setAirConditionerFanMode(AirConditionerFanMode value) {
        this.airConditionerFanMode = value;
    }

    public FanOscillationMode getFanOscillationMode() {
        return fanOscillationMode;
    }

    public void setFanOscillationMode(FanOscillationMode value) {
        this.fanOscillationMode = value;
    }

    public TemperatureMeasurement getTemperatureMeasurement() {
        return temperatureMeasurement;
    }

    public void setTemperatureMeasurement(TemperatureMeasurement value) {
        this.temperatureMeasurement = value;
    }

    public ThermostatCoolingSetpoint getThermostatCoolingSetpoint() {
        return thermostatCoolingSetpoint;
    }

    public void setThermostatCoolingSetpoint(ThermostatCoolingSetpoint value) {
        this.thermostatCoolingSetpoint = value;
    }

    public AudioVolume getAudioVolume() {
        return audioVolume;
    }

    public void setAudioVolume(AudioVolume value) {
        this.audioVolume = value;
    }


}
