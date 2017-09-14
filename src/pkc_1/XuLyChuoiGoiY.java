package pkc_1;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class XuLyChuoiGoiY {
	public static void main(String[] args) {
		ArrayList<String> arrayKeywords = new ArrayList<>();

		arrayKeywords.add("Doremon");
		arrayKeywords.add("Doremon tap 1");
		arrayKeywords.add("Doremon 2017");
		arrayKeywords.add("dDoremon tac gia Fujiko Fujio");
		arrayKeywords.add("doremon tap 2");
		arrayKeywords.add("Truyen tranh doremon");
		arrayKeywords.add("Truyen tranh mau Doremon");
		arrayKeywords.add("Truyen che doremon");
		arrayKeywords.add("Doremon che");
		arrayKeywords.add("doremon bua");
		arrayKeywords.add("Doremon abg");
		arrayKeywords.add("doremon tap 32");
		arrayKeywords.add("doremon ket thuc");
		arrayKeywords.add("doremon xuat ban 2014");
		arrayKeywords.add("doremon nhat ban");
		arrayKeywords.add("conan tap 32");
		arrayKeywords.add("doremon ket thuc");
		arrayKeywords.add("conan xuat ban 2014");
		arrayKeywords.add("Conan nhat ban");
		arrayKeywords.add("doremon bua");
		arrayKeywords.add("than dong dat viet abg");
		arrayKeywords.add("doremon tap 36");
		arrayKeywords.add("su su ket thuc");
		arrayKeywords.add("cong chua soi xuat ban 2014");
		arrayKeywords.add("doremon nhat ban");
		arrayKeywords.add("conan tap 32");
		arrayKeywords.add("cau be than dong ket thuc");

		/**
		 * TO LOWER CASE
		 */
		ArrayList<String> newArray = new ArrayList<>();
		for (String item : arrayKeywords) {
			newArray.add(item.toLowerCase());
		}
		
		String result = topKeyWord(newArray.get(0), newArray.get(1));
		for (int i = 2; i < 7 /*newArray.size()*/; i++) {
			result = topKeyWord(result, newArray.get(i));
		}
		System.out.println("CHUOI CON CHUNG CUA CSDL KEYWORD: " + result);
		

		// String chuoiA = "toi la thang";
		// String chuoiB = " toi la tuan f";
		// System.out.println("Ket qua: " + topKeyWord(chuoiA, chuoiB));

		// String str = "Hoàng Minh Thắng";
		// System.out.println("Chuyen doi ky tu co dau: " +
		// convertStringToURL(str));
	}

	public static String topKeyWord(String stringA, String stringB) {

		int[][] L = new int[stringA.length() + 1][stringB.length() + 1];

		int z = 0;

		String ret = "";

		for (int i = 1; i <= stringA.length(); i++) {
			for (int j = 1; j <= stringB.length(); j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				}
			}
		}

		for (int i = 1; i <= stringA.length(); i++) {
			for (int j = 1; j <= stringB.length(); j++) {
				if (stringA.charAt(i - 1) == stringB.charAt(j - 1)) {
					if (i == 1 || j == 1) {
						L[i][j] = 1;
					} else {
						L[i][j] = L[i - 1][j - 1] + 1;
					}

					if (L[i][j] > z) {
						z = L[i][j];
						ret = stringA.substring(i - z, i);
					} else {
						if (L[i][j] == z) {
							ret = ret + stringA.substring(i - z, i);
						}
					}
				} else {
					L[i][j] = 0;
				}
			}
		}

		System.out.println("Chuoi con chung dai nhat la:");
		System.out.println("-" + ret + "-");

		return ret;
	}

	public static String convertStringToURL(String str) {
		try {
			String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
}
