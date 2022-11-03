
interface Device {
	
	public void louder();
	
	public void quieter();
	
	public int getVolume();
	
	public void next();
	
	public void prev();
	
	public String getInfotext();
	
	public String[] getOptions();
	
	public void chooseOption(String opt);
	
	public String play();

}
