package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String figure = e.getActionCommand().toLowerCase();
		switch (figure){
			case "figure joe 1":
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;

			case "figure joe 2":
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;

			case "jane":
				FiguresJane.figureScript(new edu.kis.powp.jobs2d.drivers.adapter.JaneDriver(driverManager.getCurrentDriver()));
				break;

			case "command triangle":
				new SetPositionCommand(-120,-120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(120, -120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(120, 120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(-120, -120, driverManager.getCurrentDriver()).execute();
				break;

			case "command triangle (complex)":
				ComplexCommand complex = new ComplexCommand();
				complex.add(new SetPositionCommand(-120,-120, driverManager.getCurrentDriver()));
				complex.add(new OperateToCommand(120, -120, driverManager.getCurrentDriver()));
				complex.add(new OperateToCommand(120, 120, driverManager.getCurrentDriver()));
				complex.add(new OperateToCommand(-120, -120, driverManager.getCurrentDriver()));
				complex.execute();
				break;

			case "command triangle (factory)":
				edu.kis.powp.command.CommandFactory.Triangle(driverManager.getCurrentDriver()).execute();
				break;

			case "command rectangle (factory)":
				edu.kis.powp.command.CommandFactory.Rectangle(driverManager.getCurrentDriver()).execute();
				break;
		}
	}
}
