package publictransportation;

public class publicTransportation {
    int transportNumber;  // 고유값?
    double refueledNow;
    double refuelCharging; // 활성화 안 된 애들...
    double speedNow;
    double acceleratedSpeed;
    int passengerCountNow;
    int passengerCountMax;  // 고정값
    int cost;  // 고정값
    boolean operation;
    String workNow;
    String alert;

    public publicTransportation(){
        refueledNow = 100;
        speedNow = 0;
        workNow = "운행";
        operation = true;
        alert = "";
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
            passengerCountNow += passengerCountNew;
        }
        else {
            passengerCountNow = 0;
            alert = "*alert* 최대 승객 수 초과";
        }
    }

    public void speedChange(double refueledNow, double speedNow, double acceleratedSpeed){
        System.out.println("현재 주유량: "+ refueledNow);
        if(refueledNow < 10){
           alert = "*경고* 주유량을 확인해주세요.";
        }
        speedNow += acceleratedSpeed;
        alert = "현재 속도는 "+speedNow+" km/h 입니다.";
    }
}
