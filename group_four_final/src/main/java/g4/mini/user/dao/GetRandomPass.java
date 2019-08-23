package g4.mini.user.dao;

public class GetRandomPass {
	public String service(int leng) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		int idx = 0;

		StringBuffer sb = new StringBuffer();

//		System.out.println("charSet.length :::: " + charSet.length);

		for (int i = 0; i < leng; i++) {
			idx = (int) (charSet.length * Math.random()); // 36 * 생성된 난수를 Int로 (소숫점제거) 
//			System.out.println("idx :::: " + idx); 
			sb.append(charSet[idx]); } 
		
		return sb.toString();
	}
	
}
