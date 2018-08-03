




import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class Heuristic {

	public static Set<Integer> visited = new HashSet<Integer>();

	public static Set<Integer> unvisited = new HashSet<Integer>();

	public static List<Double> xs = new ArrayList<Double>();

	public static List<Double> ys = new ArrayList<Double>();


	public static double distance(int one, int two){

		double x1 = xs.get(one);

		double y1 = ys.get(one);

		double x2 = xs.get(two);

		double y2 = ys.get(two);

		double diffX = x1 - x2;

		diffX *= diffX;

		double diffY = y1 - y2;

		diffY *= diffY;

		return Math.sqrt(diffX + diffY);

	}

	public static double totalDistance = 0.0;

	public static int nearestNeighbor(int index){


		double minDist = Double.MAX_VALUE;

		int minIndex = -1;


		for(int x: unvisited){

			double dist = distance(index, x);

			if(dist < minDist || (dist == minDist && x < minIndex) ){

				minIndex = x;

				minDist = dist;

			}


		}


		unvisited.remove(minIndex);

		visited.add(minIndex);

		totalDistance += minDist;

		return minIndex;
	}





    public static void main (String[] args) {
		try {
			File file = new File("nn.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;

			int count = 0;
			while ((line = bufferedReader.readLine()) != null) {

				if(count== 0){
					
					count++;
					continue;
				}

				//System.out.println(count);

				unvisited.add(count -1);

				String[] parts = line.split(" ");
				
			//	System.out.println(parts[1]);

				Double x = Double.parseDouble(parts[1]);

			//	System.out.println(parts[2]);

				Double y = Double.parseDouble(parts[2]);

				xs.add(x);

				ys.add(y);

				count++;


			}

			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		int currIndex = 0;

		unvisited.remove(0);

		visited.add(0);

		while(unvisited.size() > 0){

			currIndex = nearestNeighbor(currIndex);

		}

		totalDistance += distance(0, currIndex);

		System.out.println(totalDistance);


	}



}