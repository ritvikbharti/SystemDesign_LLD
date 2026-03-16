// Movie Booking System using Facade Pattern

// Subsystem 1
class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Subsystem 2
class Theater {
    private String name;

    public Theater(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Subsystem 3
class Seat {
    public void reserveSeat() {
        System.out.println("Seat Reserved");
    }
}

// Subsystem 4
class Payment {
    public void makePayment() {
        System.out.println("Payment Successful");
    }
}

// Facade Class
class MovieBookingFacade {

    private Movie movie;
    private Theater theater;
    private Seat seat;
    private Payment payment;

    public MovieBookingFacade(Movie movie, Theater theater) {
        this.movie = movie;
        this.theater = theater;
        this.seat = new Seat();
        this.payment = new Payment();
    }

    public void bookMovie() {
        System.out.println("Booking " + movie.getTitle() + " at " + theater.getName());
        seat.reserveSeat();
        payment.makePayment();
        System.out.println("Movie Ticket Booked Successfully");
    }
}

// Client
public class Facade {
    public static void main(String[] args) {

        Movie movie = new Movie("Avengers");
        Theater theater = new Theater("PVR Cinema");

        MovieBookingFacade booking = new MovieBookingFacade(movie, theater);

        booking.bookMovie();
    }
}