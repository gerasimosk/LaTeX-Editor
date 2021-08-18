package controller;

public class CommandsFactory {
	public CommandsFactory() {}
	
	public Command createCommand(String en) {
		switch(en) {
		case "create":
			return new CreateCommand();
		case "add":
			return new AddLatexCommand();
		case "rollback":
			return new RollbackToPreviousVersionCommand();
		case "edit":
			return new EditCommand();
		case "load":
			return new LoadCommand();
		case "save":
			return new SaveCommand();
		case "enable":
			return new EnableVersionsManagementCommand();
		case "disable":
			return new DisableVersionsManagementCommand();
		case "change":
			return new ChangeVersionsStrategyCommand();
		case "export":
			return new ExportToPDFCommand();
		default:
			System.out.println("Error, no command");
			return null;
		}
	}
}
