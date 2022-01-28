package Resource;

import javax.swing.ImageIcon;

import TitleTest.FrameCenter;
import TitleTest.FrameIDSearch;
import TitleTest.FrameLogin;
import TitleTest.FrameSearchPW;
import TitleTest.FrameSignup;
import TitleTest.FrameStart;

public interface R {
	public static final String[] tel = { "010", "02", "031", "032", "033", "041", "042", "043", "044", "051", "052", "053", "054",
			"055", "061", "062", "063", "064" };
	public static final String[] email = { "naver.com", "gmail.com" };
	public static final String[] ageYear = { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990",
			"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003",
			"2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
			"2017", "2018", "2019" };
	public static final String[] ageMonth = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	public static final String[] ageDay = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	public static final String[] roomTopic = { "경영", "마케팅", "고객관리", "개발", "디자인" };
	
	public ImageIcon image = new ImageIcon("Logo/로고.png");

	public static final FrameStart frameStart = new FrameStart(); // 시작화면
	public static final FrameLogin frameLogin = new FrameLogin(); // 배광민바보
	public static final FrameCenter frameCenter = new FrameCenter();
	public static final FrameSignup frameSignup = new FrameSignup();
	public static final FrameSearchPW frameSearchPw = new FrameSearchPW();
	public static final FrameIDSearch frameIdSearch = new FrameIDSearch();


	
	


}
