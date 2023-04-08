import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MAP extends Mapper<Object, Text, Text, Text>{
	
	private Text Table_PK = new Text();
    private Text Table_Name = new Text();
    
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
    	String[] record = value.toString().split(",");
        String tableName = record[0];
        String primaryKey = record[1];
        String attributeValue = record[2];
        
        if (tableName.equals("T1")) {
        	Table_PK.set(primaryKey);        //PK
        	Table_Name.set("T1");
            context.write(Table_Name, Table_PK);
        } else if (tableName.equals("T2")) {
        	Table_PK.set(attributeValue);    // FK
        	Table_Name.set("T2");
            context.write(Table_Name, Table_PK);
        }
    }
	
}