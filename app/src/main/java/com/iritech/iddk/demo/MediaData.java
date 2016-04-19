package com.iritech.iddk.demo;

import android.content.Context;
import android.media.MediaPlayer;

public class MediaData 
{
	public MediaPlayer captureFinishedPlayer; 
	public MediaPlayer eyeDetectedPlayer;
	public MediaPlayer moveEyeClosePlayer;
	public MediaPlayer eyeQualifiedPlayer;
	public MediaPlayer noEyeQualifiedPlayer;
	public MediaPlayer noEyeDetectedPlayer;
	public MediaPlayer captureAbortedPlayer;
	public MediaPlayer moveEyeCloserPlayer;
	public MediaPlayer moveEyeFartherPlayer;
	public MediaPlayer deviceDetected;
	public MediaPlayer deviceDisconnected;
	
	public MediaData(Context context)
	{
		captureFinishedPlayer = MediaPlayer.create(context, R.raw.capture);
    	moveEyeClosePlayer = MediaPlayer.create(context, R.raw.move_eye_heather);
    	eyeDetectedPlayer = MediaPlayer.create(context, R.raw.keepmoving);
    	eyeQualifiedPlayer = MediaPlayer.create(context, R.raw.eye_qualified_heather);
    	noEyeQualifiedPlayer = MediaPlayer.create(context, R.raw.no_eye_qualified_heather);
    	noEyeDetectedPlayer = MediaPlayer.create(context, R.raw.no_eye_detected_heather);
    	captureAbortedPlayer = MediaPlayer.create(context, R.raw.capture_aborted_heather);
    	moveEyeCloserPlayer = MediaPlayer.create(context, R.raw.move_eye_closer_heather);
    	moveEyeFartherPlayer = MediaPlayer.create(context, R.raw.move_eye_farther_heather);
    	deviceDetected = MediaPlayer.create(context, R.raw.device_detected);
    	deviceDisconnected = MediaPlayer.create(context, R.raw.device_disconnected);
    	
	}
}
