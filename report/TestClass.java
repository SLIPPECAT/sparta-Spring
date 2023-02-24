package report;

import static report.Bus.chargingState;

public class TestClass {
    public static void main(String[] args) { //
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        bus1.busNumCheck();
        bus2.busNumCheck();
        bus1.onBoard(bus2.busOperate(true), 2);
        bus1.refuelCheck(chargingState(50, 0));
        bus1.busWhere(bus1.busOperate(false));
        bus1.refuelCheck(chargingState(0,10));
        bus1.onBoard(bus1.busOperate(true), 45);
        bus1.onBoard(bus1.busOperate(true), 5);
        bus1.refuelCheck(chargingState(55, 0));
        bus1.busWhere(bus1.busOperate(true));
    }
}