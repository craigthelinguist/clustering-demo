package tools;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class ColourWizard {

	private ColourWizard(){}

	public static Color[] getRandomColours(int amount){
		if (amount > colours.length) throw new RuntimeException("too many colours");
		Set<Integer> indices = new HashSet<Integer>();
		while (indices.size() < amount){
			int randIndex = (int)(Math.random()*(colours.length - 1));
			indices.add(randIndex);
		}
		Color[] cols = new Color[amount];
		int i = 0;
		for (Integer intt : indices){
			Color col = colours[intt];
			cols[i++] = col;
		}
		return cols;
	}
	
	public static Color randomColour(){
		return colours[(int)(Math.random()*(colours.length-1))];
	}
	
	private static final Color[] colours = new Color[]{
		new Color(206, 162, 232),
		new Color(232, 162, 227),
		new Color(165, 232, 162),
		new Color(210, 232, 162),
		new Color(255, 240, 145),
		new Color(255, 169, 77),
		new Color(255, 120, 120),
		new Color(255, 79, 173),
		new Color(158, 243, 247),
		new Color(130, 209, 146),
		new Color(230, 87, 87),
		new Color(219, 75, 157),
		new Color(99, 219, 75),
		new Color(191, 113, 101),
		new Color(45, 196, 91),
		new Color(70, 62, 230)
	};
	
}
