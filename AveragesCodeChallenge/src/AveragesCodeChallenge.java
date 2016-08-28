import java.util.Scanner;

public class AveragesCodeChallenge {
	//allow user to input value
	static Scanner input = new Scanner(System.in); 
	public static void main (String []args)
	{
		while(true)
		{
			System.out.println("Type 'input' to write your own array or type 'example' to use current array.");
			String decision= input.next();
			switch (decision)
			{
			case "input":
				//input method
				inputArray();
				break;
			case "example":
				//example method
				exampleArray();
				break;
			}
		}
	}
	public static void exampleArray()
	{
		//example
		double[] values={-2254, 14, -23, 2659, -45, -888, -9, 5, 25};
		System.out.print("Array= ");
		//prints all the values in the array
		for(int y=0;y<values.length;y++)
		{
			System.out.print(values[y] +", ");
		}
		//calls the sort method and calculating the mean method
		sort(values);
		mean(values);
	}
	public static void inputArray()
	{
		System.out.println("How many numbers do you want to enter?");
		
		double numb= input.nextDouble();
		 //sets the total length of array
		double[] numbers = new double[(int) numb];
		System.out.println("Enter array: ");
		for(int x=0; x<numbers.length;x++)
		{
			//places inputed numbers into array
			numbers[x]=input.nextDouble();
		}
		
		System.out.print("Your Array= " );
		//prints the array 
		for(int z=0;z<numbers.length;z++)
		{
			System.out.print(numbers[z] +", ");
		}
		//calls the sort method and calculating the mean method
		sort(numbers);
		mean(numbers);
	}
	public static void notDisplayable()
	{
		//if a value cannot be calculated
			System.out.println("NA");
	}
	public static void sort(double num[])
	{
		double temp;
		System.out.println("array:");
		//iterate through the array and swap pairs that are out of order
		//sorting in ascending order
		for(int i=0;i<num.length;i++)
		{
			for(int x=0;x<num.length;x++)
			{ 
				if(num[i]< num[x])
				{
					temp= num[i];
					num[i]=num[x];
					num[x]=temp;
				}
			}
		}
		System.out.println();
		System.out.print("Ascending order= ");
		//printing the sorted array
		for(int y=0;y<num.length;y++)
		{
			System.out.print(num[y] +", ");
		}
		median(num);
		mode(num);
	}
	public static void median(double num[])
	{
		System.out.println();
		//calculates the total length of array and divides by 2 to find the median
		int mid= num.length/2;
		//prints value
		System.out.println("Median= "+num[mid]);
	}
	public static void mean(double num[])
	{
		double sum=0;
		for(int i=0;i<num.length;i++)
		{
			//adds all the numbers in the array
			sum+=num[i];
		}
		//calculates the mean by dividing the sum of array 
		//by the number of values (total length)
		double calculate= sum/num.length;
		System.out.println("Mean= "+calculate);
	}
	public static void mode(double num[])
	{
		int modeCount=0, currCount, maxCount=1;
		double mode=0;
		// Iterates through all values in our array and considers them as potential modes
		for(double currNum: num)
		{
			//resets the number of times its been seen
			currCount=0;
			//iterates and counts how many times a number has been seen
			for(double element:num)
			{
				//if it matches, add count
				if(currNum == element)
				{
					currCount++;
				}
			}
			//only save the value as a mode if its greater than current max count and mode count
			if(currCount> modeCount && currCount>maxCount)
			{
				modeCount= currCount;
				mode=currNum;
			}
		}
		//if there is no mode, display "NA"
		if(modeCount==0)
		{
			System.out.print("Mode= ");
			notDisplayable();
		}
		else
		{
			//else print the mode value and its mode count
			System.out.println("Mode= "+ mode +" numTimes:" + modeCount);
		}
	}
}