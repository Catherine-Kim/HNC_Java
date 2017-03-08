package primitive.step3.test;

public class MaxMinChoiceTest1 {
	public static void main(String[] args){
		int[] score = {83, 22, 94, 80, 92, 79, 45};
		
		int max = score[0];		// score[]에서 제일 큰 수를 찾아 넣을 변수. 배열의 첫번째 값으로 최대값을 초기화한다.
		int min = score[0];		// score[]에서 제일 작은 수를 찾아 넣을 변수.배열의 첫번째 값으로 최소값을 초기화한다.
		
		for(int i = 1; i < score.length; i++){	// i = 1 means 배열의 두 번째 값부터 보겠다는 뜻
			if(score[i] > max)					// score[i]가 max보다 크다면
				max = score[i];					// max에 score[i]을 넣음
			if(score[i] < min)					// score[i]가 min보다 작다면
				min = score[i];					// min에 score[i]을 넣음			
		}
		
		// 향상된 for문 사용해보기 : 뭐가 어디에서 돌아오는가?
		
		for(int i : score){		// score 배열 안에 있는 값들이 하나씩 자동으로 할당됨
			if(i > max) max = i;
			if(i < min) min = i;
		}
		
		System.out.println("Maximum Value : " + max);	// max(제일 큰 값) 출력
		System.out.println("Minimum Value : " + min);	// min(제일 작은 값) 출력
	}
}
