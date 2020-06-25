package aadhar;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapClass extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable ikey, Text ivalue, Context context) throws IOException, InterruptedException {
		Text t = new Text();
		IntWritable in = new IntWritable(1);
		String line = ivalue.toString();
		String line1[] = line.split(",");
		if(line1.length>=7) {
			t.set(line1[2]+" : "+line1[6]);
			context.write(t, in);
		}		
		
	}

}
