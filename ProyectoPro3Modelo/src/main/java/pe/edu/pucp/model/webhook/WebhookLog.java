package pe.edu.pucp.model.webhook;

import java.util.Date;

public class WebhookLog {
    private int IDLog;
    private String bookingID;
    private Date timestamp;
    private String rawData;

    public WebhookLog(int IDLog, String bookingID, Date timestamp, String rawData) {
        this.IDLog = IDLog;
        this.bookingID = bookingID;
        this.timestamp = timestamp;
        this.rawData = rawData;
    }

    public int getIDLog() {
        return IDLog;
    }

    public void setIDLog(int IDLog) {
        this.IDLog = IDLog;
    }

    // --- //
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    // --- //
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    // --- //
    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }
}
