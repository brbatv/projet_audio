package projet_audio;

import static java.lang.Math.* ;




public class GenSineBasic extends ModuleAbstract {
	
	int f;
	int amp;
	int n=0;
	
	public GenSineBasic(String nom, int freq, int amp)
	{
		super(0,1,nom);
		this.amp=amp;
		this.f=freq;
	}
	
	@Override
	public void exec()
	{double e=amp*sin(2*3.14*f*n/SAMPLE_FREQ);
	setAndSendOutputPortValue(0,e);
	n=n+1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
