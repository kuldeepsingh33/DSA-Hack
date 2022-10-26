/*
explanation: minstack by maintaining another stack for only storing minimum numbers, when a number is popped we respectively pop number in this stack, when enough are popped the top most min value changes.

testcase:
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Works
*/

class MinStack {
    Stack<Integer> _stack;
    Stack<Integer> _mstack;
    int gmin;
    int gdex;
    
    public MinStack() {
        _stack = new Stack<Integer>();
        _mstack = new Stack<Integer>();
    }
    
    public void push(int val) {
        _stack.push(val);
        if(_mstack.isEmpty()){
            _mstack.push(val);
            return;
        }
        if(_mstack.peek() > val){
            _mstack.push(val);
        }
        else{
            _mstack.push(_mstack.peek());
        }
    }
    
    public void pop() {
        _stack.pop();
        _mstack.pop();
        
    }
    
    public int top() {
        return _stack.peek();
    }
    
    public int getMin() {
        return _mstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */