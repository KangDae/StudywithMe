package Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import TitleTest.FrameCenter;
import TitleTest.FrameChattingRoom;
import TitleTest.FrameSearchID;
import TitleTest.FrameLogin;
import TitleTest.FrameMakeRoom;
import TitleTest.FramePassWordCheck;
import TitleTest.FrameSearchPW;
import TitleTest.FrameSignup;
import TitleTest.FrameStart;

public class R extends JFrame{
	public static final String[] tel = { "010", "02", "031", "032", "033", "041", "042", "043", "044", "051", "052",
			"053", "054", "055", "061", "062", "063", "064" };
	public static final String[] email = { "naver.com", "gmail.com" };
	public static final String[] ageYear = { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988",
			"1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001",
			"2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014",
			"2015", "2016", "2017", "2018", "2019" };
	public static final String[] ageMonth = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	public static final String[] ageDay = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
			"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
			"31" };
	public static final String[] roomTopic = { "경영", "마케팅", "고객관리", "개발", "디자인" };
	public static final String SCRET = ":)s2";
	public static String scretNumber = ":)s2";
	public static String newPassword = ""; // 새로 만드는 비밀번호
	
	public static boolean condition_Email = false; // 이메일 확인 여부
	public static boolean condition_ID = true;    // 아이디 중복 확인 여부
	public static boolean condition_PW = false;    // 패스워드 유효성 검사 여부
	
	public ImageIcon image = new ImageIcon("Logo/로고.png");

	
	public static final FrameStart frameStart = new FrameStart(); // 시작화면
	public static final FrameLogin frameLogin = new FrameLogin(); // 배광민바보
	public static final FrameCenter frameCenter = new FrameCenter();
	public static final FrameSignup frameSignup = new FrameSignup();
	public static final FrameSearchPW frameSearchPw = new FrameSearchPW();
	public static final FrameSearchID frameSearchID = new FrameSearchID();
	public static final FrameMakeRoom frameMakeRoom = new FrameMakeRoom();
	public static final FrameChattingRoom frameChattingRoom = new FrameChattingRoom();
	public static final FramePassWordCheck framePassWordCheck = new FramePassWordCheck();
	
	public static final JButton btn_Confirm = new JButton("확인");

}
