package report;

import publictransportation.publicTransportation;

public class Bus extends publicTransportation {
    private static int serialNum = 0;
    private int passengerCountNow;
    final int passengerCountMax;
    private static int refueledNow = 100;
    final int COST = 1000;  // 고정값
    private int cost;
    boolean operation;
    String workNow;

    Bus() {
        super();
        this.cost = 0;
        this.operation = true;
        this.passengerCountNow = 0;
        this.passengerCountMax = 30;
    }

    public void busNumCheck() {
        Bus.serialNum += 1;
        System.out.println(Bus.serialNum + "번 버스객체 생성!");
    }

    public static int chargingState(int refueledUse, int refueledCharging) {
        refueledNow = refueledNow - refueledUse + refueledCharging;
        return refueledNow;
    }

    public void refuelCheck(int refueledNow) {
        System.out.println("주유량: " + refueledNow + "입니다.");
    }

    public String busOperate(boolean operation) {
        if (!operation || refueledNow < 10) {
            workNow = "차고지행";
        } else {
            workNow = "운행";
        }
        return workNow;
    }

    public void busWhere(String workNow) {
        if (refueledNow < 10) {
            System.out.println("상태: " + workNow);
            System.out.println("*alert* 주유 필요");
        } else {
            System.out.println("상태: " + workNow);
        }
    }

    public void onBoard(String workNow, int passengerCountNew) {
            int sum = passengerCountNow + passengerCountNew;
            int vacancy = passengerCountMax - sum;
            if (sum > passengerCountMax) {
                passengerCountNow = 0;
                System.out.println("*alert* 최대 승객 수 초과");
            } else {
                System.out.println("탑승 승객: " + passengerCountNew + "명 입니다.");
                // 문제가 있어요 맞슴당;
                cost = passengerCountNew * COST;
                System.out.println("잔여 승객 수: " + vacancy + "명 입니다.");
                System.out.println("요금: " + cost + "원 입니다.");
            }
        }
    }
