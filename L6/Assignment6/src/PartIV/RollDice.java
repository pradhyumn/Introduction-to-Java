package PartIV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class RollDice extends JFrame {
    private static final long serialVersionUID = 1L;
	private ImagePanel leftDiePanel;
    private ImagePanel rightDiePanel;
    private JPanel gridPanel;
    private JLabel[][] gridLabels;
    private JButton rollButton;
    private int currentRow = 0;
    private int currentCol = 0;
    private boolean finished = false;
    private JLabel rollResultLabel;
    private JLabel resultLabel;

    public RollDice() {
        setTitle("Roll the Dice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        rollResultLabel = new JLabel("Result: ");
        resultLabel = new JLabel("Result: ");

        // Create the left and right die panels
        rightDiePanel = new ImagePanel("die1.png");
        leftDiePanel = new ImagePanel("die1.png");

        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.X_AXIS));
        dicePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        dicePanel.add(leftDiePanel);
        dicePanel.add(Box.createRigidArea(new Dimension(20, 0)));
        dicePanel.add(rightDiePanel);

        // Create the grid panel
        gridPanel = new JPanel(new GridLayout(5, 5));
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        gridLabels = new JLabel[5][5];

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                JLabel label = new JLabel("");
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridLabels[row][col] = label;
                gridPanel.add(label);
            }
        }
        gridLabels[currentRow][currentCol].setText("@");

        // Create the roll button
        rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(new RollButtonListener());

        // Add components to the frame
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(Box.createRigidArea(new Dimension(0, 10)));
        getContentPane().add(dicePanel);
        getContentPane().add(Box.createRigidArea(new Dimension(0, 20)));
        getContentPane().add(gridPanel);
        getContentPane().add(Box.createRigidArea(new Dimension(0, 10)));
        getContentPane().add(rollResultLabel);
        getContentPane().add(Box.createRigidArea(new Dimension(0, 10)));
        getContentPane().add(rollButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void moveDot(int steps) {
        for (int i = 0; i < steps; i++) {
            if (currentRow == 4 && currentCol == 4) {
                finished = true;
                for(Component item: gridPanel.getComponents()) {
                	gridPanel.remove(item);
                }
                gridPanel.add(new JLabel("Finished!"));
                // this.getContentPane().validate();
                // gridLabels[currentRow][currentCol].setText("Finished");
                return;
            }
            gridLabels[currentRow][currentCol].setText("");
            if (currentCol == 4) {
                currentCol = 0;
                currentRow++;
            } else {
                currentCol++;
            }
            gridLabels[currentRow][currentCol].setText("@");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class RollButtonListener implements ActionListener {
        private Random random = new Random();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (finished) {
                return;
            }
            int leftValue = random.nextInt(6) + 1;
            int rightValue = random.nextInt(6) + 1;
            leftDiePanel.setImage("die" + leftValue + ".png");
            rightDiePanel.setImage("die" + rightValue + ".png");
            int sum = leftValue + rightValue;
            rollResultLabel.setText("Result: " + sum);
            resultLabel.setText("Result: " + sum);
            moveDot(sum);
        }
    }
    
    public static void main(String[] args) {
        new RollDice();
    }
}
