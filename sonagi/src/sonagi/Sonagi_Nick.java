package sonagi;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class Sonagi_Nick extends JFrame implements ActionListener,KeyListener{
	private JTextField textField;// 닉네임 입력창
	private  JLabel lblNewLabel;  // 라벨 
	public  String Nick_Name; // 닉네임 변수 
	public int number;	// 기숙사 번호
	Sonagi_main main; // Main
	// 추가
	private JPanel backPanel, radioPanel;
	private JLabel backlabel, dormitory_label;
	private JButton btnNewButton;
	ImageIcon Icon_img = new ImageIcon("HarryPotterIcon.png");
	ImageIcon back_img = new ImageIcon("NickBackground.png");
	String[] dormitories = {"Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"};
	ImageIcon gryffindor_img = new ImageIcon("Gryffindor.png");
	ImageIcon ravenclaw_img = new ImageIcon("Ravenclaw.png");
	ImageIcon slytherin_img = new ImageIcon("Slytherin.png");
	ImageIcon hufflepuff_img = new ImageIcon("Hufflepuff.png");
	private JRadioButton griffindor, ravenclaw, slytherin, hufflepuff;
	
	public Sonagi_Nick(){
		// 화면구성 
		setSize(500,610);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Harry Potter 산성비 게임");
		setIconImage(Icon_img.getImage());
		
		backPanel = new JPanel();	// 닉네임화면 배경 패널
		backPanel.setLayout(null);
		backPanel.setBackground(Color.black);
		
		backlabel = new JLabel();	// 배경에 넣을 이미지
		backlabel.setIcon(back_img);
		backlabel.setBounds(0, 0, 485, 570);
		
	    lblNewLabel = new JLabel("       프로필 설정"); // 라벨 
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN | Font.BOLD, 30));
		lblNewLabel.setBounds(90, 32, 381, 31);

	// --------------- 기숙사 선택(라디오박스, 이미지) ---------------
		radioPanel = new JPanel();
		dormitory_label = new JLabel();
		dormitory_label.setBounds(50, 100, 210, 260);
		
		griffindor = new JRadioButton("그리핀도르");
		ravenclaw = new JRadioButton("레번클로");
		slytherin = new JRadioButton("슬리데린");
		hufflepuff = new JRadioButton("후플프푸");

		griffindor.setOpaque(false);	// 라디오박스 버튼 배경 투명하게
		ravenclaw.setOpaque(false);
		slytherin.setOpaque(false);
		hufflepuff.setOpaque(false);
		
		ButtonGroup dormitory = new ButtonGroup();	// 라디오박스 버튼
		dormitory.add(griffindor);
		dormitory.add(ravenclaw);
		dormitory.add(slytherin);
		dormitory.add(hufflepuff);
		
		griffindor.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		ravenclaw.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		slytherin.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		hufflepuff.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		
		griffindor.addActionListener(this);	// 라디박스 버튼 이벤트 (this)
		ravenclaw.addActionListener(this);
		slytherin.addActionListener(this);
		hufflepuff.addActionListener(this);
		
		radioPanel.add(griffindor);	// 라디오박스 패널에 버튼 추가
		radioPanel.add(ravenclaw);
		radioPanel.add(slytherin);
		radioPanel.add(hufflepuff);		
		radioPanel.setOpaque(false);	// 라디오 패널 투명		
		radioPanel.setBounds(310, 160, 90, 140);

		// 기본값으로 그리핀도르
		dormitory_label.setIcon(gryffindor_img);
		griffindor.setSelected(true);
		number = 1;
	// --------------- 기숙사 선택 끝 ---------------		
		
		textField = new JTextField(); //닉네임 입력창 
		textField.setBorder(new LineBorder(Color.black, 2));
		textField.setFont(new Font("휴먼편지체", Font.BOLD, 24));
		textField.setBounds(180, 400, 250, 40);
		textField.setColumns(10);
		textField.setOpaque(false);
		
		btnNewButton = new JButton("확인"); //확인버튼 
		btnNewButton.setFont(new Font("휴먼편지체", Font.BOLD, 22));
		btnNewButton.setBounds(175, 480, 150, 40);
		btnNewButton.addActionListener(this);
		btnNewButton.setBorder(new LineBorder(Color.black, 2));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		
		JLabel lblNewLabel_1 = new JLabel("이름"); // 닉네임 라벨 
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 400, 188, 40);
		
		// 프레임, 패널 add
		backPanel.add(radioPanel);
		backPanel.add(btnNewButton);
		backPanel.add(lblNewLabel_1);
		backPanel.add(textField);
		backPanel.add(dormitory_label);
		backPanel.add(lblNewLabel);
		backPanel.add(backlabel);
		add(backPanel);
		
		setLocationRelativeTo(null);	// 프레임 화면 중앙에 배치
		setResizable(false);	// 프레임 크기 고정
		setVisible(true);
		
		// 닉네임 입력창 키 이벤트 (this)
		textField.addKeyListener(this);
		
	}
	// 버튼  이벤트 
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == griffindor) {	// 그리핀도르 선택
			dormitory_label.setIcon(gryffindor_img);
			number = 1;	// 기숙사 번호1
		}
		if(e.getSource() == ravenclaw) {	// 레번클로 선택
			dormitory_label.setIcon(ravenclaw_img);
			number = 2;	// 기숙사 번호2
		}
		if(e.getSource() == slytherin) {	// 슬리데린 선택
			dormitory_label.setIcon(slytherin_img);
			number = 3;	// 기숙사 번호3
		}
		if(e.getSource() == hufflepuff) {	// 후플프푸 선택
			dormitory_label.setIcon(hufflepuff_img);
			number = 4;	// 기숙사 번호4
		}
		  
		if(e.getSource() ==  btnNewButton) {	// 확인 버튼
			if(!textField.getText().equals("")){			
				// 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후 게임화면 띄우기 
				Nick_Name = textField.getText().toString();
				main.showGameView(this, Nick_Name, number);
			}else {
				// 텍스트 입력창에 값이 없다면 라벨텍스트 변경 
				lblNewLabel.setText("올바르지 않은 설정입니다.");
			}
		}
	}

	//Main 등록 
	public void setSonagi_main(Sonagi_main main) {
	
		this.main =main;
		
	}
	//엔터키 이벤트 
	@Override
	public void keyPressed(KeyEvent e) {
		//엔터키 이벤트 
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			// 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후 게임화면 띄우기 
			if(!textField.getText().equals("")){	
				Nick_Name = textField.getText().toString();
				System.out.println(Nick_Name);
				main.showGameView(this, Nick_Name, number);
			}
			else {
				// 텍스트 입력창에 값이 없다면 라벨텍스트 변경 
				lblNewLabel.setText("올바르지 않은 설정입니다.");
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
}