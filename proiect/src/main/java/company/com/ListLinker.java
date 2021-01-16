package company.com;

public class ListLinker {

    public static Person head=null;

    void insert(String cod,String fn, String ln, String a, String gend, String adrs)
    {
        Person P1=new Person();
        P1.COD=cod;
        P1.first_name=fn;
        P1.last_name=ln;
        P1.age=a;
        P1.gender=gend;
        P1.address=adrs;
        P1.next=null;
        if(head==null)
        {
            head=P1;
        }
        else
        {
            Person n=head;
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next=P1;
        }
    }
}
