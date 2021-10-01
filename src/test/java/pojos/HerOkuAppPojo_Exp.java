package pojos;

public class HerOkuAppPojo_Exp {

    private String checkin;
    private String checkout;

    public HerOkuAppPojo_Exp(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public HerOkuAppPojo_Exp() {
    }
    public String getCheckin() {
        return checkin;
    }
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public String getCheckout() {
        return checkout;
    }
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    @Override
    public String toString() {
        return "HerOkuAppPojo_Exp{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
