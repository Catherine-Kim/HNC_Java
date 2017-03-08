package data.type.test;

/* Wrapper Class ::
 * 각각의 기본형 데이터는 그에 해당하는 각각의 매핑된 클래스를 가진다.
 * 이 클래스를 Wrapper 클래스라고 하는데 이 클래스의 필드, 메소드를 이용하면
 * 파워풀한 성능을 사용할 수 있다.
 * 키워드로서의 data type은 이것을 사용할 수 없음을 비교해서 보자.
 */

public class DataTypeTest3 {

	public static void main(String[] args) {
		System.out.println("------------Byte------------");
		System.out.println("Maximum value : " + Byte.MAX_VALUE);
		System.out.println("Minimum value : " + Byte.MIN_VALUE);
	}

}
