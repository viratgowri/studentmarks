import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.lang.model.util.ElementScanner14;
public class studentReportingSystem {
    static ArrayList<student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        
        do{
            System.out.println("\nselect the option");
            System.out.println("1.Add Student\n2.Add marks\n3.Display Reports\n4.Exit");
            int opt=scan.nextInt();
            switch(opt)
            {
                case 1:System.out.println("Enter the name: ");
                        String name=scan.nextLine();
                        String n=scan.nextLine();
                        System.out.println("Enter the id: ");
                        String id=scan.nextLine();
                        students.add(new student(name,id));
                        break;
                case 2: System.out.println("Enter the student id:");
                        id=scan.next();
                        int stuExists=checkStudentExists(id);
                        if(stuExists>=0)
                         {
                            System.out.println("Choose semester:");
                            System.out.println("1.semester1 : ");
                            System.out.println("2.semester2 : ");
                            int sem=scan.nextInt();
                            switch(sem)
                            {
                                case 1: students.get(stuExists).setSemOneMarks(getMarksInput());
                                        break;
                                case 2: students.get(stuExists).setSemTwoMarks(getMarksInput());
                                        break;
                            }
                         }   
                        else
                            System.out.println("Given student does not exists");
                        break;
                case 3: System.out.println("***Reports***");
                        if(getRecentSem()==1)
                		    System.out.println("Avg percentage of whole class in sem1 : "+getSemOneAvgMarksOfWholeClass());
                        else 
                            System.out.println("Avg percentage of whole class in sem2 : "+getSemTwoAvgMarksOfWholeClass());

                		System.out.println("\nAvg marks of studnets in English in sem1 : "+getSemOneAvgMarksOfEnglish());
                		System.out.println("Avg marks of studnets in Maths in sem1 : "+getSemOneAvgMarksOfMaths());
                		System.out.println("Avg marks of studnets in Science in sem1 : "+getSemOneAvgMarksOfScience());
                		System.out.println("Avg marks of studnets in English in sem2 : "+getSemTwoAvgMarksOfEnglish());
                		System.out.println("Avg marks of studnets in Maths in sem2 : "+getSemTwoAvgMarksOfMaths());
                		System.out.println("Avg marks of studnets in Science in sem2 : "+getSemTwoAvgMarksOfScience());
                        
                        HashMap<String,Double> topTwoConsistentStudents = getTopTwoConsistentStudents();
                        System.out.println("\nTop 2 consistent students across all the semesters : ");
                        for (Map.Entry<String, Double> entry : topTwoConsistentStudents.entrySet())
                            System.out.println(entry.getKey()+" with average marks "+entry.getValue());
                		break;
                        
                case 4:return;
                        
                            
                        
            }
        }while(true);
    }
    public static HashMap<String,Double> getTopTwoConsistentStudents()
    {
        HashMap<String,Double> totalAvgMarksOfStudents=new HashMap<>();
        HashMap<String,Double> topTwoConsistentStudents=new HashMap<String,Double>();
        for(student stu:students)
            totalAvgMarksOfStudents.put(stu.getId(),(stu.getSemOneMarksSum()+stu.getSemTwoMarksSum())/6.0);
        HashMap<String,Double>sortedValues = sortByValue(totalAvgMarksOfStudents,false);
        int count=0;
        for (Map.Entry<String, Double> entry : topTwoConsistentStudents.entrySet())
        {
            topTwoConsistentStudents.put(entry.getKey(),entry.getValue());
            count++;
            if(count>1)
                break;
        }
        return topTwoConsistentStudents;
    }
    private static HashMap<String, Double> sortByValue(Map<String, Double> unsortMap, final boolean order)
    {
        List<Entry<String, Double>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }
    public static int getRecentSem()
    {
        for(student stu:students)
            if(stu.getSemTwoMarksSum()>0)
                return 2;
    	return 1;
    }
    public static double getSemOneAvgMarksOfEnglish()
    {
    	int sum=0;
    	for(student stu:students)
            sum+=stu.getSemOneMarks()[0];
    	return (sum*1.0)/students.size();
    }
    public static double getSemOneAvgMarksOfMaths()
    {
    	int sum=0;
    	for(student stu:students)
            sum+=stu.getSemOneMarks()[1];
    	return (sum*1.0)/students.size();
    }
    public static double getSemOneAvgMarksOfScience()
    {
    	int sum=0;
    	for(student stu:students)
            sum+=stu.getSemOneMarks()[2];
    	return (sum*1.0)/students.size();
    }
    public static double getSemTwoAvgMarksOfEnglish()
    {
    	int sum=0;
    	for(student stu:students)
            sum+=stu.getSemTwoMarks()[0];
    	return (sum*1.0)/students.size();
    }
    public static double getSemTwoAvgMarksOfMaths()
    {
    	int sum=0;
    	for(student stu:students)
            sum+=stu.getSemTwoMarks()[1];
    	return (sum*1.0)/students.size();
    }
    public static double getSemTwoAvgMarksOfScience()
    {
    	int sum=0;
    	for(student stu:students)
            sum+=stu.getSemTwoMarks()[2];
    	return (sum*1.0)/students.size();
    }
    public static double getSemOneAvgMarksOfWholeClass()
    {
        int sum=0;
        for(student stu:students)
            sum+=stu.getSemOneMarksSum();
        return ((sum*1.0)/(students.size()*300))*100;
    }
    public static double getSemTwoAvgMarksOfWholeClass()
    {
        int sum=0;
        for(student stu:students)
            sum+=stu.getSemTwoMarksSum();
        return ((sum*1.0)/(students.size()*300))*100;
    }
    public static int[] getMarksInput()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter marks of English: ");
        int me=scan.nextInt();
        System.out.println("Enter marks of Maths: ");
        int mm=scan.nextInt();
        System.out.println("Enter marks of Science: ");
        int ms=scan.nextInt();
        int marks[]={me,mm,ms};
        return marks;
    }
    public static int checkStudentExists(String id)
    {
        for(int i=0;i<students.size();i++)
        {
            if(students.get(i).getId().equals(id))
                return i;
            
        }
        return -1;
    }
}
