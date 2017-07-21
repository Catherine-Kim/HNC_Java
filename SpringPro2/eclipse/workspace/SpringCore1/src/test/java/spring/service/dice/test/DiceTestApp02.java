package spring.service.dice.test;

import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.impl.DiceBImpl;
import spring.service.dice.play.Player02;

/*
 * FileName : DiceTestApp01.java
 * �뀋 DiceA / Player01 Test �븯�뒗 Application 
 */
public class DiceTestApp02 {
	///Main Method
	//怨ㅼ넄李� 諛섎뱶�떆 �솗�씤!!!
	public static void main(String[] args){
		//�깮�꽦�옄瑜� �씠�슜 �궗�슜�븷 Dice�씤 DiceImpl 媛앹껜瑜� �깮�꽦�옄瑜� �넻�빐�꽌 二쇱엯..
		Player02 player01 = new Player02(new DiceAImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("�꽑�깮�맂 二쇱궗�쐞 �닔 : "+player01.getTotalValue());
		System.out.println("=======================\n\n");
				
			
			//setter 硫붿냼�뱶瑜� �씠�슜�빐�꽌 �궗�슜�븷 DiceImpl 媛앹껜瑜� 二쇱엯�븿..
			Player02 player02 = new Player02();
			player02.setDice(new DiceBImpl());
			player02.playDice(3);
			System.out.println("=======================");
			System.out.println("�꽑�깮�맂 二쇱궗�쐞 �닔 : "+player02.getTotalValue());
			System.out.println("=======================\n\n");
			}
		}//end of class
/*
 * Player01�뿉 鍮꾪빐�꽌 �뿬�윭媛쒖쓽 二쇱궗�쐞瑜� 遺�紐� ���엯�쑝濡� �뜕吏덉닔 �엳�떎.
 * �썾�뵮 �겢�옒�뒪�쓽 愿�怨꾧� �쑀�뿰�빐 議뚮떎.
 * �븯吏�留� �뿬�쟾�엳 
 * new Player02(new DiceAImpl());
 * player02.setDice(new DiceBImpl());
 * 二쇱엯�쓽 �넻濡쒕뒗 �깮�꽦�옄, setter()濡� �떖�씪吏�吏�留� �뿬�쟾�엳 肄붾뱶�뿉 new 媛� �굹�샂�쑝濡쒖뜥
 * �겢�옒�뒪�쓽 �뿰愿��씠 �옄�쑀濡�吏� 紐삵븯�떎....寃고빀�룄媛� �뿬�쟾�엳 �궓�븘�엳�떎.
 * --> Spring DI Container瑜� �씠�슜�빐�꽌 �뿬湲곗꽌 媛앹껜瑜� �깮�꽦�븯怨� 二쇱엯�븯�룄濡� �븯�옄
 */



















 
