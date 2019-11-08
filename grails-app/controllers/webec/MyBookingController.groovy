package webec


class MyBookingController {

    def probiere(){
        // find the last names of all people that booked
        // room named "1.313"
        def room = Room.findByName("1.313")
        def result = Booking.findAllByRoom(room)*.booker.lastName.unique()
        render text: result.toString()

    }

    static scaffold = Booking
}
