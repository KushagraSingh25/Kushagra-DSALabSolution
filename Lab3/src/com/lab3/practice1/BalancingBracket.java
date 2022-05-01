package com.lab3.practice1;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBracket {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the bracket sequence:");
		String bracket=in.nextLine();
		
		if (balancedBrackets(bracket)) {
			System.out.println("The enter string has balanced brackets");
		}else {
			System.out.println("The entered string doesn't contain balanced brackets");
		}
	in.close();
	}

static boolean balancedBrackets(String bracket)
{ 
    Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<bracket.length();i++)
        {
        	char ch = bracket.charAt(i);
            if(ch =='(' || ch=='[' || ch=='{')
            {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty())
            	return false;
            
            char c;
            
            switch(ch) {
            
            case '}':
            	
            	c=stack.pop();
            	if(c=='('|| c=='[')
            		return false;
            	break;
            	
            case ')':
            	
            	c=stack.pop();
            	if(c=='{'|| c=='[')
            		return false;
            	break;
            	
            case ']':	
            	c=stack.pop();
            	if(c=='('|| c=='{')
            		return false;
            	break;
            	
            }
        }
         return(stack.isEmpty());   	
     }
}