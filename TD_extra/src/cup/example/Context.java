package cup.example;

public final class Context {
	private static String context;
	
	public static String getContext() {
		return context;
	}
	
	public static void setContext(String value) {
		context = value;
	}
}
