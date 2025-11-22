package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Draw piegraph for each expense category by percentage
@ExcludeFromJacocoGeneratedReport
public class PieGraph extends JPanel {
    private final int graphXPosition = 60;
    private final int graphYPosition = 80;

    private Map<String, Double> costPerCategory;
    private ArrayList<Color> colors = new ArrayList<>(
            Arrays.asList(Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE));
    
    // EFFECTS: Construct a pie graph with data and dimension
    public PieGraph(Map<String, Double> data) {
        this.costPerCategory = data;
        setPreferredSize(new Dimension(500, 500));
    }

    // EFFECTS: Draw pie graph with legend
    @Override
    protected void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        Graphics2D g2d = (Graphics2D) graph;

        int diameter = Math.min(getWidth() - 2 * graphXPosition, getHeight() - 2 * graphYPosition);

        double valueTotal = 0.0;
        Collection<Double> values = costPerCategory.values();
        for (Double next : values) {
            valueTotal += next;
        }

        double currentAngle = 0;
        int colorIndex = 0;

        for (Map.Entry<String, Double> next : costPerCategory.entrySet()) {
            double currentValue = next.getValue();
            double angleProportion = (currentValue / valueTotal) * 360;

            g2d.setColor(colors.get(colorIndex % colors.size()));
            g2d.fillArc(graphXPosition, graphYPosition, diameter, diameter, 
                    (int) Math.round(currentAngle), (int) Math.round(angleProportion));

            currentAngle += angleProportion;
            colorIndex++;
        }

        int legendXPosition = graphXPosition + diameter + 35;
        int legendYPosition = graphYPosition;

        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.setColor(Color.BLACK);
        g2d.drawString("Cost Breakdown By Category (%)", graphXPosition, graphYPosition - 35);

        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        colorIndex = 0;
        
        for (Map.Entry<String, Double> currentCategory : costPerCategory.entrySet()) {
            g2d.setColor(colors.get(colorIndex % colors.size()));
            g2d.fillRect(legendXPosition, legendYPosition + 15, 15, 15);
            colorIndex++;

            g2d.setColor(Color.BLACK);
            g2d.drawRect(legendXPosition, legendYPosition + 15, 15, 15);
            g2d.drawString(currentCategory.getKey(), legendXPosition + 25, legendYPosition + 30);
            
            String text = currentCategory.getKey() + " - " 
                    + String.format("%d%%", Math.round((currentCategory.getValue() / valueTotal) * 100));
            g2d.drawString(text, legendXPosition + 25, legendYPosition + 30);

            legendYPosition += 25;
        }
    }
}