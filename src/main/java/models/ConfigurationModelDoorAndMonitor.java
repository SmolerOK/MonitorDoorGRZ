package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationModelDoorAndMonitor {
    String mqttUsername = "admin";
    String mqttPassword = "333";
    String idClient = "MonitorDoor";
    String ipClient = "194.87.237.67";
    int portClient = 1883;

    Map<Integer, MonitorDoor> monitorDoorDictionary = new HashMap<>() {{
        put(1, new MonitorDoor("1244", 1234, "192.168.8.110", 1985));
        put(2, new MonitorDoor("1244", 1234, "192.168.8.111", 1245));
    }};


}
