package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory {
    public static DriverCommand Triangle(Job2dDriver driver) {
        ComplexCommand complex = new ComplexCommand();
        complex.add(new SetPositionCommand(-120,-120, driver));
        complex.add(new OperateToCommand(120, -120, driver));
        complex.add(new OperateToCommand(120, 120, driver));
        complex.add(new OperateToCommand(-120, -120, driver));
        return complex;
    }

    public static DriverCommand Rectangle(Job2dDriver driver) {
        ComplexCommand complex = new ComplexCommand();
        complex.add(new SetPositionCommand(-120,-120, driver));
        complex.add(new OperateToCommand(120, -120, driver));
        complex.add(new OperateToCommand(120, 120, driver));
        complex.add(new OperateToCommand(-120, 120, driver));
        complex.add(new OperateToCommand(-120, -120, driver));
        return complex;
    }

}
