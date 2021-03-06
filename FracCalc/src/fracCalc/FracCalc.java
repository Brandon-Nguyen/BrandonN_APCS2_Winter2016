//Brandon Nguyen, 12/5/16, 2nd Period
package fracCalc;

import java.util.Arrays;
import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	
	    System.out.print("Enter a fraction string: ");
	    String fractionString = input.nextLine();
	    
	    //checks to see if the input is quit
	    while (!fractionString.equals("quit")){
	    	System.out.println(produceAnswer(fractionString));
		    System.out.println();
		    //prompts for another input
		    System.out.print("Enter a fraction string: ");
		    fractionString = input.nextLine();
	    }
	    
	    

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	// TODO: Implement this function to produce the solution to the input
    	
    	//splits the input by spaces and returns as string array
    	String[] splitInput = parseInput(input);
    	
    	//Split the fraction into the whole number, numerator, and denominator
    	int[] firstOperand = parseOperand(splitInput[0]);
    	String operator = splitInput[1];
        int[] secondOperand = parseOperand(splitInput[2]);
        
        //convert from mixed number to improper fraction
        int[] firstFrac = toImproperFrac(firstOperand);
        int[] secondFrac = toImproperFrac(secondOperand);

        //decide whether to use add, subtract, divide or multiply
        //make an integer array to store the result 
        int[] resultFrac = new int [2];
        if(operator.equals("+")){
        	resultFrac =  addFrac(firstFrac, secondFrac);
        }else if(operator.equals("-")){
        	resultFrac =  subtractFrac(firstFrac, secondFrac);
        }else if(operator.equals("*")){
        	 resultFrac = multiplyFrac(firstFrac, secondFrac);
        }else{
        	resultFrac =  divideFrac(firstFrac, secondFrac);
        }
        //checks to see if the numerator and whole number 
        //are zero and returns zero as the answer
        if(resultFrac[0] == 0 && resultFrac[1] == 0){
        	return("0");
        }
        
        //convert back from improper fraction to a mixed number and reduce it
        int[] finalFrac = toMixedNum(resultFrac);

        return(reduceResult(finalFrac));
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static String[] parseInput(String input){
    	String[] splitStr = input.split(" ");
    	return splitStr;
    }
    
    public static int[] parseOperand(String operand){
    	
    	//Initializes the array with wholeNum, numerator, denominator
    	int[] fracArr = {0, 0, 1};
    	
    	//checks to see if the operand is a fraction or just a whole number
    	if(operand.indexOf("/") == -1){
			//returns the whole number from the operand only
			fracArr[0] = Integer.parseInt(operand);
			return fracArr;
		}
    	
    	//checks to see if the fraction has a whole number
    	if(operand.indexOf("_") != -1){
    		
    		//splits the array by the underscore, splits to whole number and fraction
    		String [] underscoreSplit = operand.split("_");
    		fracArr[0] = Integer.parseInt(underscoreSplit[0]);
    		
    		//changes operand so that it is only the fraction, without the whole number
    		operand = underscoreSplit[1];
    		
    	}
    	
    	//splits the fraction into numerator and denominator
		String[] numOrDenom = operand.split("/");
		fracArr[1] = Integer.parseInt(numOrDenom[0]);
		fracArr[2] = Integer.parseInt(numOrDenom[1]);
    	return fracArr;
    }
    
    public static int[] toImproperFrac(int[] operand) {
    	//set up array that will be returned later
    	int[] numDenom = new int[2];
    	//checking to see if the if there is a whole number and if its positive or negative
    	if(operand[0] == 0){
    		numDenom[0] = operand[1];
    	}else if(operand[0] < 0){
    		numDenom[0] = operand[0] * operand[2] - operand[1];
    	}else{
    		numDenom[0] = operand[0] * operand[2] + operand[1];
    	}
    	//setting denominator
    	numDenom[1] = operand[2];
    	
    	return numDenom;
	}
    
    public static int[] addFrac(int[] firstFrac, int[] secondFrac){
    	// new integer array to return the combined fraction
    	int[] result = new int[2];
    	//checks if denominator is the same
    	if(firstFrac[1] == secondFrac[1]){
    		result[0] = firstFrac[0] + secondFrac[0];
    		result[1] = firstFrac[1];
    	}else{
    		//deenominator isnt the same, so multiply numerators by denominator
    		firstFrac[0] = firstFrac[0] * secondFrac[1];
    		secondFrac[0] = secondFrac[0] * firstFrac[1];
    		//combine the multiplied numerators
    		result[0] = firstFrac[0] + secondFrac[0];
    		//multiply the denominators out
    		result[1] = firstFrac[1] * secondFrac[1];
    	}
    	
    	return result;
    }
    
    public static int[] subtractFrac(int[] firstFrac, int[] secondFrac){
    	//changes the second fraction into a negative fraction
    	secondFrac[0] = secondFrac[0] * -1;
    	return addFrac(firstFrac, secondFrac);
    }
    
    public static int[] multiplyFrac(int[] firstFrac, int[] secondFrac){
    	//new int array to return combined fraction
    	int[] result = new int[2];
    	//checks to see if the fraction has a numerator or if the numerator is zero
    	if(firstFrac[0] == 0 || secondFrac[0] == 0){
    		result[0] = 0;
    		result[1] = 0;
    	}else{
    		//there is a numerator and multiplies everything out
	    	result[0] = firstFrac[0] * secondFrac[0];
	    	result[1] = firstFrac[1] * secondFrac[1];
    	}
    	return result;
    }
    
    public static int[] divideFrac(int[] firstFrac, int[] secondFrac){
    	//changes the numerator and denominator of the second fraction
    	int tempVar = secondFrac[1];
    	secondFrac[1] = secondFrac[0];
    	secondFrac[0] = tempVar;
    	
    	return multiplyFrac(firstFrac, secondFrac);
    }
    
    public static int[] toMixedNum(int[] frac){
    	//checks to see if the denominator is one and it is just a whole number
    	if(frac[1] == 1){
    		int[] resultFrac = {frac[0]};
    		return (resultFrac);
    	}
    	//creates a new array of 3 that will store the information
    	int[] resultFrac = new int[3];
    	// creates whole number
    	resultFrac[0] = frac[0] / frac[1];
    	// numerator
    	resultFrac[1] = frac[0] % frac[1];
    	// denominator
    	resultFrac[2] = frac[1];
    	
    	return (resultFrac);
    }
    
    public static int gcf(int numerator, int denominator) {
    	//find gcf of the fraction
    	int gcf = 1;
    	for(int i = denominator - 1; i >= 2; i--){
    		if(numerator % i == 0 && denominator % i == 0){
    			gcf = i;
    		}
    	}
    	return gcf;
	}
    
    public static String reduceResult(int[] fraction){
    	//checks to see if its only a whole number
    	if(fraction.length == 1 || fraction[1] == 0){
    		return (Integer.toString(fraction[0]));
    	}
    	
    	//checks to see if the numerator is negative and if the whole number isn't zero
    	if(fraction[1] < 0 && fraction[0] != 0){
    		fraction[1] *= -1;
    	}
    	
    	//checks to see if the denominator is negative and if there is whole number
    	if(fraction[2] < 0 && fraction[0] != 0){
    		fraction[2] *= -1;
    	}
    	
    	//checks to see if the numerator is positive and 
    	//the denominator is negative and switches it
    	if(fraction[1] > 0 && fraction[2] < 0){
    		fraction[1] *= -1;
    		fraction[2] *= -1;
    	}
    	//finds the gcf of the fraction
    	int gcf = gcf(fraction[1], fraction[2]);
    	
    	// uses the gcf to check for an additional gcf and updates it to the new one
    	for(int i = gcf + 1; i < fraction[2]; i++){
    		if(fraction[1] % i == 0 && fraction[2] % i == 0){
    			gcf = i;
    		}
    	}

    	//divide numerator and denominator by the gcf
    	int numerator = fraction[1] / gcf;
    	int denominator = fraction[2] / gcf;
    	
    	//checks to see if the leftover fraction has a whole number or not
    	if(fraction[0] == 0){
    		return(numerator + "/" + denominator);
    	}else{
    		return (fraction[0] + "_" + numerator + "/" + denominator);
    	}
    }
}