package week1.gasStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GasStation {
	public static List<Integer> getGasStations(int tripDistance, 
											   int tankSize, 
											   List<Integer> gasStations) {

		List<Integer> result = new ArrayList<Integer>();
		List<Integer> stations = new ArrayList<Integer>(gasStations);
		stations.add(tripDistance);
		int availableGas = tankSize - stations.get(0);

		for(int i = 1; i < stations.size(); i++) {
			int relativeDist = stations.get(i) - stations.get(i - 1);
			availableGas -= relativeDist;

			if (availableGas <= 0) {
				result.add(stations.get(i - 1));
				availableGas = tankSize - relativeDist;
			}

		}

		return result;
	}
	
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		int tripDistance = Integer.parseInt(input.nextLine());
		int tankSize = Integer.parseInt(input.nextLine());
		int gasStationsCounts = Integer.parseInt(input.nextLine());

		List<Integer> gasStations = new ArrayList<Integer>();

		for(int i = 0; i < gasStationsCounts; i++) {
			int station = Integer.parseInt(input.nextLine());
			gasStations.add(station);
		}

		List<Integer> result = getGasStations(tripDistance, tankSize, gasStations);

		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}

	}

}
