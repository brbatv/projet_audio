package projet_audio;

public class Connexion {
	CommunicationPort upModulePort; // sortie
	CommunicationPort downModulePort; // entree
	
	public Connexion (CommunicationPort up, CommunicationPort down)
	{
		upModulePort=up; // sortie 
		downModulePort=down; // entree
		downModulePort.c=this;
		upModulePort.c=this;
		
	}
	
	void communicate ()
	{
		downModulePort.sampleValue=upModulePort.getValue();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
