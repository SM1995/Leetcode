class Solution {
    public int connectSticks(int[] sticks) {
        
        if(sticks.length<2) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<sticks.length;i++){
            pq.add(sticks[i]);
        }
        
        int ans = 0;
        
        while(pq.size()>1){
            int temp = pq.remove() + pq.remove();
            pq.add(temp);
            ans+=temp;
        }
        
        return ans;
    }
}


/*

Solution Article
Approach 1: Greedy
Intuition and Algorithm

Always pick two of the smallest sticks to connect and continue doing this until you get only one stick. Let's see why this works.

Consider 4 sticks of the following lengths:

sticks = [a_1, a_2, a_3, a_4]sticks=[a 
1
​
 ,a 
2
​
 ,a 
3
​
 ,a 
4
​
 ]

Let's try to connect them left to right.

After first merge, we will have:

sticks = [(a_1 + a_2), a_3, a_4], cost = (a_1 + a_2)sticks=[(a 
1
​
 +a 
2
​
 ),a 
3
​
 ,a 
4
​
 ],cost=(a 
1
​
 +a 
2
​
 )

After second merge, we will have:

sticks = [(a_1 + a_2 + a_3), a_4], cost = (a_1 + a_2) + (a_1 + a_2 + a_3)sticks=[(a 
1
​
 +a 
2
​
 +a 
3
​
 ),a 
4
​
 ],cost=(a 
1
​
 +a 
2
​
 )+(a 
1
​
 +a 
2
​
 +a 
3
​
 )

And finally, last stick will look like:

sticks = [(a_1 + a_2 + a_3 + a_4)], cost = (a_1 + a_2) + (a_1 + a_2 + a_3) +(a_1 + a_2 + a_3 + a_4)sticks=[(a 
1
​
 +a 
2
​
 +a 
3
​
 +a 
4
​
 )],cost=(a 
1
​
 +a 
2
​
 )+(a 
1
​
 +a 
2
​
 +a 
3
​
 )+(a 
1
​
 +a 
2
​
 +a 
3
​
 +a 
4
​
 )

The final cost can be re-written as: cost = (3a_1 + 3a_2 + 2a_3 + a_4)cost=(3a 
1
​
 +3a 
2
​
 +2a 
3
​
 +a 
4
​
 )

As we can see, the sticks which are connected first are included in the final cost more than the ones that are picked later. Hence, it is optimal to pick smaller sticks first to get the smallest cost.

Let's try to figure out which data structure will be optimal to perform following tasks:

Get two of the smallest sticks (stick1 and stick2) from the array.
Add one stick (stick1 + stick2) back to the array.
We can use a min heap data structure (which is, generally, implemented as a PriorityQueue in most languages) which gives us O(\log{N})O(logN) complexity for both the operations.

class Solution {
    public int connectSticks(int[] sticks) {
        int totalCost = 0;
 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        // add all sticks to the min heap.
        for (int stick : sticks) {
            pq.add(stick);
        }
 
        // combine two of the smallest sticks until we are left with just one.
        while (pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            
            int cost = stick1 + stick2;
            totalCost += cost;
            
            pq.add(stick1 + stick2);
        }
 
        return totalCost;
    }
}

Complexity Analysis

Time complexity : O(N\log{N})O(NlogN), where NN is the length of the input array. Let's break it down:

Step 1) Adding NN elements to the priority queue will be O(N\log{N})O(NlogN).

Step 2) We remove two of the smallest elements and then add one element to the priority queue until we are left with one element. Since each such operation will reduce one element from the priority queue, we will perform N-1N−1 such operations. Now, we know that both add and remove operations take O(\log{N})O(logN) in priority queue, therefore, complexity of this step will be O(N\log{N})O(NlogN).

Space complexity : O(N)O(N) since we will store NN elements in our priority queue.
*/
