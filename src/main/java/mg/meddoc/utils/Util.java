package mg.meddoc.utils;

public class Util {

	public static String generateCode() {
		String code = "";
		for(int i = 0; i < 6; i++) {
			code+=(Math.random()*10);
		}
		return code;
	}
}
