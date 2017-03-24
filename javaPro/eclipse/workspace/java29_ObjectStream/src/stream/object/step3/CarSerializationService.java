package stream.object.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CarSerializationService {
	public void outputCar(String path, ArrayList<Car> list) throws Exception{
		// create file
		File file = new File(path);
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		
		// create stream
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// object writing
		oos.writeObject(list);
		
		// stream closing
		oos.close();
	}
	
	public ArrayList<Car> inputCar(String path) throws Exception{
		// variables
		ArrayList<Car> list = new ArrayList<Car>();
		File file = new File(path);
		
		// create stream
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// object reading
		list = (ArrayList<Car>)ois.readObject();
		
		return list;
	}
}
