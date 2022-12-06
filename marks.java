public class marks {
    int sem1[]=new int[3];
    int sem2[]=new int[3];
    public marks(){}
    
    public void setSemOneEnglishMarks(int em){this.sem1[0]=em;}
    public void setSemOneMathsMarks(int em){this.sem1[1]=em;}
    public void setSemOneScienceMarks(int em){this.sem1[2]=em;}
    public void setSemTwoEnglishMarks(int em){this.sem2[0]=em;}
    public void setSemTwoMathsMarks(int em){this.sem2[1]=em;}
    public void setSemTwoScienceMarks(int em){this.sem2[2]=em;}

    public int getSemOneEnglishMarks(){return this.sem1[0];}
    public int getSemOneMathsMarks(){return this.sem1[1];}
    public int getSemOneScienceMarks(){return this.sem1[2];}
    public int getSemTwoEnglishMarks(){return this.sem2[0];}
    public int getSemTwoMathsMarks(){return this.sem2[1];}
    public int getSemTwoScienceMarks(){return this.sem2[2];}
    
    public void setSemOneMarks(int marks[]){
        for(int i=0;i<3;i++)
            sem1[i]=marks[i];
    }
    public void setSemTwoMarks(int marks[]){
        for(int i=0;i<3;i++)
            sem2[i]=marks[i];
    }
    public int[] getSemOneMarks(){return this.sem1;}
    public int[] getSemTwoMarks(){return this.sem2;}

    
}
