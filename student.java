public class student {
    String name;
    String id;
    marks Marks;
    public student(String name,String id)
    {
        this.name=name;
        this.id=id;
        Marks=new marks();
    }
    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}
    public void setId(String id){this.id=id;}
    public void setSemOneMarks(int marks[])
    {
        Marks.setSemOneMarks(marks);
    }
    public void setSemTwoMarks(int marks[])
    {
        Marks.setSemTwoMarks(marks);
    }
    public int[] getSemOneMarks()
    {
        return Marks.getSemOneMarks();
    }
    public int[] getSemTwoMarks()
    {
        return Marks.getSemTwoMarks();
    }
    public int getSemOneMarksSum()
    {
        int m[]=getSemOneMarks();
        int sum=0;
        for(int i=0;i<m.length;i++)
            sum+=m[i];
        return sum;
    }
    public int getSemTwoMarksSum()
    {
        int m[]=getSemTwoMarks();
        int sum=0;
        for(int i=0;i<m.length;i++)
            sum+=m[i];
        return sum;
    }
}
