package bus;

import publictransportation.publicTransportation;

public class Bus extends publicTransportation {
    int passengerCountNow;
    int passengerCountMax;  // 고정값
    double refueledNow;
    int busNumber;  // 고유값?
    int cost;  // 고정값
    String workNow;
    String alert;

    Bus(int busNumber, int passengerCountNow){
        super();
        this.passengerCountNow = passengerCountNow;
        this.passengerCountMax =  30;
        this.refueledNow = 100;
        this.cost = 1000;
        this.busNumber = busNumber;
    }

    public void transportationOperate(boolean operation, double refueledUse, double refuelCharging){
        refueledNow = refueledNow  - refueledUse + refuelCharging;
            if(refueledNow == 0 || !operation){
                workNow="차고지행";
                }
            else if(refueledNow < 10){
                workNow="차고지행";
                alert = "*alert* 주유 필요";
            }
            else {
                workNow="운행";
            }
    }

    public void onBoard(String workNow, int passengerCountNew){
        if (workNow.equals("운행") && (passengerCountNow + passengerCountNew) < passengerCountMax){
            cost = 1000;
            passengerCountNow += passengerCountNew;
            cost = passengerCountNew*cost;
        }
        else {
            passengerCountNow = 0;
            alert = "*alert* 최대 승객 수 초과";
        }
    }

    public void speedChange(double refueledNow, double speedNow, double acceleratedSpeed){
        System.out.println("현재 주유량: "+ refueledNow);
        if(refueledNow < 10){
            System.out.print("*경고* 주유량을 확인해주세요.");
        }
        speedNow += acceleratedSpeed;
        System.out.println("현재 속도는 "+speedNow+" km/h 입니다.");
        System.out.println();
    }

    public static void main(String[] args) {
        Bus bus1 = new Bus(606, 0 );
        System.out.println("*알림* " + bus1.busNumber+"번 버스가 생성됐습니다.");
        Bus bus2 = new Bus(6631, 0);
        System.out.println("*알림* " + bus2.busNumber+"번 버스가 생성됐습니다.");
        bus1.onBoard("운행",  2);
        System.out.println("탑승 승객 수: "+bus1.passengerCountNow);
        System.out.println("잔여 승객 수: "+(bus1.passengerCountMax-bus1.passengerCountNow));
        System.out.println("요금 확인: " + bus1.cost);
        bus1.transportationOperate(true, 50, 0);
        System.out.println("주유량: "+ bus1.refueledNow);
        bus1.transportationOperate(false, 0, 10);
        System.out.println("상태: " + bus1.workNow);
        System.out.println("주유량: " + bus1.refueledNow);
        bus1.transportationOperate(true, 0, 0);
        bus1.onBoard("운행", 45);
        System.out.println(bus1.alert);
        bus1.onBoard("운행", 5);
        System.out.println("탑승 승객 수: "+bus1.passengerCountNow);
        System.out.println("잔여 승객 수: "+(bus1.passengerCountMax-bus1.passengerCountNow));
        System.out.println("요금: "+bus1.cost);
        bus1.transportationOperate(true, 55, 0);
        System.out.println("주유량: "+ bus1.refueledNow);
        System.out.println("상태: " + bus1.workNow);
        System.out.println(bus1.alert);
    }
}
