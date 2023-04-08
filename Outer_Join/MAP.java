import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MAP extends Mapper<Object, Text, Text, Text>{
	
	private Text outKey = new Text();
    private Text outValue = new Text();
    
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
    	String[] record = value.toString().split(",");
        String tableName = record[0];
        String primaryKey = record[1];
        String attributeValue = record[2];
        
        if (tableName.equals("T1")) {
            outKey.set(primaryKey);
            outValue.set("T1," + attributeValue);
            context.write(outKey, outValue);
        } else if (tableName.equals("T2")) {
            outKey.set(attributeValue);
            outValue.set("T2," + primaryKey);
            context.write(outKey, outValue);
        }
    }
	
}