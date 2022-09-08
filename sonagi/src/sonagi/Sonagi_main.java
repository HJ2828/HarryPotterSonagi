package sonagi;

public class Sonagi_main {
	public static void main(String[] args) { // Main 시작점 

		Sonagi_main main = new Sonagi_main(); 
		Sonagi_Nick gui = new Sonagi_Nick();  //닉네임 설정 화면 띄우기 
		
		gui.setSonagi_main(main); // Main 위치 등록 ;
	}
	
	// 닉네임 클래스 , 닉네임 가지고 showGameView 메소드 실행 
	public void showGameView(Sonagi_Nick gui, String nick, int num){
		
		gui.dispose();//닉네임 화면 없애기
		Sonagi_GameView game = new Sonagi_GameView(nick, num);// 닉네임, 기숙사번호 가지고 게임화면 띄우기 
		
	}
}
