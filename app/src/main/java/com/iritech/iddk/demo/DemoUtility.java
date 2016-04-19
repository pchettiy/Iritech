package com.iritech.iddk.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.iritech.iddk.android.IddkResult;

public class DemoUtility 
{
	public static String getErrorDesc(IddkResult error)
	{
		String s = "IDDK_OK";
		switch (error.getValue())
		{
		case IddkResult.IDDK_OK:
			break;
		case IddkResult.IDDK_FAILED:
			s = "IDDK_FAILED";
			break;
		case IddkResult.IDDK_DEVICE_NOT_FOUND:
			s =  "Device not found";
			break;
		case IddkResult.IDDK_DEVICE_OPEN_FAILED:
			s = "Failed to open device";
			break;
		case IddkResult.IDDK_DEVICE_NOT_OPEN:
			s = "IDDK_DEVICE_NOT_OPEN";
			break;
		case IddkResult.IDDK_DEVICE_ALREADY_OPEN:
			s = "IDDK_DEVICE_ALREADY_OPEN";
			break;
		case IddkResult.IDDK_DEVICE_ACCESS_DENIED:
			s = "IDDK_DEVICE_ACCESS_DENIED";
			break;
		case IddkResult.IDDK_TOO_MANY_OPEN_DEVICES:
			s = "IDDK_TOO_MANY_OPEN_DEVICES";
			break;		
		case IddkResult.IDDK_DEVICE_IO_FAILED:
			s = "IDDK_DEVICE_IO_FAILED";
			break;						
		case IddkResult.IDDK_DEVICE_IO_TIMEOUT:
			s = "IDDK_DEVICE_IO_TIMEOUT";
			break;	
		case IddkResult.IDDK_DEVICE_IO_DATA_INVALID:
			s = "IDDK_DEVICE_IO_DATA_INVALID";
			break;			
		case IddkResult.IDDK_UNSUPPORTED_IMAGE_FORMAT:
			s = "IDDK_UNSUPPORTED_IMAGE_FORMAT";
			break;		
		case IddkResult.IDDK_MEMORY_ALLOCATION_FAILED:
			s = "IDDK_MEMORY_ALLOCATION_FAILED";
			break;		
		case IddkResult.IDDK_INVALID_MEMORY:
			s = "IDDK_INVALID_MEMORY";
			break;			
		case IddkResult.IDDK_INVALID_HANDLE:
			s = "IDDK_INVALID_HANDLE";
			break;				
		case IddkResult.IDDK_INVALID_PARAMETER:
			s = "IDDK_INVALID_PARAMETER";
			break;		
		case IddkResult.IDDK_AUTHEN_FAILED:
			s = "IDDK_AUTHEN_FAILED";
			break;				
		case IddkResult.IDDK_NOT_ENOUGH_BUFFER:
			s = "IDDK_NOT_ENOUGH_BUFFER";
			break;			
		case IddkResult.IDDK_VERSION_INCOMPATIBLE:
			s = "IDDK_VERSION_INCOMPATIBLE";
			break;			
		case IddkResult.IDDK_THREAD_FAILED:
			s = "IDDK_THREAD_FAILED";
			break;			
		case IddkResult.IDDK_UNSUPPORTED_COMMAND:
			s = "IDDK_UNSUPPORTED_COMMAND";
			break;			
		case IddkResult.IDDK_IMAGE_CORRUPTED:
			s = "IDDK_IMAGE_CORRUPTED";
			break;				
		case IddkResult.IDDK_WRONG_EYE_SUBTYPE:
			s = "IDDK_WRONG_EYE_SUBTYPE";
			break;			
		case IddkResult.IDDK_UNKNOWN_DEVICE:
			s = "IDDK_UNKNOWN_DEVICE";
			break;				
		case IddkResult.IDDK_UNEXPECTED_ERROR:
			s = "IDDK_UNEXPECTED_ERROR";
			break;				
		case IddkResult.IDDK_DEV_OUTOFMEMORY:
			s = "Device is out of memory !";
			break;				
		case IddkResult.IDDK_DEV_NOT_ENOUGH_MEMORY:
			s = "IDDK_DEV_NOT_ENOUGH_MEMORY";
			break;			
		case IddkResult.IDDK_DEV_INSUFFICIENT_BUFFER:
			s = "IDDK_DEV_INSUFFICIENT_BUFFER";
			break;		
		case IddkResult.IDDK_DEV_INVALID_LICENSE:
			s = "IDDK_DEV_INVALID_LICENSE";
			break;		
		case IddkResult.IDDK_DEV_IO_FAILED:
			s = "IDDK_DEV_IO_FAILED";
			break;						
		case IddkResult.IDDK_DEV_MODULE_NOT_FOUND:
			s = "IDDK_DEV_MODULE_NOT_FOUND";
			break;			
		case IddkResult.IDDK_DEV_PROC_NOT_FOUND:
			s = "IDDK_DEV_PROC_NOT_FOUND";
			break;				
		case IddkResult.IDDK_DEV_BAD_DATA:
			s = "Bad template data !";
			break;					
		case IddkResult.IDDK_DEV_FUNCTION_DISABLED:
			s = "The requested function was disabled by device.";
			break;				
		case IddkResult.IDDK_DEV_LOCKED:
			s = "The device was locked.";
			break;		
		case IddkResult.IDDK_DEV_BUSY:
			s = "IDDK_DEV_BUSY";
			break;			
		case IddkResult.IDDK_DEV_RUNTIME_EXCEPTION:
			s = "IDDK_DEV_RUNTIME_EXCEPTION";
			break;			
		case IddkResult.IDDK_SEC_FAILED:
			s = "IDDK_SEC_FAILED";
			break;					
		case IddkResult.IDDK_SEC_INIT_FAILED:
			s = "IDDK_SEC_INIT_FAILED";
			break;				
		case IddkResult.IDDK_SEC_WRONG_PASSWORD:
			s = "IDDK_SEC_WRONG_PASSWORD";
			break;			
		case IddkResult.IDDK_SEC_BAD_LEN:
			s = "IDDK_SEC_BAD_LEN";
			break;					
		case IddkResult.IDDK_SEC_BAD_DATA:
			s = "IDDK_SEC_BAD_DATA";
			break;				
		case IddkResult.IDDK_SEC_BAD_ALG:
			s = "IDDK_SEC_BAD_ALG";
			break;					
		case IddkResult.IDDK_SEC_BAD_KEY:
			s = "IDDK_SEC_BAD_KEY";
			break;				
		case IddkResult.IDDK_SEC_BAD_SIG:
			s = "IDDK_SEC_BAD_SIG";
			break;					
		case IddkResult.IDDK_SEC_ENCRYPT_ERROR:
			s = "IDDK_SEC_ENCRYPT_ERROR";
			break;			
		case IddkResult.IDDK_SEC_DECRYPT_ERROR:
			s = "IDDK_SEC_DECRYPT_ERROR";
			break;			
		case IddkResult.IDDK_SEC_IMPORT_ERROR:
			s = "IDDK_SEC_IMPORT_ERROR";
			break;				
		case IddkResult.IDDK_SEC_EXPORT_ERROR:
			s = "IDDK_SEC_EXPORT_ERROR";
			break;				
		case IddkResult.IDDK_SEC_KEYGEN_ERROR:
			s = "IDDK_SEC_KEYGEN_ERROR";
			break;			
		case IddkResult.IDDK_SEC_HASH_ERROR:
			s = "IDDK_SEC_HASH_ERROR";
			break;				
		case IddkResult.IDDK_SEC_SIG_ERROR:
			s = "IDDK_SEC_SIG_ERROR";
			break;		
		case IddkResult.IDDK_SEC_PRIVILEGE_RESTRICTED:
			s = "Permission denied.\nThe current device requires you to login with proper privilege to do that function.";
			break;
		case IddkResult.IDDK_SE_NOT_INIT:
			s = "IDDK_SE_NOT_INIT";
			break;					
		case IddkResult.IDDK_SE_NO_CAM:
			s = "IDDK_SE_NO_CAM";
			break;				
		case IddkResult.IDDK_SE_STARTSTOP_CAPTURE_FAILED:
			s = "IDDK_SE_STARTSTOP_CAPTURE_FAILED";
			break;	
		case IddkResult.IDDK_SE_QM_FAILED:
			s = "IDDK_SE_QM_FAILED";
			break;					
		case IddkResult.IDDK_SE_NO_FRAME_AVAILABLE:
			s = "Please make a capture first !";
			break;		
		case IddkResult.IDDK_SE_NO_QUALIFIED_FRAME:
			s = "No frames qualified ! Please capture again !";
			break;		
		case IddkResult.IDDK_SE_RIGHT_FRAME_UNQUALIFIED:
			s = "IDDK_SE_RIGHT_FRAME_UNQUALIFIED";
			break;	
		case IddkResult.IDDK_SE_LEFT_FRAME_UNQUALIFIED:
			s = "IDDK_SE_LEFT_FRAME_UNQUALIFIED";
			break;	
		case IddkResult.IDDK_SE_COMPRESSION_FAILED:
			s = "IDDK_SE_COMPRESSION_FAILED";
			break;		
		case IddkResult.IDDK_GAL_NOT_INITIALIZED:
			s = "IDDK_GAL_NOT_INITIALIZED";
			break;			
		case IddkResult.IDDK_GAL_LOAD_FAILED:
			s = "IDDK_GAL_LOAD_FAILED";
			break;			
		case IddkResult.IDDK_GAL_EMPTY:
			s = "IDDK_GAL_EMPTY";
			break;					
		case IddkResult.IDDK_GAL_FULL:
			s = "IDDK_GAL_FULL";
			break;						
		case IddkResult.IDDK_GAL_ID_NOT_EXIST:
			s = "The enroll ID does not exist. Please select another one!";
			break;							
		case IddkResult.IDDK_GAL_ID_NOT_ENOUGH_SLOT:
			s = "Not enough template slot in gallery to enroll this ID !";
			break;					
		case IddkResult.IDDK_GAL_NOT_ENOUGH_SLOT:
			s = "Gallery is full !";
			break;					
		case IddkResult.IDDK_GAL_ID_SLOT_FULL:
			s = "This ID has enrolled the maximum iris slots.\nYou can not enroll more !";
			break;					
		case IddkResult.IDDK_GAL_ENROLL_DUPLICATED:
			s = "IDDK_GAL_ENROLL_DUPLICATED";
			break;					
		case IddkResult.IDDK_TPL_UNAVAILABLE:
			s = "IDDK_TPL_UNAVAILABLE";
			break;				
		case IddkResult.IDDK_TPL_CORRUPTED:
			s = "IDDK_TPL_CORRUPTED";
			break;				
		case IddkResult.IDDK_TPL_GENERATION_FAILED:
			s = "IDDK_TPL_GENERATION_FAILED";
			break;		  
		case IddkResult.IDDK_TPL_COMPARISON_FAILED:
			s = "IDDK_TPL_COMPARISON_FAILED";
			break;	
		case IddkResult.IDDK_TPL_TYPE_INVALID:
			s = "IDDK_TPL_TYPE_INVALID";
			break;				
		case IddkResult.IDDK_ALG_VERSION_INVALID:
			s = "IDDK_ALG_VERSION_INVALID";
			break;			
		case IddkResult.IDDK_ALG_FAILED:
			s = "IDDK_ALG_FAILED";
			break;					
		case IddkResult.IDDK_ALG_NOT_INIT:
			s = "IDDK_ALG_NOT_INIT";
			break;
		default:
			s = "Unexpected error";
		}
		
		return s;
	}
	
	public static void sleep(long miliSec)
	{
		try 
		{
			Thread.sleep(miliSec);
		} 
		catch (InterruptedException e) 
		{
			//hope this this will not happen
			e.printStackTrace();
		}
	}
	
	public static void SaveBin(String fileName, byte[] outRawImage)
    {
		try
	     {
			FileOutputStream fos = new FileOutputStream(fileName);
			fos.write(outRawImage);
			fos.close(); 
	     }
	     catch(FileNotFoundException ex)
	     {
	    	 System.out.println("FileNotFoundException : " + ex);
	     }
	     catch(IOException ioe)
	     {
	    	 System.out.println("IOException : " + ioe);
	     }
    }
}
