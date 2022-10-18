/*
explanation: finding median by maintaining two heaps and calculating left and right element, this method works and give median.

testcase:
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]] -> Works

Time & Space Complexity: O(n) & O(n) respectively, min heap with iteration is used over n times and is used to store n elements therefore.

*/

class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<Integer>(Collections.reverseOrder());
        large = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());
        if(small.size() < large.size()){
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size()>large.size()) return small.peek();
        else return (small.peek() + large.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */