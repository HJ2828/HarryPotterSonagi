package sonagi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;	// �߰�: �̹���
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
	private String[] magicKor = { "�ƺ�", "�Ƽ����", "�ƾ���", "�Ʊ��Ƹ�Ƽ", "�˷�ȣ���", "�Ƴ����Ͽ�", "��������", "���ٸ���", "�ݷ����ͽ�", "��Ǭ��",
			"ũ��ÿ�", "�������", "���޼�", "�𼾵��", "�𼾵�", "���ɵ�", "���", "������", "�װ�����", "��������",
			"���ٳ׽���", "����", "�丮ŧ��", "�ǳ׽�Ÿ", "���̾��", "�۳�ŧ����", "���̴Ͽ�", "�۸�����", "�Ӹ�淯��", "������Ÿ",
			"���丮��", "�μ����", "����", "���ڸ��丣", "���", "�𽺸�巹", "���ø�����", "�콺", "��Ŭ��ս�", "�ɽ�ť��", 
			"��Ǫ�׳�", "���ͽ�", "�����װ�", "��", "���̾�����", "������", "����ÿ�", "���ķ�", "����������", "����ÿ�", 
			"��������", "����ŧ����", "�Ƿ��ÿ�", "�ҳ�罺", "����������", "��Ƭ������", "�׸�����", "�͵�ͽ�", "��", "���������" };
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
	// �߰�
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
		NickName = Nick;// �г��� ���� ����
		dormNum = num;	// ����� ���� ���� ����
		
		// ȭ�鱸��
		setIconImage(Icon_img.getImage());
		setTitle("Harry Potter �꼺�� ����");
		setSize(1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// �߰�: ��� �̹���
		background_panel = new JPanel();
		background_panel.setLayout(null);
		background_panel.setBackground(Color.black);
		background_label = new JLabel();
		background_label.setIcon(gameBack_img);
		background_label.setBounds(0, 0, 1200, 765);
		

		textField_1 = new JTextField();// �ܾ��Է�
		textField_1.setBorder(new LineBorder(Color.black, 2));
		textField_1.setFont(new Font("�޸�����ü", Font.BOLD, 30));
		textField_1.setBounds(250, 631, 300, 40);
		textField_1.setColumns(10);
		textField_1.setOpaque(false);

		list = new JList(game_LV);// ���� ����Ʈ �����ֱ�
		list.setSelectedIndex(0);
		list.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		list.setBounds(986, 80, 162, 200);
		list.setBorder(new LineBorder(Color.black, 2));
		list.setOpaque(false);
		
		btn_gamestart = new JButton("����");// ���� ��ư
		btn_gamestart.setFont(new Font("�޸�����ü", Font.BOLD, 23));
		btn_gamestart.setBounds(1000, 300, 130, 38);
		btn_gamestart.setBorder(new LineBorder(Color.black, 2));
		btn_gamestart.setContentAreaFilled(false);
		btn_gamestart.setOpaque(false);
		
		btn_gameend = new JButton("�׸��α�");// �׸��α� ��ư
		btn_gameend.setFont(new Font("�޸�����ü", Font.BOLD, 23));
		btn_gameend.setBounds(1000, 350, 130, 38);
		btn_gameend.setBorder(new LineBorder(Color.black, 2));
		btn_gameend.setContentAreaFilled(false);
		btn_gameend.setOpaque(false);

		panel_Screen = new JPanel();// ����ȭ��
		panel_Screen.setLayout(null);
		gamelabel = new JLabel();
		gamelabel.setBounds(0, 0, 740, 571);
		gamelabel.setIcon(gamePanel_img);
		panel_Screen.setBounds(43, 29, 740, 571);
		
		JPanel panel_1 = new JPanel(); // ����ȭ�鿡�� �ϴ� ��
		panel_1.setBackground(new Color(243, 187, 15));
		panel_1.setBounds(0, 520, 740, 10);
		panel_Screen.add(panel_1);

		score = new JLabel("0��");// ������
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("�޸�����ü", Font.BOLD, 25));
		score.setBounds(823, 180, 149, 45);

		Label_nickname = new JLabel(Nick); //�г��� 
		Label_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		Label_nickname.setFont(new Font("�޸�����ü", Font.BOLD, 30));
		Label_nickname.setBounds(845, 690, 250, 27);
		
		// �߰�: ����� �̹���
		dorm_label = new JLabel();
		dorm_label.setBounds(860, 410, 210, 260);
		
		if(dormNum == 1) {	// �׸��ɵ��� ����
			dorm_label.setIcon(gryffindor_img);
		}
		else if(dormNum == 2) {	// ����Ŭ�� ����
			dorm_label.setIcon(ravenclaw_img);
		}
		else if(dormNum == 3) {	// �������� ����
			dorm_label.setIcon(slytherin_img);
		}
		else {	// ������Ǫ ����
			dorm_label.setIcon(hufflepuff_img);
		}

		//���� ����Ʈ
		level = new JLabel("     Level 1");
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("�޸�����ü", Font.BOLD, 24));
		level.setBounds(790, 100, 150, 42);

		label_life1 = new JLabel(); // ����1
		label_life1.setIcon(life_img);
		label_life1.setBounds(805, 260, 50, 100);

		label_life2 = new JLabel(); // ����2
		label_life2.setIcon(life_img);
		label_life2.setBounds(865, 260, 50, 100);

		label_life3 = new JLabel(); // ����2
		label_life3.setIcon(life_img);
		label_life3.setBounds(925, 260, 50, 100);

		// ���Ӱ��ȭ��
		panel_over = new JPanel();// ���Ӱ�� �齺���� 
		panel_over.setLayout(null);
		gameoverlabel = new JLabel();
		gameoverlabel.setBounds(0, 0, 740, 571);
		gameoverlabel.setIcon(gameOver_img);
		panel_over.setBackground(new Color(255, 0, 0, 0));
		panel_over.setBounds(43, 29, 740, 571);	

		lblNewLabel = new JLabel("Game Over");		// ���� ���� �� 
		lblNewLabel.setBounds(0, 150, 740, 63);
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("�޸�����ü", Font.BOLD, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNick = new JLabel("Nick");		// �г��� 
		lblNick.setBounds(0, 250, 740, 50);
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setForeground(Color.black);
		lblNick.setFont(new Font("�޸�����ü", Font.BOLD, 50));

		lblScore = new JLabel("Score");		// ���Ӱ�� ���� 
		lblScore.setBounds(0, 360, 740, 50);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.black);
		lblScore.setFont(new Font("�޸�����ü", Font.BOLD, 50));
		
		// ���� �ѱ� ��ư
		btn_Lang = new JButton("�ѱ���");	// ù ������ �ѱ���
		btn_Lang.setFont(new Font("�޸�����ü", Font.BOLD, 23));
		btn_Lang.setBounds(600, 631, 130, 38);
		btn_Lang.setBorder(new LineBorder(Color.black, 2));
		btn_Lang.setContentAreaFilled(false);
		btn_Lang.setOpaque(false);

		// BGM ��ư
		bgm.Play();	// ù ������ �Ҹ�on
		btn_bgm = new JButton(soundOn_img);
		btn_bgm.setBounds(1080, 15, 70, 50);
		btn_bgm.setContentAreaFilled(false);
		btn_bgm.setBorderPainted(false);
		btn_bgm.setOpaque(false);
		
		// Ÿ�̸�
		time_label = new JLabel("Time: 0:00:00");
		time_label.setFont(new Font("�޸�����ü", Font.BOLD, 23));
		time_label.setBounds(820, 40, 200, 38);

		// ��ư,����Ʈ,Ű �̺�Ʈ������ �ؽ�Ʈ�ʵ���Ŀ�� ����
		btn_gamestart.addActionListener(this); // ���� ��ư �̺�Ʈ
		btn_gameend.addActionListener(this); // �׸��α� ��ư �̺�Ʈ
		btn_Lang.addActionListener(this);	// �߰�: ���� ��ư �̺�Ʈ
		btn_bgm.addActionListener(this); 	// �߰�: bgm ��ư �̺�Ʈ
		textField_1.addKeyListener(this); // Ű �̺�Ʈ
		list.addListSelectionListener(this); // ����Ʈ �̺�Ʈ
		textField_1.requestFocus(); // �ؽ�Ʈ ��Ŀ��

		
		// ������, �г� add
		panel_Screen.add(gamelabel);	// ���� ȭ��
		background_panel.add(panel_Screen);	// ��濡 ����ȭ�� �ֱ�
		panel_Screen.setVisible(false);
		
		panel_over.add(lblNewLabel);	//���� ���� ��
		panel_over.add(lblScore); // ���Ӱ�� ���� 
		panel_over.add(lblNick);// �г��� 
		panel_over.add(gameoverlabel);	// ���ӿ��� ȭ��
		background_panel.add(panel_over);	// ��濡 ���ӿ��� ȭ�� �ֱ�
		panel_over.setVisible(false);
		
		background_panel.add(time_label);	// Ÿ�̸�
		background_panel.add(btn_bgm);	// bgm ��ư
		background_panel.add(textField_1);	// �ؽ�Ʈ�ʵ�
		background_panel.add(dorm_label);	// ����� �̹���
		background_panel.add(Label_nickname);	// �г���
		background_panel.add(label_life1);	// ���1
		background_panel.add(label_life2);	// ���2
		background_panel.add(label_life3);	// ���3
		background_panel.add(level);	// ����
		background_panel.add(score);	// ����
		background_panel.add(list);		// �������� ����Ʈ
		background_panel.add(btn_gamestart);	// ���ӽ��� ��ư
		background_panel.add(btn_gameend);		// �׸��α� ��ư
		background_panel.add(btn_Lang);	// ���� ��ư
		background_panel.add(background_label);	// ���
		add(background_panel);
		
		setLocationRelativeTo(null);	// ������ ȭ�� �߾ӿ� ��ġ
		setResizable(false);	// ������ ũ�� ����
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// ���ӽ��� ��ư �̺�Ʈ
		if (e.getSource().equals(btn_gamestart)) {

			panel_Screen.setVisible(true);
			// ������ 0 = ������ ��� �ִ°�
			life = 0;
			score.setText("0��"); // ���ӽ��۽� ������ 0��
			scorenum = 0; // �������� ���� =0
			// ���࿡ ���Ӱ��ȭ���� ����� ������ ������ �ʰ�
			if (panel_over.isVisible()) {
				panel_over.setVisible(false);// ���ȭ�� �Ⱥ��̰�
			}

			// �ܾ ������� �ִ��� Ȯ��
			if (label[0] != null) {
				for (int i = 0; i < label.length; i++) {
					// �����尡 ���ư��� ������ ����
					if (!new Sonagi_Thead().isAlive() || !new Sonagi_Move().isAlive()) {
						new Sonagi_Thead().interrupt();// �ܾ� ������ ����
						new Sonagi_Move().interrupt();// �������� ������ ����
					}
					// �ܾ ������� �ִٸ� �Ⱥ��̰�
					if (label[i] != null) {
						label[i].setVisible(false);
					}
				}
			}

			// ���ӽ��۽� �ؽ�Ʈ�ʵ� ��Ŀ�� �ֱ�
			textField_1.requestFocus();
			// �ܾ �ѷ��ִ� ������ ����
			new Sonagi_Thead().start();
			
			System.out.println(timer + "����");
			timer = true;
			new Sonagi_Timer().start();

		}
		
		// �׸��α� ��ư �߰�
		if(e.getSource().equals(btn_gameend)) {
			// ���� ���ȭ�� ����
			panel_Screen.setVisible(false);
			panel_over.setVisible(true);
			lblScore.setText(score.getText());
			lblNick.setText(NickName);
			// ������ ����
			new Sonagi_Thead().interrupt();
			new Sonagi_Move().interrupt();
			
			System.out.println(timer + "����");
			timer = false;
			new Sonagi_Timer().interrupt();
		}
		
		// ��� ����(����, �ѱ���) ��ư
		if(e.getSource().equals(btn_Lang)) {
			if(btn_Lang.getText().equals("����")) {	// ���� ��ư
				btn_Lang.setText("�ѱ���");	// �ѱ��� ��ư ����
			}
			else{	// �ѱ��� ��ư
				btn_Lang.setText("����");	// ���� ��ư���� ����
			}
		}
		
		// bgm ��ư(on,off)
		if(e.getSource().equals(btn_bgm)) {
			if(btn_bgm.getIcon().equals(soundOn_img)) {	// �Ҹ�O �̹���
				btn_bgm.setIcon(soundOff_img);	// �Ҹ�X �̹����� �ٲٱ�
				bgm.Stop();	// �Ҹ� �Ͻ�����
			}
			else if(btn_bgm.getIcon().equals(soundOff_img)) {	// �Ҹ�X �̹���
				btn_bgm.setIcon(soundOn_img);	// �Ҹ�O �̹����� �ٲٱ�
				bgm.Play();	// �Ҹ� ���
			}
		}
	}

	// �ܾ �Է��Ͽ� ���ϴܾ� �ִ��� Ȯ���ϴ� Ű�̺�Ʈ
	@Override
	public void keyPressed(KeyEvent e) {
		// ����Ű �̺�Ʈ
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// �ؽ�Ʈ �ʵ忡 ���� �ִ��� ������ Ȯ��
			if (!textField_1.getText().equals("")) {
				// String ������ �ؽ�Ʈ �� �ֱ�
				String work_answer = textField_1.getText().toString();
				//�ؽ�Ʈ �Է°��� ������ �ܾ� �ִ��� �˻� ���� �ܾ� ������ �Ⱥ��̰� �ϰ� ���� 5�� �ֱ� ,�ؽ�Ʈ�� ����(�ܾ Ʋ������ )
				for (int i = 0; i <= label.length; i++) { // ���� �ܾ� �˻� for
					try {
						if (work_answer.equals(label[i].getText())) {// ���ϴܾ� �˻�
							if (label[i].isVisible()) { // ���ϴܾ ȭ�鿡 ������ �ִ��� �˻�
								scorenum = scorenum += 5; // ���� +5
								score.setText(scorenum + "��"); // ������ ���� ����
								label[i].setVisible(false);// �ܾ� ȭ�鿡�� �Ⱥ��̰�
								textField_1.setText("");// �ؽ�Ʈ �� ���ֱ�
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

	// �ܾ �ϳ��� �ѷ��ִ� ������
	class Sonagi_Thead extends Thread {

		@Override
		public void run() {
			panel_Screen.setVisible(true);// ����ȭ�� ����

			// �ܾ ������ ���� �ӵ��� ����ȭ�鿡 x�� �������λ���
			for (i = 0; i <= 10000; i++) {

				try {

					Random random = new Random();// ���� ��ü ����
					
					if(btn_Lang.getText().equals("�ѱ���")) // �ѱ��� ��ư Ŭ����, �ѱ��� �ܾ� ������
						label[i] = new JLabel(magicKor[random.nextInt(magicKor.length)]);// �ܾ� �������� �������
					else if(btn_Lang.getText().equals("����")) // ���� ��ư Ŭ����, ���� �ܾ� ������
						label[i] = new JLabel(magicEng[random.nextInt(magicEng.length)]);// �ܾ� �������� �������
					
					// �ܾ� ��, ���� ����
					label[i].setFont(new Font("�޸�����ü", Font.PLAIN, 18));
					label[i].setForeground(Color.white);
					label[i].setBounds(0, 0, 100, 30);// �ܾ� �ʱ� ��ġ ����,�� ����
					gamelabel.add(label[i]);// �ܾ� �߰�
					label[i].setLocation(random.nextInt(678), 2);// x�� �������� �����ֱ�
					
					// �ܾ �����̴� ������ ����
					new Sonagi_Move().start();

					Thread.sleep(spd);// ���ӷ����� ���� �ܾ�ӵ�		
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// �ܾ� ��������,���ӿ��� Ȯ���ϴ� ������
	class Sonagi_Move extends Thread {

		@Override
		public void run() {

			// �ܾ� ���� ���� ��ŭ for ���� �� �ܾ�� y�� ����
			for (int a = 0; a <= i; a++) {
				if (label[a].isVisible()) {
					int sp = label[a].getY();
					int xp = label[a].getX();

					label[a].setLocation(xp, sp + 10);

				}

				// �ܾ �������ִ� ���·� ���� �Ѿ����� Ȯ��
				if (label[a].isVisible() && label[a].getY() > 512) {
					label[a].setVisible(false);// �ܾ ���� ������ �ܾ� �����
					life++;// ������ 1 = ���� 1������
				}
			}

			// ������ Ȯ��
			switch (life) {
			case 0:// ���� ��� ����
				label_life1.setIcon(life_img);
				label_life2.setIcon(life_img);
				label_life3.setIcon(life_img);
				break;

			case 1: // ���� 1�� ������
				label_life1.setIcon(life_death_img);
				label_life2.setIcon(life_img);
				label_life3.setIcon(life_img);
				break;

			case 2:// ���� 2 ������
				label_life1.setIcon(life_death_img);
				label_life2.setIcon(life_death_img);
				label_life3.setIcon(life_img);
				break;
			case 3:// ���� 3�� ������ ���ӿ���
				label_life1.setIcon(life_death_img);
				label_life2.setIcon(life_death_img);
				label_life3.setIcon(life_death_img);
				// ���� ���ȭ�� ����
				panel_Screen.setVisible(false);
				panel_over.setVisible(true);
				lblScore.setText(score.getText());
				lblNick.setText(NickName);
				// ������ ����
				new Sonagi_Thead().interrupt();
				new Sonagi_Move().interrupt();
				
				// Ÿ�̸� ������ ����
				timer = false;
				new Sonagi_Timer().interrupt();

				break;
			default:
				break;
			}
		}
	}

	//Main ��� 
	public void setSonagi_main(Sonagi_main main) {
		this.main = main;
	}

	// ��������Ʈ �̺�Ʈ ó��
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		String str;
		if (arg0.getSource() == list) {

			switch (list.getSelectedIndex()) {
			case 0:
				spd = 3500;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str); // ���� �󺧿� �����ֱ�
				break;
			case 1:
				spd = 3000;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 2:
				spd = 2500;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 3:
				spd = 2000;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 4:
				spd = 1500;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 5:
				spd = 1000;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 6:
				spd = 500;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;			
			default:
				break;
			}
		}
	}
	
	// Ÿ�̸� ������
	class Sonagi_Timer extends Thread {
		
		public int sec = 0;
		
		public void run() {
			try {
				while(timer == true) {	// sec(��)�� �޾Ƽ� ���, 1�ʿ� sec�� �� 1�� ����
				sec++;
				int min, hour;
				
				// �ʸ� ��, ������ ���
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
