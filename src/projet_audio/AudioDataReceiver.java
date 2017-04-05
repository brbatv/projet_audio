package projet_audio;

import java.io.IOException;

import phelmaaudio.AudioData;
import phelmaaudio.WavFileException;

public class AudioDataReceiver extends ModuleAbstract {
	
	AudioData popo= new AudioData();

	public AudioDataReceiver(String name)
	{
		super(1,1,name);
	}
	
	public void exec()
	{
		double v=getInputPortValue(0); // recup echantillon en entree
		popo.addSample(v); // le stocke dans la collection 
		setAndSendOutputPortValue(0,v);
	}
	
	void saveAudioDataToWavFile(String name) throws IOException, WavFileException
	{
		popo.saveAudioDataToWavFileNormalized(name);
	}
	
	void displayAudioDataWaveform()
	{
		popo.display();;
	}

	void playAudioData()
	{
		popo.play();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
