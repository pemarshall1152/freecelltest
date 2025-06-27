package freecell_game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class FreeCellGame extends JFrame implements ActionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Deck cardDeck;
	private ArrayList<Freecell> freeCells;
	private ArrayList<TableColumn> table;
	private ArrayList<Foundation> foundations;
	private static JPanel foundationArea;
	private static JPanel freeCellArea;
	private static JTextArea tableArea;
	private static JPanel tableAreaPanel;
	private static JTextArea tableArea2;
	private static JTextArea tableArea3;
	private static JTextArea tableArea4;
	private static JTextArea tableArea5;
	private static JTextArea tableArea6;
	private static JTextArea tableArea7;
	private static JTextArea tableArea8;
	private static JTextArea freeCell1;
	private static JTextArea freeCell2;
	private static JTextArea freeCell3;
	private static JTextArea freeCell4;
	private static JTextArea foundation1;
	private static JTextArea foundation2;
	private static JTextArea foundation3;
	private static JTextArea foundation4;
	
	
	private static JButton newGame;
	
	private static boolean prevActionColumn;
	private static int prevTableIndex = 0;
	private static boolean prevActionFree;
	private static int prevFreeIndex =0;
	
	private static JFrame frame = new JFrame("freecell example program");
	

	public static void main(String[] args){
		
		
		createWindow();
		
	}
	
	private static void createWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createUI(frame);
		
		frame.setSize(1000,1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private static void createUI(JFrame frame) {
		JPanel panel = new JPanel();
		FreeCellGame currentGame = new FreeCellGame();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		newGame = new JButton("New Game");
		
		newGame.addActionListener(currentGame);
		
		
		tableArea = new JTextArea(10,10);
		tableArea.setEditable(false);
		tableArea.addMouseListener(currentGame);
		tableArea2 = new JTextArea(10,10);
		tableArea2.setEditable(false);
		tableArea2.addMouseListener(currentGame);
		tableArea3 = new JTextArea(10,10);
		tableArea3.setEditable(false);
		tableArea3.addMouseListener(currentGame);
		tableArea4 = new JTextArea(10,10);
		tableArea4.setEditable(false);
		tableArea4.addMouseListener(currentGame);
		tableArea5 = new JTextArea(10,10);
		tableArea5.setEditable(false);
		tableArea5.addMouseListener(currentGame);
		tableArea6 = new JTextArea(10,10);
		tableArea6.setEditable(false);
		tableArea6.addMouseListener(currentGame);
		tableArea7 = new JTextArea(10,10);
		tableArea7.setEditable(false);
		tableArea7.addMouseListener(currentGame);
		tableArea8 = new JTextArea(10,10);
		tableArea8.setEditable(false);
		tableArea8.addMouseListener(currentGame);
		
		tableAreaPanel = new JPanel();
		tableAreaPanel.add(tableArea);
		tableAreaPanel.add(tableArea2);
		tableAreaPanel.add(tableArea3);
		tableAreaPanel.add(tableArea4);
		tableAreaPanel.add(tableArea5);
		tableAreaPanel.add(tableArea6);
		tableAreaPanel.add(tableArea7);
		tableAreaPanel.add(tableArea8);
		
		

		freeCellArea = new JPanel();
		freeCell1 = new JTextArea(5,5);
		freeCell1.setEditable(false);
		freeCell1.addMouseListener(currentGame);
		freeCell2 = new JTextArea(5,5);
		freeCell2.setEditable(false);
		freeCell2.addMouseListener(currentGame);
		freeCell3 = new JTextArea(5,5);
		freeCell3.setEditable(false);
		freeCell3.addMouseListener(currentGame);
		freeCell4 = new JTextArea(5,5);
		freeCell4.setEditable(false);
		freeCell4.addMouseListener(currentGame);
		
		
		freeCellArea.add(freeCell1);
		freeCellArea.add(freeCell2);
		freeCellArea.add(freeCell3);
		freeCellArea.add(freeCell4);
		
		
		foundationArea = new JPanel();
		
		foundation1 = new JTextArea(5,5);
		foundation1.setEditable(false);
		foundation1.addMouseListener(currentGame);
		foundation2 = new JTextArea(5,5);
		foundation2.setEditable(false);
		foundation2.addMouseListener(currentGame);
		foundation3 = new JTextArea(5,5);
		foundation3.setEditable(false);
		foundation3.addMouseListener(currentGame);
		foundation4 = new JTextArea(5,5);
		foundation4.setEditable(false);
		foundation4.addMouseListener(currentGame);
		
		
		foundationArea.add(foundation1);
		foundationArea.add(foundation2);
		foundationArea.add(foundation3);
		foundationArea.add(foundation4);
		
		foundationArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"foundation"));
		freeCellArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"freeCellArea"));
		tableAreaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"tableArea"));
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(foundationArea,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(newGame,gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(freeCellArea,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		panel.add(tableAreaPanel,gbc);
		
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == newGame) {
			JOptionPane.showMessageDialog(frame, "new game");
			newGame();
		}
		
		
	}

	private void redrawTable() {
		// TODO Auto-generated method stub
		tableArea.setText(table.get(0).printCards());
		tableArea2.setText(table.get(1).printCards());
		tableArea3.setText(table.get(2).printCards());
		tableArea4.setText(table.get(3).printCards());
		tableArea5.setText(table.get(4).printCards());
		tableArea6.setText(table.get(5).printCards());
		tableArea7.setText(table.get(6).printCards());
		tableArea8.setText(table.get(7).printCards());
		
		freeCell1.setText(freeCells.get(0).printCard());
		freeCell2.setText(freeCells.get(1).printCard());
		freeCell3.setText(freeCells.get(2).printCard());
		freeCell4.setText(freeCells.get(3).printCard());
		
		foundation1.setText(foundations.get(0).printCard());
		foundation2.setText(foundations.get(1).printCard());
		foundation3.setText(foundations.get(2).printCard());
		foundation4.setText(foundations.get(3).printCard());
	}

	private void newGame() {
		// TODO Auto-generated method stub
		table = new ArrayList<TableColumn>();
		cardDeck = new Deck();
		cardDeck.shuffle();
		
		ArrayList<myCard> newCards = cardDeck.drawAll();
		
		
		ArrayList<myCard> temp = new ArrayList<>();
		
		for(int  i = 0; i <7;i++) {
			temp.add(newCards.get(i));
		}
		TableColumn tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea.setText(tmpTable.printCards());
		
		temp = new ArrayList<>();
		for(int  i = 7; i <14;i++) {
			temp.add(newCards.get(i));
		}
		tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea2.setText(tmpTable.printCards());
		
		temp = new ArrayList<>();
		for(int  i = 14; i <21;i++) {
			temp.add(newCards.get(i));
		}
		tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea3.setText(tmpTable.printCards());
		
		temp = new ArrayList<>();
		for(int  i = 21; i <28;i++) {
			temp.add(newCards.get(i));
		}
		tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea4.setText(tmpTable.printCards());
		
		temp = new ArrayList<>();
		for(int  i = 28; i <34;i++) {
			temp.add(newCards.get(i));
		}
		tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea5.setText(tmpTable.printCards());
		
		temp = new ArrayList<>();
		for(int  i = 34; i <40;i++) {
			temp.add(newCards.get(i));
		}
		tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea6.setText(tmpTable.printCards());
		
		temp = new ArrayList<>();
		for(int  i = 40; i <46;i++) {
			temp.add(newCards.get(i));
		}
		tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea7.setText(tmpTable.printCards());
		
		temp = new ArrayList<>();
		for(int  i = 46; i <52;i++) {
			temp.add(newCards.get(i));
		}
		tmpTable = new TableColumn(temp);
		table.add(tmpTable);
		tableArea8.setText(tmpTable.printCards());
		
		
		freeCells = new ArrayList<Freecell>();
		for(int i = 0; i < 4; i ++) {
			freeCells.add(new Freecell());
		}
		freeCell1.setText(freeCells.get(0).printCard());
		freeCell2.setText(freeCells.get(1).printCard());
		freeCell3.setText(freeCells.get(2).printCard());
		freeCell4.setText(freeCells.get(3).printCard());
		
		
		foundations = new ArrayList<Foundation>();
		for(int i = 0; i < 4; i ++) {
			foundations.add(new Foundation());
		}
		foundation1.setText(foundations.get(0).printCard());
		foundation2.setText(foundations.get(1).printCard());
		foundation3.setText(foundations.get(2).printCard());
		foundation4.setText(foundations.get(3).printCard());
		
		prevActionColumn =false;
		prevActionFree =false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e);
		if(e.getSource() == tableArea) {
			System.out.println("test 1");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(0).canAccept(temp)) {
					table.get(0).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(0).canAccept(temp)) {
						table.get(0).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex = 0;
				}
			}
			prevActionFree= false;
		}
		if(e.getSource() == tableArea2) {
			System.out.println("test 2");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(1).canAccept(temp)) {
					table.get(1).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(1).canAccept(temp)) {
						table.get(1).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex = 1;
				}
			}
			prevActionFree= false;
		}
		if(e.getSource() == tableArea3) {
			System.out.println("test 3");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(2).canAccept(temp)) {
					table.get(2).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(2).canAccept(temp)) {
						table.get(2).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex = 2;
				}
			}
			prevActionFree= false;
		}
		if(e.getSource() == tableArea4) {
			System.out.println("test 4");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(3).canAccept(temp)) {
					table.get(3).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(3).canAccept(temp)) {
						table.get(3).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex = 3;
				}
			}
			prevActionFree= false;
		}
		if(e.getSource() == tableArea5) {
			System.out.println("test 5");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(4).canAccept(temp)) {
					table.get(4).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(4).canAccept(temp)) {
						table.get(4).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex = 4;
				}
			}
			prevActionFree= false;
		}
		if(e.getSource() == tableArea6) {
			System.out.println("test 6");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(5).canAccept(temp)) {
					table.get(5).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(5).canAccept(temp)) {
						table.get(5).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex =5;
				}
			}
			prevActionFree= false;
		}
		if(e.getSource() == tableArea7) {
			System.out.println("test 7");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(6).canAccept(temp)) {
					table.get(6).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(6).canAccept(temp)) {
						table.get(6).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex = 6;
				}
			}
			prevActionFree= false;
		}
		if(e.getSource() == tableArea8) {
			System.out.println("test 8");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(table.get(7).canAccept(temp)) {
					table.get(7).add(temp);
					redrawTable();
					prevActionColumn = false;
					prevActionFree = false;
				}else {
					table.get(prevTableIndex).add(temp);
					JOptionPane.showMessageDialog(frame, "bad move");
					prevActionFree= false;
					prevActionColumn = false;
				}
			}else {
				if(prevActionFree) {
					myCard temp = freeCells.get(prevFreeIndex).popCurrent();
					if(table.get(7).canAccept(temp)) {
						table.get(7).add(temp);
						redrawTable();
						prevActionColumn = false;
						prevActionFree = false;
					}else {
						freeCells.get(prevFreeIndex).addCard(temp);
						JOptionPane.showMessageDialog(frame, "bad move");
						prevActionFree= false;
						prevActionColumn = false;
					}
				}else {
					prevActionColumn = true;
					prevTableIndex = 7;
				}
			}
			prevActionFree= false;
		}
		
		
		if(e.getSource() == freeCell1) {
			System.out.println("test 9");
			if(prevActionColumn) {
				if(freeCells.get(0).canAccept()) {
					myCard temp = table.get(prevTableIndex).popBottom();
					freeCells.get(0).addCard(temp);
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
				redrawTable();
				prevActionFree= false;
				prevActionColumn = false;
			}else{
				if(freeCells.get(0).getCurrent()==null) {
					prevActionFree= false;
					prevActionColumn = false;
				}else {
					prevActionColumn = false;
					prevActionFree= true;
					prevFreeIndex = 0;
				}
			}
		}
		if(e.getSource() == freeCell2) {
			System.out.println("test 10");
			if(prevActionColumn) {
				if(freeCells.get(1).canAccept()) {
					myCard temp = table.get(prevTableIndex).popBottom();
					freeCells.get(1).addCard(temp);
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
				redrawTable();
				prevActionFree= false;
				prevActionColumn = false;
			}else{
				if(freeCells.get(1).getCurrent()==null) {
					prevActionFree= false;
					prevActionColumn = false;
				}else {
					prevActionColumn = false;
					prevActionFree= true;
					prevFreeIndex = 1;
				}
			}
		}
		if(e.getSource() == freeCell3) {
			System.out.println("test 11");
			if(prevActionColumn) {
				if(freeCells.get(2).canAccept()) {
					myCard temp = table.get(prevTableIndex).popBottom();
					freeCells.get(2).addCard(temp);
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
				redrawTable();
				prevActionFree= false;
				prevActionColumn = false;
			}else{
				if(freeCells.get(2).getCurrent()==null) {
					prevActionFree= false;
					prevActionColumn = false;
				}else {
					prevActionColumn = false;
					prevActionFree= true;
					prevFreeIndex = 2;
				}
			}
		}
		if(e.getSource() == freeCell4) {
			System.out.println("test 12");
			if(prevActionColumn) {
				if(freeCells.get(3).canAccept()) {
					myCard temp = table.get(prevTableIndex).popBottom();
					freeCells.get(3).addCard(temp);
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
				redrawTable();
				prevActionFree= false;
				prevActionColumn = false;
			}else{
				if(freeCells.get(3).getCurrent()==null) {
					prevActionFree= false;
					prevActionColumn = false;
				}else {
					prevActionColumn = false;
					prevActionFree= true;
					prevFreeIndex = 3;
				}
			}
		}
		if(e.getSource() == foundation1) {
			System.out.println("test 13");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(foundations.get(0).canAccept(temp)) {
					foundations.get(0).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}else if(prevActionFree) {
				myCard temp = freeCells.get(prevFreeIndex).popCurrent();
				if(foundations.get(0).canAccept(temp)) {
					foundations.get(0).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}
			prevActionFree= false;
			prevActionColumn = false;
		}
		if(e.getSource() == foundation2) {
			System.out.println("test 14");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(foundations.get(1).canAccept(temp)) {
					foundations.get(1).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}else if(prevActionFree) {
				myCard temp = freeCells.get(prevFreeIndex).popCurrent();
				if(foundations.get(1).canAccept(temp)) {
					foundations.get(1).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}
			prevActionFree= false;
			prevActionColumn = false;
		}
		if(e.getSource() == foundation3) {
			System.out.println("test 15");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(foundations.get(2).canAccept(temp)) {
					foundations.get(2).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}else if(prevActionFree) {
				myCard temp = freeCells.get(prevFreeIndex).popCurrent();
				if(foundations.get(2).canAccept(temp)) {
					foundations.get(2).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}
			prevActionFree= false;
			prevActionColumn = false;
		}
		if(e.getSource() == foundation4) {
			System.out.println("test 15");
			if(prevActionColumn) {
				myCard temp = table.get(prevTableIndex).popBottom();
				if(foundations.get(3).canAccept(temp)) {
					foundations.get(3).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}else if(prevActionFree) {
				myCard temp = freeCells.get(prevFreeIndex).popCurrent();
				if(foundations.get(3).canAccept(temp)) {
					foundations.get(3).add(temp);
					redrawTable();
				}else {
					JOptionPane.showMessageDialog(frame, "bad move");
				}
			}
			prevActionFree= false;
			prevActionColumn = false;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
