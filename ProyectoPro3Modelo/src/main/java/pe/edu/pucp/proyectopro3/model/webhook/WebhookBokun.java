package pe.edu.pucp.proyectopro3.model.webhook;

import java.util.ArrayList;

public class WebhookBokun {
    private String secretKey;
    private String accessKey;
    private ArrayList<WebhookLog> webLogs;

    public WebhookBokun(String secretKey, String accessKey, ArrayList<WebhookLog> webLogs) {
        this.secretKey = secretKey;
        this.accessKey = accessKey;
        this.webLogs = new ArrayList<>();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    // --- //
    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    // --- //
    public ArrayList<WebhookLog> getWebhookLog() {
        return webLogs;
    }

    public void setWebhookLog(ArrayList<WebhookLog> webLogs) {
        this.webLogs = webLogs;
    }

    // --- //

    public void recibirWebhookPOST(String json) {

    }

    public void encolarTrabajo(String bookingID) {

    }

    public void ejecutarUpsertBooking(String datos) {

    }
}
