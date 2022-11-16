package Queue;

import Stack.ArrayStack;

public class MAIN {
	
	//to print the queue
	public static void print(LinkedQueue<Integer> list) {


		for (int i = 0; i <list.length(); i++) {
			int x = list.dequeue() ;
			System.out.print(x+" ");
			list.enqueue(x);
		}


	}
	//max value
	public static int maximum(LinkedQueue<Integer> list) {
		int max = list.frontValue() ;

		for (int i = 0; i < list.length(); i++) {
			int x = list.dequeue() ;
			if(x > max)
				max = x ;
			list.enqueue(x);
		}


		return max ;
	}
	
	//sum of the queue
	public static int sumation(LinkedQueue<Integer> list) {
		int sum = 0 ;

		for (int i = 0; i < list.length(); i++) {
			int x = list.dequeue() ;
			sum+= x ;
			list.enqueue(x);
		}

		return sum ;
	}
	//Reveres by using stack
	public static void revers(LinkedQueue<Integer> list) {
		LinkedStack<Integer> stack = new LinkedStack<>() ; 

		while (!list.isEmpty()) {
			stack.push(list.dequeue());
		}
		while (!stack.isEmpty()) {
			list.enqueue(stack.pop());
		}
	}
	
	//this method is to check if the character are balanced or not  
	// level --> true
	// moon --> false, because m and n are not the same 
	public static boolean palindrome(String str) {
		LinkedQueue<Character> que = new LinkedQueue<>() ;
		LinkedStack<Character> stack = new LinkedStack<>() ;
		char c  ;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i) ;
			que.enqueue(c);
			stack.push(c);
		}

		for (int i = 0; i <str.length(); i++) {
			if(stack.pop() != que.dequeue())
				return false ;
		}
		return true ;
	}
	
	// to revers the half of queue element
	public static void changeQ(LinkedQueue<Integer>list) {
		
		if(list.isEmpty())
			return ;
		LinkedQueue<Integer> temp = new LinkedQueue<>() ;
		LinkedStack<Integer> StackTemp = new LinkedStack<>() ;
		
		//store data into stack
		int x = list.length()/2 ;
		for (int i = 0; i < x; i++) {
			StackTemp.push(list.dequeue()) ; // 10 20 30 40
		}
		//store the left data form the origin queue into a temp queue
		while (!list.isEmpty()) {
			temp.enqueue(list.dequeue());
		}
		
		
		//return the a element to origin queue after changing 
		while (!StackTemp.isEmpty()) {
			list.enqueue(StackTemp.pop()) ;
		}
		while (!temp.isEmpty()) {
			list.enqueue(temp.dequeue());
		}

	}
	// sort the odd first and than even
	public static void oddEven(LinkedQueue<Integer> list) {
		
		LinkedQueue<Integer> temp = new LinkedQueue<>() ;
		
		if(list.isEmpty()) return;
		
		int x = list.length() ;
		
		for (int i = 0; i < x; i++) {
			int r = list.dequeue() ;
			
			if(r % 2 == 0) 
				temp.enqueue(r);
			else
				list.enqueue(r);
		}
		while (!temp.isEmpty()) {
			list.enqueue(temp.dequeue());
		}
		

	}
	
	// to arranged the element in queue
    public static LinkedQueue<Integer> arranged(LinkedQueue<Integer> list, LinkedQueue<Integer> list2) {
    	
    	LinkedQueue<Integer> temp = new LinkedQueue<>() ;
    	
    	
    	while (!list.isEmpty() && !list2.isEmpty()) {
    		
    		int x = list.frontValue() ;
    		int y = list2.frontValue() ;
    		
    		if(x < y)
    			temp.enqueue(list.dequeue());
    		else 
    			temp.enqueue(list2.dequeue());
		}
    	
    	if(!list.isEmpty()) {
    		while (!list.isEmpty()) {
				temp.enqueue(list.dequeue());
			}
    	}
    	if(!list2.isEmpty()) {
    		while (!list2.isEmpty()) {
				temp.enqueue(list2.dequeue());
			}
    	}

    	return temp ;
    }
    //sort value
    public static void sort(LinkedQueue<Integer> list) {
    	
    	if(list.isEmpty()) {
    		System.out.println("the list is empty");
    		return ;
    	}
    	LinkedQueue<Integer> temp = new LinkedQueue<>() ;
    	
    	while (!list.isEmpty()) {
        	
		}

    }
    // Add the given value after minimum
    public static void addAfterMin(LinkedQueue<Integer> list, int key) {
    	
    	int mini = list.frontValue() ;
    	
    	for (int i = 0; i < list.length(); i++) {
			int x = list.dequeue() ;
			if(mini > x)
				mini =x ;
			list.enqueue(x);
		}
    	int x ;
    	int s = list.length() ;
    	for (int i = 0; i < s; i++) {
			x = list.dequeue() ;
			if(x == mini) {
				list.enqueue(x);
				list.enqueue(key);
			}else 
				list.enqueue(x);
		}
    	
    	
    }
    //Reveres the digit
	public static void ReverseDigits(LinkedQueue<Character> list) {
		if(list.isEmpty()) {
			System.out.println("The list is empty");
			return ;
		}
		
		LinkedStack<Character> stack = new LinkedStack<>() ;
		
		char x ;
		
		for (int i = 0; i < list.length(); i++) {
			x = list.dequeue() ;
			if(Character.isLetter(x))
				list.enqueue(x);
			else {
				list.enqueue('0');
				stack.push(x);
			}	
		}
		
		for (int i = 0; i < list.length(); i++) {
			x = list.dequeue() ;
			if(Character.isLetter(x))
				list.enqueue(x);
			else {
				list.enqueue(stack.pop());
			}
		}
		
		
		
	}
	public static int prec(char c) {
		
		switch(c) {
		
		case '+' :
		case '-' :
			return 1 ;
		case '*' :
		case '/' :
			return 2 ;
//		case '(':
//		case ')':
//			return 3;
		case '^' :
			return 3 ;
		}
		return -1 ;
	}
	public static void infixToPostfix(LinkedQueue<Character> list) {
		
		LinkedStack<Character> stack = new LinkedStack<>() ;
		LinkedQueue<Character> temp = new LinkedQueue<>() ;
		
		for (int i = 0; i < list.length(); i++) {
			char c = list.dequeue() ;
			if(Character.isLetterOrDigit(c)) {
				temp.enqueue(c);
			}
			else if(c == '(') {
				stack.push(c) ;
			}else if(c == ')') {
				while (!stack.isEmpty() && stack.top() != ')') {
					temp.enqueue(stack.pop()) ;
				}
				stack.pop() ;
			}else {
				while (!stack.isEmpty() && prec(c) <= prec(stack.top())) {
					temp.enqueue(stack.pop()) ;
				}
				stack.push(c) ;
			}
			while (!stack.isEmpty()) {
				temp.enqueue(stack.pop()) ;
			}
			while (!temp.isEmpty()) {
				list.enqueue(temp.dequeue()) ;
			}	
		}	
	}
	
	//Divide the queue to half
	public static void dividBy2(LinkedQueue<Integer> Q1 , LinkedQueue<Integer> Q2) {
		if(Q1.isEmpty())
			return ;
		
		while (Q1.isEmpty()) {
			Q2.enqueue(Q1.dequeue());
		}
		int x  = Q2.length()/2 ;
		for (int i = 0; i < x; i++) {
			Q1.enqueue(Q2.dequeue()) ;
		}
		
		print(Q1) ;
		System.out.println("\nAfter divid");
		print(Q2) ;
		
	}
	//spiacal enqueue
	public static void addSorted(LinkedQueue<Integer> list, int num) {
		if(list.isEmpty()) {
			list.enqueue(num);
			return ;
		}
		LinkedQueue<Integer> temp = new LinkedQueue<>() ;
		
		while (!list.isEmpty() && list.frontValue() < num) {
			temp.enqueue(list.dequeue());
		}
		temp.enqueue(num);
		while (!list.isEmpty()) {
			temp.enqueue(list.dequeue());
		}
		while (!temp.isEmpty()) {
			list.enqueue(temp.dequeue());
		}
	}
	//find second max
	public static int secMax(LinkedQueue<Integer> list) {
		if(list.isEmpty() || list.length() == 1) {
			return 0 ;
		}
		
		int max = list.frontValue() ;
		int secMax = max  ;
		
		for (int i = 0; i < list.length(); i++) {
			int x= list.dequeue() ;
			
			if(x > max) {
				secMax = max ;
				max = x ;
			}else if(x > max && x != max) {
				secMax = x ;
			}
			list.enqueue(x);
		}
		return secMax ;
		
		
	}
	//search for the elemnt
	public static boolean isFound(LinkedQueue<Integer> list, int key) {
		if(list.isEmpty())
			return true ;
		
		boolean flag = false ;
		for (int i = 0; i < list.length(); i++) {
			int x = list.dequeue() ;
			if(x == key)
				flag = true ;
			list.enqueue(x);
		}
		return flag ;

	}
	//Deleted the given value
	public static void deletNum(LinkedQueue<Integer> list, int key) {
		if(list.isEmpty())
			return ;
		
		LinkedQueue<Integer> temp = new LinkedQueue<>() ;
		
		while (!list.isEmpty()) {
			int x = list.frontValue() ;
			
			if(x == key)  {
				list.dequeue() ;
			}else {
				temp.enqueue(list.dequeue());
			}
		}
		while (!temp.isEmpty()) {
			list.enqueue(temp.dequeue());
		}
		
		
	}
	//delete duplicate value
	public static void delete_dublacte(LinkedQueue<Integer> list) {
		if(list.isEmpty())
			return ;
		
		LinkedQueue<Integer> temp = new LinkedQueue<>() ;
		
		int x ;
		while (!list.isEmpty()) {
			x = list.dequeue();
			
			if(isFound(temp, x) == false)
				temp.enqueue(x);
		}
		while (!temp.isEmpty()) {
			list.enqueue(temp.dequeue());
		}

	}
	//swap by two
	public static void swapTwo(LinkedQueue<Integer> list) {
		if(list.isEmpty() || list.length() == 1)
			return ;
		LinkedQueue<Integer> temp = new LinkedQueue<>() ;

		while (!list.isEmpty()) {
			
			if(list.length() ==1) {
				int x = list.dequeue() ;
				temp.enqueue(x);
			}else {
				int x = list.dequeue() ;
				int y = list.dequeue() ;
				temp.enqueue(y);
				temp.enqueue(x);
			}
		}
		while (!temp.isEmpty()) {
			list.enqueue(temp.dequeue());
		}
	}
	//swap the first value and last
	public static void swapFirstLast(LinkedQueue<Integer> list) { 
		if(list.isEmpty())
			return ;
		int x = list.dequeue() ;
		
		for (int i = 0; i < (list.length() -1); i++) {
			list.enqueue(list.dequeue());
		}
		list.enqueue(x);
		
	}

	public static void main(String[] args) {

		LinkedQueue<Character> list = new LinkedQueue<>() ;

	}
	

}
