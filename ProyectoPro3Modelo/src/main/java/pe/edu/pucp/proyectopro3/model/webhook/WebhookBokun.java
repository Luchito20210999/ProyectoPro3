package pe.edu.pucp.proyectopro3.model.webhook;

import java.util.ArrayList;

public class WebhookBokun {
    private int IDBokun;
    private String secretKey;
    private String accessKey;
    private ArrayList<WebhookLog> webLogs;

    public WebhookBokun(int IDBokun,String secretKey, String accessKey, ArrayList<WebhookLog> webLogs) {
        this.IDBokun = IDBokun;
        this.secretKey = secretKey;
        this.accessKey = accessKey;
        this.webLogs = new ArrayList<>();
    }

    public WebhookBokun() {

    }

    public int getIDBokun(){
        return IDBokun;
    }
    public void setIDBokun(int IDBokun){
        this.IDBokun = IDBokun;
    }
    // --- //
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
