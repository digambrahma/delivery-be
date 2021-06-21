package delivery.deliverybe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "Delivery")
public class Delivery {

    @Id
    private String deliveryId;

    @NotNull
    private String to;
    @NotNull
    private String from;
    @NotNull
    private String item;
    @NotNull
    private Date date;
    @NotNull
    private Boolean status;

    public Delivery(String to, String from, String item, Date date, Boolean status) {
        this.to = to;
        this.from = from;
        this.item = item;
        this.date = date;
        this.status = status;
    }

    public Delivery() {
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
