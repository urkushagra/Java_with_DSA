public class ExamScheduler {
    private int n;
    private boolean[][] schedule;

    public ExamScheduler(int n) { this.n=n; schedule=new boolean[n][n]; }

    private boolean isSafe(int day, int slot){
        for(int i=0;i<day;i++) if(schedule[i][slot]) return false;
        return true;
    }

    public boolean scheduleExams(int day){
        if(day==n) return true;
        for(int slot=0;slot<n;slot++){
            if(isSafe(day,slot)){
                schedule[day][slot]=true;
                if(scheduleExams(day+1)) return true;
                schedule[day][slot]=false;
            }
        }
        return false;
    }

    public void printSchedule(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) System.out.print(schedule[i][j]?"E ":"- ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        ExamScheduler es = new ExamScheduler(4);
        if(es.scheduleExams(0)) es.printSchedule();
        else System.out.println("No valid schedule found");
    }
}
