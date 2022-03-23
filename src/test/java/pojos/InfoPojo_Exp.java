package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoPojo_Exp {
     private String firstname;
     private String lastname;
     private Integer totalprice;
     private Boolean depositpaid;
     private HerOkuAppPojo_Exp bookingdate;
     private String additionalneeds;

     public InfoPojo_Exp(String firstname, String lastname, Integer totalprice, Boolean depositpaid, HerOkuAppPojo_Exp bookingdate, String additionalneeds) {
          this.firstname = firstname;
          this.lastname = lastname;
          this.totalprice = totalprice;
          this.depositpaid = depositpaid;
          this.bookingdate = bookingdate;
          this.additionalneeds = additionalneeds;
     }
     public InfoPojo_Exp() {
     }
     public String getFirstname() {
          return firstname;
     }
     public void setFirstname(String firstname) {
          this.firstname = firstname;
     }
     public String getLastname() {
          return lastname;
     }
     public void setLastname(String lastname) {
          this.lastname = lastname;
     }
     public Integer getTotalprice() {
          return totalprice;
     }
     public void setTotalprice(Integer totalprice) {
          this.totalprice = totalprice;
     }
     public Boolean getDepositpaid() {
          return depositpaid;
     }
     public void setDepositpaid(Boolean depositpaid) {
          this.depositpaid = depositpaid;
     }
     public HerOkuAppPojo_Exp getBookingdate() {
          return bookingdate;
     }
     public void setBookingdate(HerOkuAppPojo_Exp bookingdate) {
          this.bookingdate = bookingdate;
     }
     public String getAdditionalneeds() {
          return additionalneeds;
     }
     public void setAdditionalneeds(String additionalneeds) {
          this.additionalneeds = additionalneeds;
     }
     @Override
     public String toString() {
          return "InfoPojo_Exp{" +
                  "firstname='" + firstname + '\'' +
                  ", lastname='" + lastname + '\'' +
                  ", totalprice=" + totalprice +
                  ", depositpaid=" + depositpaid +
                  ", bookingdate=" + bookingdate +
                  ", additionalneeds='" + additionalneeds + '\'' +
                  '}';
     }
}
