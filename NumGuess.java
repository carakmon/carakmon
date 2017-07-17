import java.util.Scanner;
import java.util.stream.IntStream;

public class NumGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int max;
		System.out.format("What is the maximum number possible?");
		max = sc.nextInt();
		sc.nextLine();
		int i = 1;
		int current = max >> i;
		i++;

		forloop: for(;;) {
			System.out.format("Is the number you are thinking " + current + "?(h or l or c): \n");
			
			String answer = sc.nextLine();
			
					
			switch (answer) {
			case "h":
				current += max >> i;
				//System.out.println(max >> i);
				i++;
				break;
				
			case "l":
				current -= max >> i;
				//System.out.println(max >> i);
				i++;
				break;
				
			case "c":
				System.out.format("Horray~~~ I've got it!!");
				break forloop;

			default:
				System.out.format("Could you plz answer in h, l, or c?\n");
				break;
			}
			System.out.format("-------------------------------------\n");
		}
		
		
		
		sc.close();
		

	}

}
