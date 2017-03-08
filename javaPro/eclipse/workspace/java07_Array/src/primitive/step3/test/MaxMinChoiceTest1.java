package primitive.step3.test;

public class MaxMinChoiceTest1 {
	public static void main(String[] args){
		int[] score = {83, 22, 94, 80, 92, 79, 45};
		
		int max = score[0];		// score[]���� ���� ū ���� ã�� ���� ����. �迭�� ù��° ������ �ִ밪�� �ʱ�ȭ�Ѵ�.
		int min = score[0];		// score[]���� ���� ���� ���� ã�� ���� ����.�迭�� ù��° ������ �ּҰ��� �ʱ�ȭ�Ѵ�.
		
		for(int i = 1; i < score.length; i++){	// i = 1 means �迭�� �� ��° ������ ���ڴٴ� ��
			if(score[i] > max)					// score[i]�� max���� ũ�ٸ�
				max = score[i];					// max�� score[i]�� ����
			if(score[i] < min)					// score[i]�� min���� �۴ٸ�
				min = score[i];					// min�� score[i]�� ����			
		}
		
		// ���� for�� ����غ��� : ���� ��𿡼� ���ƿ��°�?
		
		for(int i : score){		// score �迭 �ȿ� �ִ� ������ �ϳ��� �ڵ����� �Ҵ��
			if(i > max) max = i;
			if(i < min) min = i;
		}
		
		System.out.println("Maximum Value : " + max);	// max(���� ū ��) ���
		System.out.println("Minimum Value : " + min);	// min(���� ���� ��) ���
	}
}
