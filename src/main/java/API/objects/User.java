package API.objects;

import java.util.Date;

public class User {

    public boolean enabled;

    public Date created;

    public String product;

    public String parent;

    public Date delition_deadtime;

    public boolean subscribed;

    public String external_id;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Date getDelition_deadtime() {
        return delition_deadtime;
    }

    public void setDelition_deadtime(Date delition_deadtime) {
        this.delition_deadtime = delition_deadtime;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }
}
