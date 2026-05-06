class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s : deadends) dead.add(s);

        String start = "0000";
        if (dead.contains(start)) return -1;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (cur.equals(target)) return steps;

                if (dead.contains(cur)) continue;

                char[] arr = cur.toCharArray();

                for (int j = 0; j < 4; j++) {
                    char original = arr[j];

                
                    arr[j] = (char) ((original - '0' + 1) % 10 + '0');
                    String up = new String(arr);
                    if (!visited.contains(up) && !dead.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }

                    
                    arr[j] = (char) ((original - '0' + 9) % 10 + '0');
                    String down = new String(arr);
                    if (!visited.contains(down) && !dead.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }

                    arr[j] = original;
                }
            }

            steps++;
        }

        return -1;
    }
}