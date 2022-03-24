package pojo1;

public class BookingPojo {
    private Integer bookingid;
    private Booking booking;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookingPojo() {
    }

    /**
     *
     * @param booking
     * @param bookingid
     */
    public BookingPojo(Integer bookingid, Booking booking) {
        super();
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
