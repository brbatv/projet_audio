package projet_audio;

public class CommunicationPort {
	
	int idPort;
	double sampleValue;
	ModuleAbstract module;
	Connexion c ;
	
	public CommunicationPort(int id, ModuleAbstract m)
	{
		idPort=id;
		module=m;
		c=null;
		
	}

	double getValue()
	{
		return this.sampleValue;
	}
	
	void setValue(double v)
	{
		this.sampleValue=v;
	}
	
	boolean isConnected()
	{
		if (c!=null) {return true;}
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
