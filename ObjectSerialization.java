package readwriteserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerialization implements Serializable
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ObjectSerialization(String name) 
	{
		
		this.name = name;
	}

	/*@Override
	public String toString()
	{
		return "ObjectSerialization [name=" + name + "]";
	}*/

	
	
	

}

class Test
{
	public static void main(String[] args)
	{
		ObjectSerialization Priya= new ObjectSerialization("Priya");
		
	
			try
			{
				writeToFile(Priya);
			} 
			catch (IOException e1) {
				
				e1.printStackTrace();
			}
	
		
		
		try
		{
			readFile();
		}
		catch (ClassNotFoundException | IOException e) 
		{
			
			e.printStackTrace();
		}
	
	}
		public static void writeToFile(ObjectSerialization os) throws IOException
		{
			FileOutputStream fio=new FileOutputStream("ObjectSerialization.bin");
			ObjectOutputStream objectOut= new ObjectOutputStream(fio);
			objectOut.close();
			fio.close();
			objectOut.writeObject(os);
		}
		public static void readFile() throws IOException, ClassNotFoundException
		
		{
			FileInputStream fiin = new FileInputStream("ObjectSerialization.bin");
			ObjectInputStream objectIn = new ObjectInputStream(fiin);
			objectIn.close();
			fiin.close();
			
			ObjectSerialization name= (ObjectSerialization) objectIn.readObject();
			System.out.println("Name="+name.getName());
		}
}
		
	

