package bus;

public class Bus {
    int passengerCountNow;
    int passengerCountMax =  45;  // 고정값
    int cost = 1200;  // 고정값
    int busNumber;  // 고유값?
    double refueledNow;  
    double speedNow;
    double acceleratedSpeed;
    boolean operation = true;
    String workNow = "운행";
    
    Bus(int passengerCountNow, int busNumber, double refueledNow, double speedNow, boolean operation, String workNow, double acceleratedSpeed){
       this.passengerCountNow = passengerCountNow;
       this.busNumber = busNumber;
       this.refueledNow = refueledNow;
       this.speedNow = speedNow;
       this.acceleratedSpeed = acceleratedSpeed;
       this.operation = operation;
       this.workNow = workNow;
    }
    
    // 버스 상태 변경 운행
    public void busOperate(boolean operation, double refueledNow){
            if(refueledNow == 0 || !operation){
                workNow="차고지행";
                System.out.println("해당 버스는 "+workNow+" 상태 입니다.");
                ;}
            if(refueledNow<10){
                System.out.println("주유가 필요합니다.");
            }
    }

    // 승객 탑승
    public void onBoard(int passengerCountNow, int passengerCountMax, boolean operation){
        if (workNow.equals("운행중") && passengerCountNow < passengerCountMax){
            passengerCountNow  ++;
        }
    }
    
    // 속도 변경
    public void speedChange(double refueledNow, double speedNow, double acceleratedSpeed){
        if(refueledNow < 10){
            System.out.print("주요량을 확인해주세요.");
        }
        speedNow = speedNow + acceleratedSpeed;
    } 


    public static void main(String[] args) {
//        Bus bus1 = new Bus();
    }
}
