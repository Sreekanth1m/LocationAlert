package taskalert.location.sm.locationalert;

import java.io.Serializable;
import android.location.Address;

public class TaskDetails implements Serializable {

    private static final long serialVersionUID = 5527258407135652433L;

    private int _id;
    private String name;
    private String description;
    private boolean complete;
    private boolean tglonoff;
    private String address;
    private String latitude;
    private String longitude;

    public TaskDetails(String taskName) {
        name = taskName;
    }

    public void setId(int rowid) {
        this._id = rowid;
    }

    public int getId() {
        return _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public boolean isTglonoff() {
        return tglonoff;
    }

    public void setTglonoff(boolean tglonoff) {
        this.tglonoff = tglonoff;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAddress() {
        return null != address;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void toggleComplete() {
        complete = !complete;
    }
    public void toggletglOnOff() {
        tglonoff = !tglonoff;
    }

    public String toString() {
        return name;
    }

    public void setAddress(Address a) {
        if (null == a) {
            address = null;
            latitude = longitude = "0";
        } else {
            int maxAddressLine = a.getMaxAddressLineIndex();
            StringBuffer sb = new StringBuffer("");
            for (int i=0; i<maxAddressLine; i++) {
                sb.append(a.getAddressLine(i) + " ");
            }
            address = sb.toString();
            latitude = String.valueOf(a.getLatitude());
            longitude = String.valueOf(a.getLongitude());
        }
    }

    public boolean hasLocation() {
        return (latitude != "0" && longitude != "0");
    }

}

