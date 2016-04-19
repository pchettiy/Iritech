package com.iritech.iddk.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import android.os.Environment;
import android.util.Log;

public class DemoConfig 
{	
	private static final String TAG = "IriManiaConfig";
	
	public static final int DEFAULT_ENROLL_TOTALSCORE_1 = 50;
	public static final int  DEFAULT_ENROLL_USABLEAREA_1 = 50;

	public static final int  DEFAULT_ENROLL_TOTALSCORE_2 = 70;
	public static final int  DEFAULT_ENROLL_USABLEAREA_2 = 70;

	public static final int  DEFAULT_MATCH_TOTALSCORE_1 = 30;
	public static final int  DEFAULT_MATCH_USABLEAREA_1 = 30;

	public static final int  DEFAULT_MATCH_TOTALSCORE_2 = 50;
	public static final int  DEFAULT_MATCH_USABLEAREA_2 = 50;

	public static final float  DEFAULT_MATCH_DISTANCE_1 = 1.00f;
	public static final float  DEFAULT_MATCH_DISTANCE_2 = 1.05f;
	
	public static final float DEFAULT_DEDUP_DISTANCE = 1.1f;

	public static final boolean  DEFAULT_QMSCORE_SHOW = true;
	public static final boolean DEFAULT_CAPTURE_SAVESTREAM = false;
	public static final boolean  DEFAULT_CAPTURE_SAVEBEST = true;
	public static final String  DEFAULT_CAPTURE_FOLDER = "/iritech/";
	public static final String  DEFAULT_NAME_PREFIX = "Unknown_";
	
	public static final String KEY_QMSCORE_SHOW = "qmscore_show";
	public static final String KEY_CAPTURE_SAVESTREAM = "capture_savestream";

	public static final String KEY_ENROLL_TOTALSCORE_1 = "enroll_totalscore_1";
	public static final String KEY_ENROLL_USABLEAREA_1 = "enroll_usablearea_1";
	public static final String KEY_ENROLL_TOTALSCORE_2 = "enroll_totalscore_2";
	public static final String KEY_ENROLL_USABLEAREA_2 = "enroll_usablearea_2";

	public static final String KEY_MATCH_TOTALSCORE_1 = "match_totalscore_1";
	public static final String KEY_MATCH_USABLEAREA_1 = "match_usablearea_1";
	public static final String KEY_MATCH_DISTANCE_1 = "match_distance_1";

	public static final String KEY_MATCH_TOTALSCORE_2 = "match_totalscore_2";
	public static final String KEY_MATCH_USABLEAREA_2 = "match_usablearea_2";
	public static final String KEY_MATCH_DISTANCE_2 = "match_distance_2";
	
	public static final String MAX_NUMBER_OF_TEMPLATES = "max_enrolled_templates";
	
	public static final String ORIENTATION = "orientation";
	public static final String MUTIPLE_CAMERAS = "mutiple_cameras";
	public static final String ROTATION_ANGLE = "rotation_angle";
	
	public static final int VERTICAL = 0;
	public static final int HORIZONTAL = 1;
	
	String szDefaultStreamFolder;
	String szNamePrefix;
	int[] th_enroll_totalscore;
	int[] th_enroll_usablearea;
	int[] th_matching_totalscore;
	int[] th_matching_usablearea;
	int max_enrolled_template;
	float[] th_matching_distance;
	float th_dedup_distance;
	boolean th_qmscore_show;
	boolean	th_capture_bSaveStream;
	boolean th_capture_bSaveBest;
	
	int rotation_angle = 90;
	boolean multipleCamera = true; 
	int orientation = 0;
	
	public DemoConfig()
	{
		szDefaultStreamFolder = Environment.getExternalStorageDirectory() + DEFAULT_CAPTURE_FOLDER;
		szNamePrefix = DEFAULT_NAME_PREFIX;
		th_enroll_totalscore = new int[2];
		th_enroll_totalscore[0] = DEFAULT_ENROLL_TOTALSCORE_1;
		th_enroll_totalscore[1] = DEFAULT_ENROLL_TOTALSCORE_2;
		
		th_enroll_usablearea = new int[2];
		th_enroll_usablearea[0] = DEFAULT_ENROLL_USABLEAREA_1;
		th_enroll_usablearea[1] = DEFAULT_ENROLL_USABLEAREA_2;

		th_matching_totalscore = new int[2];
		th_matching_totalscore[0] = DEFAULT_MATCH_TOTALSCORE_1;
		th_matching_totalscore[1] = DEFAULT_MATCH_TOTALSCORE_2;
		
		th_matching_usablearea = new int[2];
		th_matching_usablearea[0] = DEFAULT_MATCH_USABLEAREA_1;
		th_matching_usablearea[1] = DEFAULT_MATCH_USABLEAREA_2;

		th_matching_distance = new float[2];
		th_matching_distance[0] = DEFAULT_MATCH_DISTANCE_1;
		th_matching_distance[1] = DEFAULT_MATCH_DISTANCE_2;

		th_dedup_distance = DEFAULT_DEDUP_DISTANCE;
		
		th_qmscore_show = DEFAULT_QMSCORE_SHOW;
		th_capture_bSaveBest = DEFAULT_CAPTURE_SAVEBEST;
		th_capture_bSaveStream = DEFAULT_CAPTURE_SAVESTREAM;
		
		max_enrolled_template = 8;
		
		rotation_angle = 90;
		multipleCamera = true; //Only on Android >= 2.3
		orientation = VERTICAL;
	}
	
