class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr = new ArrayList<>();
        int i=1;
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        arr.add(intervals[0]);
        while(i<intervals.length){
            if(intervals[i][0]<=arr.get(arr.size()-1)[1]){
                if(intervals[i][1]>arr.get(arr.size()-1)[1])
                    arr.get(arr.size()-1)[1] = intervals[i][1];
                i++;
            }
            else arr.add(intervals[i++]);
        }
        for(int j=0;j<arr.size();j++){
            System.out.println(arr.get(j)[0]);
            System.out.println(arr.get(j)[1]);
        }
        int[][] out = new int[arr.size()][];
        for(int j=0;j<arr.size();j++){
            out[j] = arr.get(j);
        }
        return out;
    }
}
