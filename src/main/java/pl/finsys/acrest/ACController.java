package pl.finsys.acrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import pl.finsys.acrest.samsung.in.State;
import pl.finsys.acrest.samsung.out.SamsungRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jarek Krochmalski
 */
@RestController
public class ACController {

    @Autowired private Environment env;

    private final Map<String, State> currentStatus = new HashMap<>();

    @PostMapping("/devices/{device}/power")
    public void power(@PathVariable String device, @RequestBody Param param) throws IOException {
        System.out.printf("/power for device %s: %s%n", device, param.getValue());
        new SamsungRequest(env, device).execute("switch", param.getValue());
        updateStatusFromCloud(device);
    }

    @PostMapping("/devices/{device}/ac_mode")
    public void acMode(@PathVariable String device, @RequestBody Param param) throws IOException {
        System.out.printf("/ac_mode for device %s: %s%n", device, param.getValue());
        new SamsungRequest(env, device).execute("airConditionerMode", "setAirConditionerMode", new String[]{param.getValue()});
        updateStatusFromCloud(device);
    }

    @PostMapping("/devices/{device}/fan_mode")
    public void fanMode(@PathVariable String device, @RequestBody Param param) throws IOException {
        System.out.printf("/fan_mode for device %s: %s%n", device, param.getValue());
        new SamsungRequest(env, device).execute("airConditionerFanMode", "setFanMode", new String[]{param.getValue()});
        updateStatusFromCloud(device);
    }

    @PostMapping("/devices/{device}/temperature")
    public void temperature(@PathVariable String device, @RequestBody Param param) throws IOException {
        System.out.printf("/temperature for device %s: %s%n", device, param.getValue());
        new SamsungRequest(env, device).execute("thermostatCoolingSetpoint", "setCoolingSetpoint", new String[]{param.getValue()});
        updateStatusFromCloud(device);
    }

    @GetMapping("/devices/{device}/status")
    public State status(@PathVariable String device) throws IOException {
        if (!currentStatus.containsKey(device)) {
            System.out.printf("No current state for %s, updating from the cloud.%n", device);
            currentStatus.put(device, new SamsungRequest(env, device).status());
        }
        return currentStatus.get(device);
    }

    private void updateStatusFromCloud(String device) throws IOException {
        System.out.printf("Updating state from the cloud: %s%n", device);
        currentStatus.put(device, new SamsungRequest(env, device).status());
    }

    /**
	 * Update all once per minute
	 */
	@Scheduled(fixedRate = 60000)
	private void updateAllFromCloud() throws IOException {
        System.out.println("updating device statuses from the cloud.");
        String DEVICES = env.getProperty("DEVICES");
        List<String> devices = Arrays.asList(DEVICES.split(","));
        for (String device : devices) {
            updateStatusFromCloud(device);
        }
    }
}