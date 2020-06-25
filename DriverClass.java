package aadhar;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DriverClass {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(DriverClass.class);
		// TODO: specify a mapper
		job.setMapperClass(MapClass.class);
		// TODO: specify a reducer
		job.setReducerClass(ReducerClass.class);

		// TODO: specify output types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// TODO: specify input and output DIRECTORIES (not files)
		//FileInputFormat.setInputPaths(job, new Path("/home/hadoop/Data/word.txt"));
		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/aadhar"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/Out"));

		if (!job.waitForCompletion(true))
			return;
	}

}
