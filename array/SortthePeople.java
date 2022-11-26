//Using Priority Queue
class Solution {
    class Student {
        String name;
        int height;
        public Student(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Student> pq = new PriorityQueue<>((a,b) -> b.height - a.height);
        
        for (int i = 0; i < names.length; i++) {
            pq.offer(new Student(names[i], heights[i]));
        }
        
        for (int i = 0; i < names.length; i++) {
            names[i] = pq.poll().name;
        }
        return names;
    }
}

//Using HAshMap
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
       Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }        
        Arrays.sort(heights);
        String[] result = new String[heights.length];
        int index = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            result[index] = map.get(heights[i]);
            index++;
        }
        return result;
        
    }
}
