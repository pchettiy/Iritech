package com.iritech.iddk.demo;

import com.iritech.iddk.android.*;

public class IddkCaptureInfo 
{
	private IddkCaptureOperationMode captureOperationMode;
	private int	compressionQuality;
	private IddkCaptureMode	captureMode;
	private int	count;
	private IddkQualityMode qualitymode;

	private boolean isSaveStream; 	
	private boolean isSaveBest; 		
	private String prefixName;
	private boolean isShowStream;
	
	public IddkCaptureInfo()
	{
		captureOperationMode = new IddkCaptureOperationMode(IddkCaptureOperationMode.IDDK_AUTO_CAPTURE);
		captureMode = new IddkCaptureMode(IddkCaptureMode.IDDK_TIMEBASED);
		count = 3;
		compressionQuality = 100;
		qualitymode = new IddkQualityMode(IddkQualityMode.IDDK_QUALITY_NORMAL);
		isSaveStream = false;
		isSaveBest = false;
		prefixName = "";
		isShowStream = false;
	}
	
	public IddkCaptureInfo(	int captureOperationMode,
							int	compressionQuality,
							int	captureMode,
							int	count,
							int qualitymode,
							boolean isSaveStream,
							boolean isSaveBest,
							String prefixName,
							boolean isShowStream)
	{
		this.captureOperationMode = new IddkCaptureOperationMode(captureOperationMode);
		this.compressionQuality = compressionQuality;
		this.captureMode = new IddkCaptureMode(captureMode);
		this.count = count;
		this.qualitymode = new IddkQualityMode(qualitymode);
		this.isSaveStream = isSaveStream;
		this.isSaveBest = isSaveBest;
		this.prefixName = prefixName;
		this.isShowStream = isShowStream;
	}
	
	public void setInitValues(
							int captureOperationMode,
							int	compressionQuality,
							int	captureMode,
							int	count,
							int qualitymode,
							boolean isSaveStream,
							boolean isSaveBest,
							String prefixName,
							boolean isShowStream)
	{
		this.captureOperationMode = new IddkCaptureOperationMode(captureOperationMode);
		this.compressionQuality = compressionQuality;
		this.captureMode = new IddkCaptureMode(captureMode);
		this.count = count;
		this.qualitymode = new IddkQualityMode(qualitymode);
		this.isSaveStream = isSaveStream;
		this.isSaveBest = isSaveBest;
		this.prefixName = prefixName;
		this.isShowStream = isShowStream;
	}
		
	public String getPrefixName()
	{
		return this.prefixName;
	}
	
	public void setPrefixName(String prefixName)
	{
		if (prefixName.length() >= 32) this.prefixName = prefixName.substring(0, 31);
		else this.prefixName = prefixName;
	}
	
	public IddkCaptureOperationMode getCaptureOperationMode()
	{
		return this.captureOperationMode;
	}
	
	public void setCaptureOperationMode(int captureOperationMode)
	{
		this.captureOperationMode.setValue(captureOperationMode);
	}
	
	public int getCompressionQuality()
	{
		return this.compressionQuality;
	}
	
	public void setCompressionQuality(int compressionQuality)
	{
		this.compressionQuality = compressionQuality;
	}

	public IddkCaptureMode getCaptureMode()
	{
		return this.captureMode;
	}
	
	public void setCaptureMode(int captureMode)
	{
		this.captureMode = new IddkCaptureMode(captureMode);
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
	public IddkQualityMode getQualitymode()
	{
		return this.qualitymode;
	}
	
	public void setQualitymode(int qualitymode)
	{
		this.qualitymode = new IddkQualityMode(qualitymode);
	}
	
	public boolean isSaveStream()
	{
		return this.isSaveStream;
	}
	
	public void setSaveStream(boolean isSaveStream)
	{
		this.isSaveStream = isSaveStream;
	}
	
	public boolean isSaveBest()
	{
		return this.isSaveBest;
	}
	
	public void setSaveBest(boolean isSaveBest)
	{
		this.isSaveBest = isSaveBest;
	}
	
	public boolean isShowStream()
	{
		return this.isShowStream;
	}
	
	public void setShowStream(boolean isShowStream)
	{
		this.isShowStream = isShowStream;
	}
}
