import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CD implements Device {

	public int volume = 0;

	@Override
	public void louder() {
		System.out.println("Increasing CD volume.");
		this.volume++;
	}

	@Override
	public void quieter() {
		System.out.println("Decreasing CD volume.");
		this.volume--;
	}

	@Override
	public int getVolume() {
		return this.volume;
	}

	@Override
	public void next() {
		System.out.println("Switching to next radio station with higher frequency!");
	}

	@Override
	public void prev() {
		System.out.println("Switching to next radio station with higher frequency!");
	}

	@Override
	public String getInfotext() {
		return "I`m your Radio...";
	}

	@Override
	public String[] getOptions() {

		Method[] availableOptions = CD.class.getDeclaredMethods();
		String[] options = new String[availableOptions.length];

		for (int i = 0; i < availableOptions.length; i++) {
			options[i] = availableOptions[i].getName();
		}

		return options;
	}

	@Override
	public void chooseOption(String opt) {

		Method[] methods = CD.class.getDeclaredMethods();

		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().contains(opt)) {
				// System.out.println(opt);
				try {
					methods[i].invoke(this, null);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			} else {
				continue;
			}
		}

	}

	@Override
	public String play() {
		return "Radio is playing...";
	}

	public void changeRadioStation() {
		System.out.println("You entered YouFM ==> Now playing YouFM :)");
	}

	public void changeRadioReceivingMethod() {
		System.out.println("Switched from AM to FM...");
	}

	public void addStationToFavourites() {
		System.out.println("This Radio Station was saved to your favourites.");
	}

}
