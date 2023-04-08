import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class REDUCE extends Reducer<Text, Text, Text, Text>{
    private String Table_Name = new String();
    private ArrayList<String> t1 = new ArrayList<>();
	private ArrayList<String> t2 = new ArrayList<>();

    public void reduce(Text name, Iterable<Text> Key, Context context) throws IOException, InterruptedException{
        
    	Table_Name = name.toString();
    	
    	for(Text pk: Key){
    		if(Table_Name.equals("T1"))
        		t1.add(pk.toString());
        	else if(Table_Name.equals("T2"))
        		t2.add(pk.toString());
    	}       
    }
    
    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        ArrayList<String> diff1 = new ArrayList<>(t1);
        diff1.removeAll(t2);

        ArrayList<String> diff2 = new ArrayList<>(t2);
        diff2.removeAll(t1);

        context.write(new Text(), new Text(diff1.toString()));
    }
}