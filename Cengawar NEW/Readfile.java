import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Readfile {

	private String path;
	
	public Readfile(String path)
	{
		this.path=path;
	}
	
	
	
	public String[] OpenFile() throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		//make this dynamic!
		int row_count=19;
		int col_count=49;
		
		String[] textData = new String[row_count];
		String[][] textData2 = new String[row_count][col_count];
		for (int i=0; i < row_count; i++)
		{
				textData[i] = textReader.readLine();
				for(int j=0;j<col_count;j++)
				{
					textData2[i][j]=textData[i].substring(j, j+1);
				}
		}
		
		textReader.close( );
		return textData;

	}
	
}
