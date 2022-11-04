package pojos;

public class BookingDatesPojo {

    //1) Tüm keyler icin private variable'lar olusturuyoruz
    private String checkin;
    private String checkout;

    //2) Tüm parametrelerle ve parametresiz constractorlar olusturuyoruz


    public BookingDatesPojo(String checkin, String checkot) {
        this.checkin = checkin;
        this.checkout = checkot;
    }

    public BookingDatesPojo() {
    }

    //3)Public Getter ve stter methodlarini olusturuyoruz


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkot) {
        this.checkout = checkot;
    }

    //4) toString() methodiúnu olusturuyoruz


    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkot='" + checkout + '\'' +
                '}';
    }
}
