package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    private final int x;
    private final int y;
    private final Job2dDriver jobDriver;

    public OperateToCommand(int x, int y, Job2dDriver jobDriver) {
        this.x = x;
        this.y = y;
        this.jobDriver = jobDriver;
    }

    @Override
    public void execute() {
        this.jobDriver.operateTo(this.x, this.y);
    }
}
