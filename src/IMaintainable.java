import util.DateTime;

public interface IMaintainable {
	public boolean performMaintenance();
	public boolean completeMaintenance(DateTime completionDate);
}
