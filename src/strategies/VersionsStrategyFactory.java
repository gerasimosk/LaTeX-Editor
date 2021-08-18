package strategies;

public class VersionsStrategyFactory {
	public VersionsStrategyFactory() {}
	
	public VersionsStrategy createStrategy(String name) {
		switch(name) {
		case "VolatileVersionsStrategy":
			return new VolatileVersionsStrategy();
		case "StableVersionsStrategy":
			return new StableVersionsStrategy();
		default:
			return null;
			
		}
	}
	
}
