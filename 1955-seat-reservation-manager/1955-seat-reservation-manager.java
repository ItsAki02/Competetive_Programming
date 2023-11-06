class SeatManager {
 private PriorityQueue<Integer> seats;
    public SeatManager(int n) {
         seats = new PriorityQueue<>();
        // Initialize the priority queue with seat numbers from 1 to 'n'.
        for (int i = 1; i <= n; i++) {
            seats.offer(i);
        }
    }
    
    public int reserve() {
        if (!seats.isEmpty()) { // Check if there are available seats in the priority queue.
            int reservedSeat = seats.poll(); // Get the smallest seat number from the queue.
            return reservedSeat; // Return the reserved seat number.
        } else {
            return -1; // Return -1 to indicate that there are no available seats.
        }
    }
    
    public void unreserve(int seatNumber) {
        seats.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */