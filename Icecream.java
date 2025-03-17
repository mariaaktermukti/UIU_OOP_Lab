public class Icecream
{
    String icecreamType;
    String icecreamCompany;
    double icecreamPrice;

    public Icecream(String icecreamType, String icecreamCompany, double icecreamPrice)
    {
        this.icecreamType = icecreamType;
        this.icecreamCompany = icecreamCompany;
        this.icecreamPrice = icecreamPrice;
    }

    public String tostring(){
        return this.icecreamType + " " + this.icecreamCompany +
                " "+ this.icecreamPrice;
    }

    public boolean equals(Icecream I)
    {
        if(I.icecreamType.equals(this.icecreamType) &&
                I.icecreamCompany.equals(this.icecreamCompany)&&
                I.icecreamPrice == this.icecreamPrice)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}