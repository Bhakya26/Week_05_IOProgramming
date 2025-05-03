class LegacyAPI{
	@Deprecated
	public static void oldFeature() {
		System.out.println("This is the old method(deprecated)");
	}
	public static void newFeature() {
		System.out.println("This is the new and updated method");
	}
	
}
public class DeprecatedTest {
	public static void main(String[] args) {
		LegacyAPI.oldFeature();
		LegacyAPI.newFeature();
		
	}

}
