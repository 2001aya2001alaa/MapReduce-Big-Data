import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver{
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "inner join");

	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    job.setJarByClass(Driver.class);
	    job.setMapperClass(MAP.class);
	    job.setReducerClass(REDUCE.class);

	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(Text.class);

	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}