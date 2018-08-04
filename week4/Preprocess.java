






import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;

import java.util.*;

public class Preprocess {


	public static int size = -1;

	public static int adjust (int input){



		if(input < 0){

			input *= -1;

			input += size;

		}

		return input;

	}


    public static void main (String[] args) {

		try {
			File file = new File(args[0]);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;



			FileWriter fw = new FileWriter(args[0].substring(0, 5) + "-processed.txt");

			//for (int i = 0; i < 10; i++) {
			//		fw.write("something");
			//}
			//fw.close();
			//}

			int count = 0;


			while ((line = bufferedReader.readLine()) != null) {
				//stringBuffer.append(line);
				//stringBuffer.append("\n");
				//int num = Integer.parseInt(line);
				//q.list.add(num);


				if(count++ == 0){
					size = Integer.parseInt(line);

					fw.write(size + "\n");

					//if( size != 200000){
					//	System.out.println("error");
					//	System.exit(1);
					//}
					continue;
				}


				String[] parts = line.split("\\s");

                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);

                int notU = -1 * u;


                fw.write(adjust(notU) + " " + adjust(v) + "\n");


                int notV = -1 * v;

                fw.write(adjust(notV) + " " + adjust(u) + "\n");
           

			}

			fw.close();


			fileReader.close();
			//System.out.println("Contents of file:");
			//System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}


		// for(int i: edges.keySet()){
		// 	System.out.println("start " + i);

		// 	for(int j: edges.get(i)){
		// 		System.out.println("end " + j);
		// 	}
		// }


		//createReversed();

		//firstDFS();


		//secondDFS();



	}

}