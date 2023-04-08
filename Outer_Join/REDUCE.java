import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class REDUCE extends Reducer<Text, Text, Text, Text>{
	private Text outKey = new Text();
    private Text outValue = new Text();

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
    	Map<String, String> t1Records = new HashMap<>();
        String t2Attribute = "";
        
        for (Text value : values) {
            String[] parts = value.toString().split(",");
            String tableName = parts[0];
            String attributeValue = parts[1];

            if (tableName.equals("T1")) {
                t1Records.put(attributeValue, key.toString()); // Value, PK
            } else if (tableName.equals("T2")) {
                t2Attribute = attributeValue;                  // Value
            }
        }
        if (!t1Records.isEmpty() && !t2Attribute.isEmpty()) {
            for (Map.Entry<String, String> t1Record : t1Records.entrySet()) {
                outKey.set(t1Record.getValue());
                outValue.set(t2Attribute + "," + t1Record.getKey());
                context.write(outKey, outValue);
            }
        }else if(!t1Records.isEmpty() && t2Attribute.isEmpty()){
        	for (Map.Entry<String, String> t1Record : t1Records.entrySet()) {
                outKey.set(t1Record.getValue());
                outValue.set("null," + t1Record.getKey());
                context.write(outKey, outValue);
            }
        }
    }
}
