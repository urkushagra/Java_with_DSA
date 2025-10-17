class MovieBooking {
    private boolean[] seats;

    public MovieBooking(int n) { seats = new boolean[n]; }

    public boolean book(int start, int end){
        for(int i=start;i<=end;i++) if(seats[i]) return false;
        for(int i=start;i<=end;i++) seats[i]=true;
        return true;
    }

    public void printSeats(){
        System.out.println(Arrays.toString(seats));
    }

    public static void main(String[] args){
        MovieBooking mb = new MovieBooking(10);
        mb.book(2,5); mb.printSeats();
        System.out.println(mb.book(4,6)); // false due to overlap
    }
}
