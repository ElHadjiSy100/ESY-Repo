/**
 * Converts infix notation to postfix, postfix notation to infix, and evalues a postfix expression.
 * @author El Hadji Sy 
 */
public class Notation {
	/**
	 * Turns an infix expression into a postfix expression.
	 * @param infix the infix expression to change.
	 * @return an postfix expression.
	 * @throws InvalidNotationFormatException if infix expression format is incorrect.
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyQueue<Character> postfixSol = new MyQueue<Character>();
		MyStack<Character> stack = new MyStack<Character>();
			Character currChar;
			String ops = "+-*/";
			try {
				for(int i = 0; i < infix.length(); i++) {
					if((i-1) >= 0 && Character.isDigit(infix.charAt(i)) && (Character.isDigit(infix.charAt(i-1)))){
						throw new InvalidNotationFormatException("Invalid Format");
					} else if( (i-1) >= 0 && ops.contains("" + infix.charAt(i)) && ops.contains("" + infix.charAt(i-1))  ) {
						throw new InvalidNotationFormatException("Invalid Format");
					}
				    currChar = infix.charAt(i);
					if(currChar == ' ') {
						continue;
					} else if(Character.isDigit(currChar)) {
						postfixSol.enqueue(currChar);
					} else if(currChar == '(') {
						stack.push(currChar);
					} else if(currChar == '+' || currChar == '-') {
						if(stack.size() == 0) {
							stack.push(currChar);
						} else {
							while(stack.size()!= 0 && (stack.top() == '*' || stack.top() == '/' || stack.top() == '+' || stack.top() == '-')) {
								postfixSol.enqueue(stack.pop());
							}
							stack.push(currChar);
						}
						
					} else if(currChar == '*' || currChar == '/') {
						
						if(stack.size() == 0) {
							stack.push(currChar);
							continue;
						} else {
							
							while(stack.size() != 0 && (stack.top() == '+' || stack.top() == '-')) {
								postfixSol.enqueue(stack.pop());
							}
							
						}
						
						stack.push(currChar);
						
					} else if(currChar == ')') {
						while(stack.top() != '(') {
							postfixSol.enqueue(stack.pop());
						}
						if(stack.size() == 0) {
							throw new InvalidNotationFormatException("No Left paren");
						} else {
							stack.pop();
	
						}
					}
				}
			} catch(StackOverflowException e) {
				throw new InvalidNotationFormatException("Stack is full.");
			} catch(StackUnderflowException e) {
				throw new InvalidNotationFormatException("Stack is empty.");
			} catch(QueueOverflowException e) {
				throw new InvalidNotationFormatException("Queue is full.");
			}
			
			
			while(!stack.isEmpty()) {
				try {
					postfixSol.enqueue(stack.pop());
				} catch(QueueOverflowException e) {
					throw new InvalidNotationFormatException("Queue is full.");
				} catch(StackUnderflowException e) {
					throw new InvalidNotationFormatException("Stack is empty.");
				}
			}

		return postfixSol.toString("");
	}
	
	/**
	 * Turns a postfix expression into an infix expression.
	 * @param postfixExpr - the expression to turn into an infix.
	 * @return an infix expression.
	 * @throws InvalidNotationFormatException if the format of the postfix expression is  incorrect.
	 */
	public static String convertPostfixToInfix(String postfixExpr) throws InvalidNotationFormatException {
		
		MyStack<String> stack = new MyStack<String>();
			Character a;
			try {
				for(int i = 0; i < postfixExpr.length(); i++) {
					a = postfixExpr.charAt(i);
					if(a == ' ') {
						continue;
					} else if(Character.isDigit(a)) {
						stack.push("" + a);
					} else if(a == '+' || a == '-' || a == '*' || a == '/') {
						if(stack.size() < 2) {
							throw new InvalidNotationFormatException("Invalid format.");
						}
					String s = "(";
					String numTwo = stack.pop(); 
					String numOne = stack.pop();
					s+= numOne + a + "" + numTwo + ")";
					stack.push(s);
					} 
				}
			} catch(StackUnderflowException e) {
				throw new InvalidNotationFormatException("Stack is empty");
			} catch(StackOverflowException e) {
				throw new InvalidNotationFormatException("Stack is full");
			}
				
				if(stack.size() > 1) {
					throw new InvalidNotationFormatException("Invalid format.");
				}
		return stack.toString();
	}
	
	/**
	 * Evaluates a postfix expression.
	 * @param postfixExpr the expression to evaluate.
	 * @return the evaluated expression (returns a double).
	 * @throws InvalidNotationFormatException if the postfix expression is in an incorrect format.
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		double result = Double.MIN_VALUE;
		Character a;
		MyStack<String> stack = new MyStack<String>();
		try {	
			for(int i = 0; i < postfixExpr.length(); i++) {
				a = postfixExpr.charAt(i);
				if(a == ' ') {
					continue;
				} 
				 if(Character.isDigit(a)) {
					stack.push( "" + postfixExpr.charAt(i));
				} else if(a == '+' || a == '-' || a == '*' || a == '/') {
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException("Invalid Format.");
					}
					double numOne = Double.valueOf(stack.pop());
					System.out.println("NumOne is: " + numOne);
					double numTwo = Double.valueOf(stack.pop());
					System.out.println("NumTwo is: " + numTwo);
					if(a == '+') {
						stack.push("" + (numTwo + numOne));
					} else if(a == '-') {

						stack.push("" + (numTwo - numOne));
					} else if(a == '*') {
						System.out.println("will be pushing" + (numTwo*numOne));
						stack.push("" + (numTwo * numOne));
						System.out.println("Stack is:\n" + stack.toString(","));
					} else if(a == '/') {
						stack.push("" + (numTwo / numOne));
					}
				}
			}
		} catch(StackOverflowException e) {
			throw new InvalidNotationFormatException("Stack is full");
		} catch(StackUnderflowException e) {
			throw new InvalidNotationFormatException("Stack is empty");
		}
			
		if(stack.size() > 1) {
			throw new InvalidNotationFormatException("Invalid format.");
		}
		try {
			result = Double.valueOf(stack.pop());
		} catch(StackUnderflowException e) {
			throw new InvalidNotationFormatException("Stack is empty");
		}
		return result;
	}
}
