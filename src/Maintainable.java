import util.DateTime;

public interface Maintainable {
	public boolean performMaintenance();
	public boolean completeMaintenance(DateTime completionDate);
}
