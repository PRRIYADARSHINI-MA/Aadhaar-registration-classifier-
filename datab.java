package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeSet;




public class datab {
	public static String parentPath = "/home/hadoop/aadhar/data/";

	public static void register(String uname, String pass, String email, String phone) {

		try {
			File file = new File(parentPath + "filepath.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);

			String usersfile = properties.getProperty("userDetails");

			BufferedWriter bw = new BufferedWriter(new FileWriter(parentPath + "users.csv", true));
			bw.write(uname + "," + pass + "," + email + "," + phone );
			bw.write("\n");
			bw.close();

		} catch (Exception e) {
			System.out.println(e);
			
		}

	}
	
	public static boolean login(String uname, String pass) {
		boolean f = false;
		try {
			// File file = new File(parentPath + "filepath.properties");
			// FileInputStream inputStream = new FileInputStream(file);
			// Properties properties = new Properties();
			// properties.load(inputStream);
			// String fileName = properties.getProperty("userDetails");
			BufferedReader br = new BufferedReader(new FileReader(parentPath + "users.csv"));
			String line = "";
			boolean userflag = false;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				try {

					String[] details = line.split(",");
					System.out.println(details[0] + "," + details[1]);
					if ((details[0].trim().equals(uname.trim())) && (details[1].trim().equals(pass.trim()))) {
						userflag = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					// TODO: handle exception
				}

			}
			if (userflag == true) {
				f = true;
			}

			else {
				System.out.println("InValid user");

			}

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return f;
	}

	public static StringBuilder rpreprocesses() {
		StringBuilder sb = new StringBuilder();
		try {
			File file = new File("filepath.properties");
			final Properties properties = new Properties();
			FileInputStream inputStream;
			try {
				inputStream = new FileInputStream(parentPath + file);

				properties.load(inputStream);
				String fileName = properties.getProperty("prepro");

				BufferedReader br = new BufferedReader(new FileReader(parentPath + fileName));
				sb.append("Email \t	 	Name\t   	 Phone_no \n \n");

				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
					System.out.println(line);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(e1);
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return sb;

	}

}