	public void loadFromFile(String pathName)
	{	
		File file = new File(pathName);
		if(file.exists())
		{
			Log.d(TAG, "File exists");
			try {
				FileInputStream fis = new FileInputStream(file);
				Properties configFile = new Properties();	
				configFile.load(fis);
				String prop = "";
				if((prop = configFile.getProperty(KEY_QMSCORE_SHOW)) != null)
				{
					th_qmscore_show = Boolean.parseBoolean(prop);
					Log.d(TAG, "qmscore_show = " + th_qmscore_show);
				}
				
				if((prop = configFile.getProperty(KEY_CAPTURE_SAVESTREAM)) != null)
				{
					th_capture_bSaveStream = Boolean.parseBoolean(prop);
					Log.d(TAG, "th_capture_bSaveStream = " + th_capture_bSaveStream);
				}
				
				if((prop = configFile.getProperty(KEY_ENROLL_TOTALSCORE_1)) != null)
				{
					try
					{
						th_enroll_totalscore[0] = Integer.parseInt(prop);
						Log.d(TAG, "th_enroll_totalscore[0] = " + th_enroll_totalscore[0]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_ENROLL_TOTALSCORE_2)) != null)
				{
					try
					{
						th_enroll_totalscore[1] = Integer.parseInt(prop);
						Log.d(TAG, "th_enroll_totalscore[1] = " + th_enroll_totalscore[1]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_ENROLL_USABLEAREA_1)) != null)
				{
					try
					{
						th_matching_usablearea[0] = Integer.parseInt(prop);
						Log.d(TAG, "th_matching_usablearea[0] = " + th_matching_usablearea[0]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_ENROLL_USABLEAREA_2)) != null)
				{
					try
					{
						th_matching_usablearea[1] = Integer.parseInt(prop);
						Log.d(TAG, "th_matching_usablearea[1] = " + th_matching_usablearea[1]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_MATCH_TOTALSCORE_1)) != null)
				{
					try
					{
						th_matching_totalscore[0] = Integer.parseInt(prop);
						Log.d(TAG, "th_matching_totalscore[0] = " + th_matching_totalscore[0]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_MATCH_TOTALSCORE_2)) != null)
				{
					try
					{
						th_matching_totalscore[1] = Integer.parseInt(prop);
						Log.d(TAG, "th_matching_totalscore[1] = " + th_matching_totalscore[1]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_MATCH_USABLEAREA_1)) != null)
				{
					try
					{
						th_matching_usablearea[0] = Integer.parseInt(prop);
						Log.d(TAG, "th_matching_usablearea[0] = " + th_matching_usablearea[0]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_MATCH_USABLEAREA_2)) != null)
				{
					try
					{
						th_matching_usablearea[1] = Integer.parseInt(prop);
						Log.d(TAG, "th_matching_usablearea[1] = " + th_matching_usablearea[1]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_MATCH_DISTANCE_1)) != null)
				{
					try
					{
						th_matching_distance[0] = Float.parseFloat(prop);
						Log.d(TAG, "th_matching_distance[0] = " + th_matching_distance[0]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(KEY_MATCH_DISTANCE_2)) != null)
				{
					try
					{
						th_matching_distance[1] = Float.parseFloat(prop);
						Log.d(TAG, "th_matching_distance[1] = " + th_matching_distance[1]);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(MAX_NUMBER_OF_TEMPLATES)) != null)
				{
					try
					{
						max_enrolled_template = Integer.parseInt(prop);
						Log.d(TAG, "max_enrolled_template = " + max_enrolled_template);
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(ROTATION_ANGLE)) != null)
				{
					try
					{
						rotation_angle = Integer.parseInt(prop);
						Log.d(TAG, "rotation_angle = " + rotation_angle);
						if(rotation_angle != 0 && rotation_angle != 90 && rotation_angle != 180 && rotation_angle != 270) rotation_angle = 90;
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
				if((prop = configFile.getProperty(MUTIPLE_CAMERAS)) != null)
				{
					multipleCamera = Boolean.parseBoolean(prop);
					Log.d(TAG, "multipleCamera = " + multipleCamera);
				}
				else
				{
					multipleCamera = true;
				}
				
				if((prop = configFile.getProperty(ORIENTATION)) != null)
				{
					try
					{
						orientation = Integer.parseInt(prop);
						Log.d(TAG, "orientation = " + orientation);
						if(orientation != 0 && orientation != 1) orientation = VERTICAL;
					}
					catch(NumberFormatException ex)
					{
						ex.printStackTrace();
					}
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
