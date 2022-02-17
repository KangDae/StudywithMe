package DTO;

public class Protocol {
	public static final String REGISTER = "100"; // 회원가입(request) 나

	public static final String IDSEARCH = "110"; // ID찾기 Join (request) 대준님

	public static final String IDSEARCH_OK = "111"; // ID찾기 (기존에 있는거) (ACK)

	public static final String IDSEARCH_NO = "112"; // ID찾기 (기존에 없음) (NACK)

	public static final String IDSEARCHCHECK = "113"; // (using 회원가입)ID찾기 중복확인(request)

	public static final String IDSEARCHCHECK_OK = "114"; // (using 회원가입)ID 중복확인 (사용가능) (ACK)

	public static final String IDSEARCHCHECK_NO = "115"; // (using 회원가입)ID 중복확인 (사용 불가능) (NACK)

	public static final String ENTERLOGIN = "120"; // 로그인(request) 대준님
	
	public static final String ENTERLOGIN_OK = "121"; // 로그인 성공(ACK)

	public static final String ENTERLOGIN_NO = "122"; // 로그인 실패(NACK)
	
	public static final String ENTERLOGIN_OK_USERINFOMATION = "123"; // 유저 정보 가져옴(INFO)
	
	public static final String ENTERLOGIN_USERINFOMATION_CHECK = "124"; // 재차확인
	
	public static final String ENTERLOGIN_USERINFOMATION_CHECK_NOT = "125"; // 비밀번호 틀림
	
	public static final String UPDATE_NAME = "140"; // 이름변경
	
	public static final String UPDATE_PASSWORD = "141"; // 비번변경
	
	public static final String UPDATE_IDNAME = "142"; // 아디변경
	
	public static final String UPDATE_BIRTH = "143"; // 생일변경
	
	public static final String UPDATE_MAIL = "144"; // 생일변경
	
	public static final String PWSEARCH = "130"; // PW찾기 대준님
	
	public static final String PWSEARCH_OK = "131"; // PW찾기 (정보가 존재함)
	
	public static final String PWSEARCH_NO = "132"; // PW찾기 (정보가 존재하지않음)
	
	public static final String PWRESET_OK = "133"; // PW 재설정 완료
	
	public static final String PWRESET_NO = "134"; // PW 재설정 실패

	public static final String ROOMMAKE = "200"; // 방만들기 나

	public static final String ROOMMAKE_OK = "201"; // 방만들기_ACK

	public static final String ROOMMAKE_OK1 = "202"; // 방만들기_ACK(만든사람에게)
	
	public static final String SearchRoom = "205"; // 방 검색 123

	public static final String ROOMSORT = "210"; // 방정렬 나
	
	public static final String ROOMSORT_MYROOM = "211"; // 방정렬 내방만

	public static final String EXITWAITROOM = "220"; // 대기방 나가기(= logout) 

	public static final String SENDWAITROOM = "250"; // 대기방 메세지

	public static final String ENTERROOM = "300"; // 방입장 나

	public static final String ENTERROOM_OK = "301"; // 방입장 성공

	public static final String ENTERROOM_OK1 = "302"; // 방입장 성공 //입장하는 당사자

	public static final String ENTERROOM_NO = "303"; // 방입장 실패

	public static final String ENTERROOM_USERLISTSEND = "305"; // 방에 유저들을 보내줌

	public static final String EXITCHATTINGROOM = "310"; // 방나가기 (채팅방 나가기)
	
	public static final String DISMANTINGROOM = "320";
	
	public static final String DISMANTINGROOMMASTER = "321"; //방장이 모임해체를 눌렀을때 
	
	public static final String DISMANTINGROOMUSER = "322"; //일반 유저가 모임해체를눌렀을때

	public static final String SENDMESSAGE = "400"; // 메세지 보내기

	public static final String SENDMESSAGE_ACK = "410"; // 메세지 보내기(답장)

	public static final String CHATTINGSENDMESSAGE = "420"; // 채팅방에서 메세지 보내기 (Request)

	public static final String CHATTINGSENDMESSAGE_OK = "430"; // 채팅방에서 메세지 보내기 (Request)
	
	public static final String CHATTINGSENDMESSAGE_MASTER_OK = "440";
	
	public static final String CHATTINGSCROLLBARDOWN = "450";
	
	public static final String CHATTINGFILESEND_SYN = "500"; // 파일전송1

	public static final String CHATTINGFILESEND_SYNACK = "510"; // 파일전송2

	public static final String CHATTINGFILESEND_FILE = "520"; // 파일전송3

	public static final String CHATTINGFILESEND_FILEACK = "530"; // 파일전송4

	public static final String CHATTINGFILEDOWNLOAD_SYN = "550"; // 파일 다운로드1

	public static final String CHATTINGFILEDOWNLOAD_SEND = "560"; // 파일 보냄
	
	public static final String WRITENOTICEBOARD = "600"; //게시판 작성
	
	public static final String ENTERNOTICEBOARD_SERVER = "611"; //서버 게시판 조회
	
	public static final String ENTERNOTICEBOARD = "610"; // 게시판 조회
	
	public static final String WRITENOTICEBOARD_MASTER = "620"; //게시판 만든 당사자
	
	public static final String SHAREDISPLAY = "630"; //화면 공유
	
	public static final String WATCHDISPLAY = "640"; //화면 보기
	

}
