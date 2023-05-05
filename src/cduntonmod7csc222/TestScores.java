package cduntonmod7csc222;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import cduntonm7q1.FileLoc;

public class TestScores {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> scores = readFile();
		Collections.sort(scores);
		badValues(scores);
		displayScores(scores);
		scoresAvg(scores);
		valsDistribution(scores);
	}

	public static ArrayList<Integer> readFile() {
		Scanner scan = new Scanner(System.in);
		String data = FileLoc.pickLocRead();
		ArrayList<Integer> scores = new ArrayList<>();

		// Open file
		File nums = new File(data);
		Scanner inputFile = null;

		try {
			inputFile = new Scanner(nums);

			// Read lines from file
			while (inputFile.hasNextLine()) {
				int num = inputFile.nextInt();
				scores.add(num);
			}
		} catch (IOException | InputMismatchException ex) {
			System.out.println(ex.getClass().getSimpleName() + ". Need to exit.");
			if (ex.getMessage() != null) {
				System.out.println(ex.getMessage());
			}
			System.exit(0);
		}

		finally {
			inputFile.close();
		}

		return scores;
	}

	public static void badValues(ArrayList<Integer> scores) {
		System.out.println("The Bad Values: ");
		int badVal = 0;
		for (int i = 0; i < scores.size(); i++) {
			if (scores.get(i) < 0 || scores.get(i) > 100) {
				badVal++;
				System.out.println(scores.get(i));
				scores.remove(i);
			}
		}
		if (badVal == 0) {
			System.out.println("NONE!");
		}
		System.out.println();

	}

	public static void displayScores(ArrayList<Integer> scores) {
		System.out.println("Data ten per line sorted");
		int num = 0;
		for (int i = 0; i < scores.size(); i++) {
			System.out.print(scores.get(i).toString() + " ");
			num++;
			if (num == 10) {
				System.out.println();
				num = 0;
			}
		}
		System.out.println();
	}

	public static void valsDistribution(ArrayList<Integer> scores) {
		final int NUM_SCORE_BRACKETS = 11;
		ArrayList<ArrayList<Integer>> scoresByTens = new ArrayList<>(10);
		for (int i = 0; i < NUM_SCORE_BRACKETS; i++) {
			ArrayList<Integer> currentScores = new ArrayList<>();
			scoresByTens.add(currentScores);
		}

		for (int i = 0; i < scoresByTens.size(); i++) {
			int minScore = i * 10;
			int maxScore = minScore + 9;
			List<Integer> currentScores = scoresByTens.get(i);
			for (int j = 0; j < scores.size(); j++) {
				Integer score = scores.get(j);

				if (score < minScore || score > maxScore) {
					continue;
				}
				currentScores.add(score);
			}
		}

		System.out.println("The following is a distribution of values: ");
		for (int i = 0; i < scoresByTens.size(); i++) {
			List<Integer> currentScores = scoresByTens.get(i);
			int minScore = i * 10;
			int maxScore = minScore + 9;
			String scoreBracket = minScore + "-" + maxScore;
			if (i == 0) {
				scoreBracket = "0" + minScore + "-0" + maxScore;
			}
			if (i == scoresByTens.size() - 1) {
				scoreBracket = minScore + "";
			}
			System.out.println(scoreBracket + " - " + scoresByTens.get(i).size());
		}
	}

	public static void scoresAvg(ArrayList<Integer> scores) {
		DecimalFormat df = new DecimalFormat("##.##");
		double sum = 0;
		for (int s : scores)
			sum += s;
		double average = sum / scores.size();
		System.out.println("\nThe average value is: " + df.format(average));
	}
}
