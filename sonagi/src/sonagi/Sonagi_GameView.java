package sonagi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;	// 추가: 이미지
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Sonagi_GameView extends JFrame implements ActionListener, KeyListener, ListSelectionListener {

	private JTextField textField_1;
	private JButton btn_gamestart;
	private String[] magicKor = { "아비스", "아센디오", "아씨오", "아구아멘티", "알로호모라", "아나프니오", "콘프링고", "봄바르다", "콜로포터스", "컨푼도",
			"크루시오", "데포디오", "디펄소", "디센디움", "디센도", "디핀도", "듀로", "에렉토", "잉고르지오", "디프리모",
			"에바네스코", "페룰라", "페리큘럼", "피네스타", "파이어스툼", "퍼넌큘러스", "제미니오", "글리세오", "임모뷸러스", "임페디멘타",
			"임페리오", "인센디오", "랭록", "로코모토르", "루모스", "모스모드레", "머플리아토", "녹스", "오클루먼시", "옵스큐로", 
			"옵푸그노", "포터스", "프로테고", "팩", "콰이어투스", "리덕토", "릴라시오", "레파로", "릭투셈프라", "리듀시오", 
			"레벨리오", "리디큘러스", "실렌시오", "소노루스", "스투페파이", "섹튬셈프라", "테르지오", "와디와시", "업", "윙가르디움" };
	private String[] magicEng = { "abis", "accendio", "accio", "aguamenti", "alohomora", "anapneo", "confringo", "bombarda", "colloportus", "confundo",
			"crucio", "defodio", "depulso", "dissendium", "descendo", "diffindo", "duro", "erecto", "engorgio", "deprimo",
			"evanesco", "ferula", "ferriculum", "finesta", "firesturm", "furnunculus", "geminio", "glisseo", "immobulus", "imperius",
			"imperio", "incendio", "langlock", "locomotor", "lumos", "mosmordre", "muffliato", "nox", "occlumency", "obscuro", 
			"oppugno", "portus", "protego", "pack", "quietus", "reducto", "relashio", "reparo", "rictusempra", "reducio", 
			"revelio", "riddikulus", "silencio", "sonorus", "stupefy", "scourgify", "tergeo", "waddiwasi", "up", "wingardium" };
	private String[] game_LV = { "     Level 1", "     Level 2", "     Level 3", "     Level 4", "     Level 5", "     Level 6", "     Level 7"};
	private JPanel panel_Screen;
	private JLabel label[] = new JLabel[10000];
	private JLabel score;
	private int scorenum = 0;
	private int i = 0;
	private JList list;
	private int spd = 3500;
	private int life = 0;
	private JLabel level;
	private JPanel panel_over;
	private JLabel lblNewLabel;
	private JLabel lblScore;
	private JLabel Label_nickname;
	private JLabel lblNick;
	private String NickName;
	Sonagi_main main;
	// 추가
	private int dormNum;
	private JPanel background_panel;
	private JLabel background_label;
	private JLabel gamelabel, gameoverlabel, label_life1, label_life2, label_life3, dorm_label, time_label, textlabel;
	private JButton btn_gameend, btn_Lang, btn_bgm;
	ImageIcon Icon_img = new ImageIcon("HarryPotterIcon.png");
	ImageIcon gameBack_img = new ImageIcon("GameBackground.png");
	ImageIcon gamePanel_img = new ImageIcon("gamePanel_Img.png");
	ImageIcon gameOver_img = new ImageIcon("gameOver_Img.png");
	ImageIcon life_img = new ImageIcon("lightning_color.png");
	ImageIcon life_death_img = new ImageIcon("lightning.png");
	ImageIcon gryffindor_img = new ImageIcon("Gryffindor.png");
	ImageIcon ravenclaw_img = new ImageIcon("Ravenclaw.png");
	ImageIcon slytherin_img = new ImageIcon("Slytherin.png");
	ImageIcon hufflepuff_img = new ImageIcon("Hufflepuff.png");
	ImageIcon soundOff_img = new ImageIcon("soundOff.png");
	ImageIcon soundOn_img = new ImageIcon("soundOn.png");
	Sonagi_Bgm bgm = new Sonagi_Bgm();	// BGM
	boolean timer = false;

	public Sonagi_GameView(String Nick, int num) {
		NickName = Nick;// 닉네임 변수 저장
		dormNum = num;	// 기숙사 선택 변수 저장
		
		// 화면구성
		setIconImage(Icon_img.getImage());
		setTitle("Harry Potter 산성비 게임");
		setSize(1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 추가: 배경 이미지
		background_panel = new JPanel();
		background_panel.setLayout(null);
		background_panel.setBackground(Color.black);
		background_label = new JLabel();
		background_label.setIcon(gameBack_img);
		background_label.setBounds(0, 0, 1200, 765);
		

		textField_1 = new JTextField();// 단어입력
		textField_1.setBorder(new LineBorder(Color.black, 2));
		textField_1.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		textField_1.setBounds(250, 631, 300, 40);
		textField_1.setColumns(10);
		textField_1.setOpaque(false);

		list = new JList(game_LV);// 레벨 리스트 보여주기
		list.setSelectedIndex(0);
		list.setFont(new Font("휴먼편지체", Font.BOLD, 22));
		list.setBounds(986, 80, 162, 200);
		list.setBorder(new LineBorder(Color.black, 2));
		list.setOpaque(false);
		
		btn_gamestart = new JButton("시작");// 시작 버튼
		btn_gamestart.setFont(new Font("휴먼편지체", Font.BOLD, 23));
		btn_gamestart.setBounds(1000, 300, 130, 38);
		btn_gamestart.setBorder(new LineBorder(Color.black, 2));
		btn_gamestart.setContentAreaFilled(false);
		btn_gamestart.setOpaque(false);
		
		btn_gameend = new JButton("그만두기");// 그만두기 버튼
		btn_gameend.setFont(new Font("휴먼편지체", Font.BOLD, 23));
		btn_gameend.setBounds(1000, 350, 130, 38);
		btn_gameend.setBorder(new LineBorder(Color.black, 2));
		btn_gameend.setContentAreaFilled(false);
		btn_gameend.setOpaque(false);

		panel_Screen = new JPanel();// 게임화면
		panel_Screen.setLayout(null);
		gamelabel = new JLabel();
		gamelabel.setBounds(0, 0, 740, 571);
		gamelabel.setIcon(gamePanel_img);
		panel_Screen.setBounds(43, 29, 740, 571);
		
		JPanel panel_1 = new JPanel(); // 게임화면에서 하단 선
		panel_1.setBackground(new Color(243, 187, 15));
		panel_1.setBounds(0, 520, 740, 10);
		panel_Screen.add(panel_1);

		score = new JLabel("0점");// 점수판
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		score.setBounds(823, 180, 149, 45);

		Label_nickname = new JLabel(Nick); //닉네임 
		Label_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		Label_nickname.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		Label_nickname.setBounds(845, 690, 250, 27);
		
		// 추가: 기숙사 이미지
		dorm_label = new JLabel();
		dorm_label.setBounds(860, 410, 210, 260);
		
		if(dormNum == 1) {	// 그리핀도르 선택
			dorm_label.setIcon(gryffindor_img);
		}
		else if(dormNum == 2) {	// 레번클로 선택
			dorm_label.setIcon(ravenclaw_img);
		}
		else if(dormNum == 3) {	// 슬리데린 선택
			dorm_label.setIcon(slytherin_img);
		}
		else {	// 후플프푸 선택
			dorm_label.setIcon(hufflepuff_img);
		}

		//레벨 리스트
		level = new JLabel("     Level 1");
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("휴먼편지체", Font.BOLD, 24));
		level.setBounds(790, 100, 150, 42);

		label_life1 = new JLabel(); // 생명1
		label_life1.setIcon(life_img);
		label_life1.setBounds(805, 260, 50, 100);

		label_life2 = new JLabel(); // 생명2
		label_life2.setIcon(life_img);
		label_life2.setBounds(865, 260, 50, 100);

		label_life3 = new JLabel(); // 생명2
		label_life3.setIcon(life_img);
		label_life3.setBounds(925, 260, 50, 100);

		// 게임결과화면
		panel_over = new JPanel();// 게임결과 백스라운드 
		panel_over.setLayout(null);
		gameoverlabel = new JLabel();
		gameoverlabel.setBounds(0, 0, 740, 571);
		gameoverlabel.setIcon(gameOver_img);
		panel_over.setBackground(new Color(255, 0, 0, 0));
		panel_over.setBounds(43, 29, 740, 571);	

		lblNewLabel = new JLabel("Game Over");		// 게임 오버 라벨 
		lblNewLabel.setBounds(0, 150, 740, 63);
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNick = new JLabel("Nick");		// 닉네임 
		lblNick.setBounds(0, 250, 740, 50);
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setForeground(Color.black);
		lblNick.setFont(new Font("휴먼편지체", Font.BOLD, 50));

		lblScore = new JLabel("Score");		// 게임결과 점수 
		lblScore.setBounds(0, 360, 740, 50);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.black);
		lblScore.setFont(new Font("휴먼편지체", Font.BOLD, 50));
		
		// 영어 한글 버튼
		btn_Lang = new JButton("한국어");	// 첫 시작은 한국어
		btn_Lang.setFont(new Font("휴먼편지체", Font.BOLD, 23));
		btn_Lang.setBounds(600, 631, 130, 38);
		btn_Lang.setBorder(new LineBorder(Color.black, 2));
		btn_Lang.setContentAreaFilled(false);
		btn_Lang.setOpaque(false);

		// BGM 버튼
		bgm.Play();	// 첫 시작은 소리on
		btn_bgm = new JButton(soundOn_img);
		btn_bgm.setBounds(1080, 15, 70, 50);
		btn_bgm.setContentAreaFilled(false);
		btn_bgm.setBorderPainted(false);
		btn_bgm.setOpaque(false);
		
		// 타이머
		time_label = new JLabel("Time: 0:00:00");
		time_label.setFont(new Font("휴먼편지체", Font.BOLD, 23));
		time_label.setBounds(820, 40, 200, 38);

		// 버튼,리스트,키 이벤트설정및 텍스트필드포커스 설정
		btn_gamestart.addActionListener(this); // 시작 버튼 이벤트
		btn_gameend.addActionListener(this); // 그만두기 버튼 이벤트
		btn_Lang.addActionListener(this);	// 추가: 언어변경 버튼 이벤트
		btn_bgm.addActionListener(this); 	// 추가: bgm 버튼 이벤트
		textField_1.addKeyListener(this); // 키 이벤트
		list.addListSelectionListener(this); // 리스트 이벤트
		textField_1.requestFocus(); // 텍스트 포커스

		
		// 프레임, 패널 add
		panel_Screen.add(gamelabel);	// 게임 화면
		background_panel.add(panel_Screen);	// 배경에 게임화면 넣기
		panel_Screen.setVisible(false);
		
		panel_over.add(lblNewLabel);	//게임 오버 라벨
		panel_over.add(lblScore); // 게임결과 점수 
		panel_over.add(lblNick);// 닉네임 
		panel_over.add(gameoverlabel);	// 게임오버 화면
		background_panel.add(panel_over);	// 배경에 게임오버 화면 넣기
		panel_over.setVisible(false);
		
		background_panel.add(time_label);	// 타이머
		background_panel.add(btn_bgm);	// bgm 버튼
		background_panel.add(textField_1);	// 텍스트필드
		background_panel.add(dorm_label);	// 기숙사 이미지
		background_panel.add(Label_nickname);	// 닉네임
		background_panel.add(label_life1);	// 목숨1
		background_panel.add(label_life2);	// 목숨2
		background_panel.add(label_life3);	// 목숨3
		background_panel.add(level);	// 레벨
		background_panel.add(score);	// 점수
		background_panel.add(list);		// 레벨선택 리스트
		background_panel.add(btn_gamestart);	// 게임시작 버튼
		background_panel.add(btn_gameend);		// 그만두기 버튼
		background_panel.add(btn_Lang);	// 언어변경 버튼
		background_panel.add(background_label);	// 배경
		add(background_panel);
		
		setLocationRelativeTo(null);	// 프레임 화면 중앙에 배치
		setResizable(false);	// 프레임 크기 고정
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 게임시작 버튼 이벤트
		if (e.getSource().equals(btn_gamestart)) {

			panel_Screen.setVisible(true);
			// 라이프 0 = 생명이 모두 있는것
			life = 0;
			score.setText("0점"); // 게임시작시 점수판 0점
			scorenum = 0; // 게임점수 변수 =0
			// 만약에 게임결과화면이 띄어져 있으면 보이지 않게
			if (panel_over.isVisible()) {
				panel_over.setVisible(false);// 결과화면 안보이게
			}

			// 단어가 만들어져 있는지 확인
			if (label[0] != null) {
				for (int i = 0; i < label.length; i++) {
					// 쓰레드가 돌아가고 있으면 중지
					if (!new Sonagi_Thead().isAlive() || !new Sonagi_Move().isAlive()) {
						new Sonagi_Thead().interrupt();// 단어 쓰레드 중지
						new Sonagi_Move().interrupt();// 내려가는 쓰레드 중지
					}
					// 단어가 만들어져 있다면 안보이게
					if (label[i] != null) {
						label[i].setVisible(false);
					}
				}
			}

			// 게임시작시 텍스트필드 포커스 주기
			textField_1.requestFocus();
			// 단어를 뿌려주는 쓰레드 실행
			new Sonagi_Thead().start();
			
			System.out.println(timer + "시작");
			timer = true;
			new Sonagi_Timer().start();

		}
		
		// 그만두기 버튼 추가
		if(e.getSource().equals(btn_gameend)) {
			// 게임 결과화면 띄우기
			panel_Screen.setVisible(false);
			panel_over.setVisible(true);
			lblScore.setText(score.getText());
			lblNick.setText(NickName);
			// 쓰레드 중지
			new Sonagi_Thead().interrupt();
			new Sonagi_Move().interrupt();
			
			System.out.println(timer + "종료");
			timer = false;
			new Sonagi_Timer().interrupt();
		}
		
		// 언어 변경(영어, 한국어) 버튼
		if(e.getSource().equals(btn_Lang)) {
			if(btn_Lang.getText().equals("영어")) {	// 영어 버튼
				btn_Lang.setText("한국어");	// 한국어 버튼 변경
			}
			else{	// 한국어 버튼
				btn_Lang.setText("영어");	// 영어 버튼으로 변경
			}
		}
		
		// bgm 버튼(on,off)
		if(e.getSource().equals(btn_bgm)) {
			if(btn_bgm.getIcon().equals(soundOn_img)) {	// 소리O 이미지
				btn_bgm.setIcon(soundOff_img);	// 소리X 이미지로 바꾸기
				bgm.Stop();	// 소리 일시정지
			}
			else if(btn_bgm.getIcon().equals(soundOff_img)) {	// 소리X 이미지
				btn_bgm.setIcon(soundOn_img);	// 소리O 이미지로 바꾸기
				bgm.Play();	// 소리 재생
			}
		}
	}

	// 단어를 입력하여 동일단어 있는지 확인하는 키이벤트
	@Override
	public void keyPressed(KeyEvent e) {
		// 엔터키 이벤트
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// 텍스트 필드에 값이 있는지 없는지 확인
			if (!textField_1.getText().equals("")) {
				// String 변수에 텍스트 값 주기
				String work_answer = textField_1.getText().toString();
				//텍스트 입력값과 동일한 단어 있는지 검사 동일 단어 있을시 안보이게 하고 점수 5점 주기 ,텍스트값 삭제(단어가 틀리더라도 )
				for (int i = 0; i <= label.length; i++) { // 동일 단어 검사 for
					try {
						if (work_answer.equals(label[i].getText())) {// 동일단어 검사
							if (label[i].isVisible()) { // 동일단어가 화면에 보여져 있는지 검사
								scorenum = scorenum += 5; // 점수 +5
								score.setText(scorenum + "점"); // 점수판 점수 변경
								label[i].setVisible(false);// 단어 화면에서 안보이게
								textField_1.setText("");// 텍스트 값 없애기
							}
						} else {
							textField_1.setText("");
						}
					} catch (Exception e2) {
						e2.getMessage();
					}
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	// 단어를 하나씩 뿌려주는 쓰레드
	class Sonagi_Thead extends Thread {

		@Override
		public void run() {
			panel_Screen.setVisible(true);// 게임화면 등장

			// 단어를 레벨에 따른 속도로 게임화면에 x값 랜덤으로생성
			for (i = 0; i <= 10000; i++) {

				try {

					Random random = new Random();// 랜덤 객체 생성
					
					if(btn_Lang.getText().equals("한국어")) // 한국어 버튼 클릭시, 한국어 단어 나오게
						label[i] = new JLabel(magicKor[random.nextInt(magicKor.length)]);// 단어 랜덤으로 가지고옴
					else if(btn_Lang.getText().equals("영어")) // 영어 버튼 클릭시, 영어 단어 나오게
						label[i] = new JLabel(magicEng[random.nextInt(magicEng.length)]);// 단어 랜덤으로 가지고옴
					
					// 단어 색, 폰드 변경
					label[i].setFont(new Font("휴먼편지체", Font.PLAIN, 18));
					label[i].setForeground(Color.white);
					label[i].setBounds(0, 0, 100, 30);// 단어 초기 위치 높이,폭 설정
					gamelabel.add(label[i]);// 단어 추가
					label[i].setLocation(random.nextInt(678), 2);// x값 랜덤으로 보여주기
					
					// 단어를 움직이는 쓰레드 실행
					new Sonagi_Move().start();

					Thread.sleep(spd);// 게임레벨에 따른 단어속도		
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 단어 내려가고,게임오버 확인하는 쓰레드
	class Sonagi_Move extends Thread {

		@Override
		public void run() {

			// 단어 생성 갯수 만큼 for 돌려 각 단어마다 y값 변경
			for (int a = 0; a <= i; a++) {
				if (label[a].isVisible()) {
					int sp = label[a].getY();
					int xp = label[a].getX();

					label[a].setLocation(xp, sp + 10);

				}

				// 단어가 보여져있는 상태로 선을 넘었는지 확인
				if (label[a].isVisible() && label[a].getY() > 512) {
					label[a].setVisible(false);// 단어가 선을 넘으면 단어 사라짐
					life++;// 라이프 1 = 생명 1없어짐
				}
			}

			// 라이프 확인
			switch (life) {
			case 0:// 생명 모두 있음
				label_life1.setIcon(life_img);
				label_life2.setIcon(life_img);
				label_life3.setIcon(life_img);
				break;

			case 1: // 생명 1개 없어짐
				label_life1.setIcon(life_death_img);
				label_life2.setIcon(life_img);
				label_life3.setIcon(life_img);
				break;

			case 2:// 생명 2 없어짐
				label_life1.setIcon(life_death_img);
				label_life2.setIcon(life_death_img);
				label_life3.setIcon(life_img);
				break;
			case 3:// 생명 3개 없어짐 게임오버
				label_life1.setIcon(life_death_img);
				label_life2.setIcon(life_death_img);
				label_life3.setIcon(life_death_img);
				// 게임 결과화면 띄우기
				panel_Screen.setVisible(false);
				panel_over.setVisible(true);
				lblScore.setText(score.getText());
				lblNick.setText(NickName);
				// 쓰레드 중지
				new Sonagi_Thead().interrupt();
				new Sonagi_Move().interrupt();
				
				// 타이머 쓰레드 중지
				timer = false;
				new Sonagi_Timer().interrupt();

				break;
			default:
				break;
			}
		}
	}

	//Main 등록 
	public void setSonagi_main(Sonagi_main main) {
		this.main = main;
	}

	// 레벨리스트 이벤트 처리
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		String str;
		if (arg0.getSource() == list) {

			switch (list.getSelectedIndex()) {
			case 0:
				spd = 3500;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str); // 레벨 라벨에 보여주기
				break;
			case 1:
				spd = 3000;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 2:
				spd = 2500;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 3:
				spd = 2000;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 4:
				spd = 1500;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 5:
				spd = 1000;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 6:
				spd = 500;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;			
			default:
				break;
			}
		}
	}
	
	// 타이머 스레드
	class Sonagi_Timer extends Thread {
		
		public int sec = 0;
		
		public void run() {
			try {
				while(timer == true) {	// sec(초)로 받아서 계산, 1초에 sec의 값 1씩 증가
				sec++;
				int min, hour;
				
				// 초를 시, 분으로 계산
				min = sec / 60;
				hour = min / 60;
				sec = sec % 60;
				min = min % 60;
					
				time_label.setText("Time: " + hour + ":" + min + ":" + sec);
				Thread.sleep(1000);
				}
			} 
			catch (InterruptedException e) {
				time_label.setText("Time: 0:00:00");
				e.printStackTrace();
			}
		}
	}
}
