package domain;

public abstract class PlaneSection {
    protected boolean[] seats;
    protected boolean aisleSeatAvailable;
    protected boolean windowSeatAvailable;
    protected boolean seatsAvailable;
    protected int previousAisleSeat;
    protected int previousWindowSeat;

    protected PlaneSection(int sectionSeats) {
        seats = new boolean[sectionSeats];
        initSeats(sectionSeats);
        seatsAvailable = true;
        aisleSeatAvailable = true;
        windowSeatAvailable = true;
        previousWindowSeat = 0;
        previousAisleSeat = 1;
    }

    private void initSeats(int sectionSeats) {
        for (int i = 0; i < sectionSeats; i++)
            seats[i] = false;
    }

    protected abstract void findSeat();

    protected abstract void findNextAvailableSeat();

    protected abstract void printSeats();

    protected boolean reserveSeat(int seatNumber) {
        if (!seats[seatNumber - 1]) {
            seats[seatNumber - 1] = true;
            return true;
        } else
            return false;
    }
}
