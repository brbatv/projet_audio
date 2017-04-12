package projet_audio;

public abstract class ModuleAbstract {
	
	static int SAMPLE_FREQ=44100;
	String nom;
	CommunicationPort[] inputPorts ;
	CommunicationPort[] outputPorts ;
	
	public ModuleAbstract(int in, int out, String name)
	{
		nom=name;
		inputPorts= new CommunicationPort[in] ;
		outputPorts = new CommunicationPort[out] ;
		
		for (int i=0; i<in ; i++) // entrees
		{inputPorts[i]=new CommunicationPort(i,this);}
		
		for (int j=0; j<out ; j++) // sorties
		{outputPorts[j]=new CommunicationPort(j,this);}
		
		
	}
	
	String getName()
	{
		return this.nom;
	}
	
	static Connexion connect(ModuleAbstract mOutput, int idOutputPort, ModuleAbstract mInput, int idInputPort)
	{
		Connexion c=new Connexion(mOutput.outputPorts[idOutputPort], mInput.inputPorts[idInputPort]);
		
		return c;
	}

	
	void setAndSendOutputPortValue(int idOutputPort, double sample)
	{
		this.outputPorts[idOutputPort].setValue(sample);
		
		if (this.outputPorts[idOutputPort].isConnected() ) // si connecté, envoyer sample 
		{	System.out.println("connected : communication");
			this.outputPorts[idOutputPort].c.communicate();
		}
	}
	
	double getInputPortValue(int idInput)
	{
		return this.inputPorts[idInput].getValue();
	}
	
	void setInputPortValue(int idInput, double sample)
	{
		this.inputPorts[idInput].setValue(sample);
	}
	
	public abstract String toString();
	
	public abstract void exec();
	
	public static void main(String[] args) {
		GenSineBasic gen=new GenSineBasic("gen",442,1);
		AudioDataReceiver output=new AudioDataReceiver("output");
		Connexion uno = new Connexion (gen.outputPorts[0],output.inputPorts[0]);
		while (gen.n <= 220500)
		{
			gen.exec();
			output.exec();
		}
		output.toString();
		output.displayAudioDataWaveform();
		
				
	}

}
