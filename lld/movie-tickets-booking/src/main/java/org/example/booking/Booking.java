package org.example.booking;

import org.example.Seat;
import org.example.Show;
import org.example.Theatre;

import java.util.Map;

public class Booking {
    BookingState idleState, showSelectedState, seatSelectedState, paymentReceivedState;
    BookingState currentState;
    Show selectedShow;
    Integer receivedMoney;
    public Seat selectedSeat;
    public Map<String, Theatre> theatres;

    public Booking(Map<String, Theatre> theatres) {
        idleState = new IdleState(this);
        showSelectedState = new ShowSelected(this);
        seatSelectedState = new SeatSelected(this);
        paymentReceivedState = new PaymentReceived(this);
        currentState = idleState;
        this.theatres = theatres;
    }

    public void setCurrentState(BookingState bs){
        currentState = bs;
    }
    public  void setSelectShow(Show s) {
        selectedShow = s;
    }

    public void setSelectSeat(Seat s) {
        selectedSeat = s;
    }

    public  void setReceiveMoney(int m) {
        receivedMoney = m;
    }

    public void selectShow(Show s) {
        currentState.selectShow(s);
    }

    public void selectSeat(Seat s) {
        currentState.selectSeat(s);
    }

    public void collectPayment() {
        currentState.collectPayment();
    }

    public void confirmBooking() {
        currentState.confirmBooking();
    }


}

