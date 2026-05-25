class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a,b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int currCapacity = 0;

        for(int[] trip : trips){

            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            while(!pq.isEmpty() && from >= pq.peek()[1]){
                currCapacity -= pq.poll()[0];
            }

            currCapacity += passengers;

            if(currCapacity > capacity) return false;

            pq.offer(new int[]{passengers, to});
        }

        return true;
    }
}