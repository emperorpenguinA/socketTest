package fizzbazz;

public class FizzBazz {

	/**
	 * 1-100を出力
	 *
	 * 3で割り切れるときFizz
	 * 5で割り切れるときBazz
	 * 両方で割り切れるときFizzBazz
	 * それ以外は数字
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(checkFizzBazz(i));
		}
	}

	/**
	 * 3,5,15で割り切れるかどうか判定し、表示する文字列を返す
	 *
	 * @param i 判定対象の数値
	 * @return 表示する文字列
	 */
	private static String checkFizzBazz(int i) {
		String result = "";

		/*
		 * 3,5,15で割ったあまりを取得する
		 * (対象の数字) - (対象の数字をAで割った商) * A で取得できる
		 */
		int rest3 = i - (i / 3) * 3;
		int rest5 = i - (i / 5) * 5;
		int rest15 = i - (i / 15) * 15;

		if (rest15 == 0) {
			result = "FizzBazz";
		} else if (rest3 == 0) {
			result = "Fizz";
		} else if (rest5 == 0) {
			result = "Bazz";
		} else {
			result += i;
		}

		return result;
	}

}
