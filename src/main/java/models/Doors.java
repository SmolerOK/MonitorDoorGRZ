package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doors {
    private static final Logger LOG = LogManager.getLogger(Doors.class);

    public int cameraNumber;
    byte[] dataOpenDoor0 = {0x02, 0x1F, 0x00, 0x03, 0x61, 0x38};
    byte[] dataOpenDoor1 = {0x02, 0x1F, 0x01, 0x03, (byte) 0xb9, 0x21};

    public void openDoor1() {
        openDoor(dataOpenDoor1);
    }

    public void openDoor0() {
        openDoor(dataOpenDoor0);
    }

    public void openDoor(byte[] data) {
        try {
            var echoClient = new EchoClient(Settings.getHostDoor(cameraNumber));
            echoClient.sendEchoWithOutReceive(data);
            echoClient.close();
        } catch (Exception ex) {
            LOG.error("Ошибка: " + ex.getMessage());
        }
    }
}
