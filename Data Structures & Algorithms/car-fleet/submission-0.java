class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double midArray[] = new double[position.length];
        for(int i=0; i<position.length; i++){
            midArray[i] = (double)(target-position[i])/speed[i];
        }

        Integer x[] = new Integer[position.length];
        for(int i=0; i<position.length; i++){
            x[i] = i;
        }

        Arrays.sort(x, (a,b) -> Integer.compare(position[b],position[a]));

        int fleet =0;
        double current = 0;
        for(int i=0; i<position.length; i++){
            if(midArray[x[i]]>current){
                fleet++;
                current = midArray[x[i]];
            }
        }

        return fleet;
    }
}
