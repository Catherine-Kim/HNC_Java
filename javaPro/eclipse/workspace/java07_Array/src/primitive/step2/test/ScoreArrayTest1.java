package primitive.step2.test;

public class ScoreArrayTest1 {
	public static void main(String[] args){
		int sum = 0;
		float avg;
		int count = 0;
		
		int[] scores = {100, 99, 60, 87, 50};
		for(int j = 0; j < scores.length; j++)
			sum += scores[j];
		avg = sum/scores.length;
		
		for(int j = 0; j < scores.length; j++){
			if(scores[j] < avg)
				count++;
		}
		
		int[] below_avg = new int[count];
		
		int i = 0;
		
		for(int j = 0; j < scores.length; j++){
			if(scores[j] < avg){
				below_avg[i] = scores[j];
				i++;
			}
		}
		
		System.out.println("The sum of the scores is " + sum);
		System.out.println("The average of the scores is " + avg);
		System.out.print("The scores below average are ");
		for(int j = 0; j < below_avg.length; j++){
			if(j != below_avg.length-1)
				System.out.print(below_avg[j] + ", ");
			else
				System.out.print(below_avg[j] + ".");
		}
	}
}
