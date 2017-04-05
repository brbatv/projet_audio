package projet_audio;

public class Connexion {
	CommunicationPort upModulePort; // sortie
	CommunicationPort downModulePort; // entree
	
	public Connexion (CommunicationPort up, CommunicationPort down)
	{
		upModulePort=up; // s 
		downModulePort=down; // e
	}
	
	void communicate ()
	{
		downModulePort.sampleValue=upModulePort.getValue();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
